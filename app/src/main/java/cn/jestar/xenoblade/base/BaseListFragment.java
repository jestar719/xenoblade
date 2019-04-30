package cn.jestar.xenoblade.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.ArrayRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.chad.library.adapter.base.BaseQuickAdapter;

import cn.jestar.xenoblade.R;

/**
 * Created by 花京院 on 2019/4/29.
 */

public abstract class BaseListFragment<T extends BaseData> extends Fragment {

    protected ArrayAdapter<CharSequence> mAdapter;
    protected BaseAdapter<T> mListAdapter;
    protected RecyclerView mRecycler;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.sortable_list, container, false);
        Spinner spinner = view.findViewById(R.id.spinner);
        mRecycler = view.findViewById(R.id.recycler);
        initRecycler(mRecycler);
        initSort(spinner);
        return view;
    }


    private void initSort(Spinner spinner) {
        Context context = spinner.getContext();
        mAdapter = ArrayAdapter.createFromResource(context,
                getSortList(), android.R.layout.simple_spinner_item);
        spinner.setAdapter(mAdapter);
        mAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                onSortSelect(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @ArrayRes
    protected abstract int getSortList();

    private void initRecycler(RecyclerView recycler) {
        recycler.setLayoutManager(new LinearLayoutManager(recycler.getContext(), LinearLayoutManager.VERTICAL, false));
        mListAdapter = getAdapter();
        recycler.setAdapter(mListAdapter);
        mListAdapter.setEnableLoadMore(false);
        mListAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                BaseListFragment.this.onItemClick(mListAdapter.getItem(position));
            }
        });
    }

    protected abstract void onItemClick(T item);

    protected void onSortSelect(int position) {
        if (position == 0) {
            mListAdapter.refresh();
        } else {
            mListAdapter.sort(mAdapter.getItem(position).toString());
        }
    }

    protected abstract BaseAdapter<T> getAdapter();

    protected void onSearch(String query) {
        int itemCount = mListAdapter.getItemCount();
        int position = 0;
        for (int i = 0; i < itemCount; i++) {
            String name1 = mListAdapter.getItem(i).getName();
            if (name1.equals(query)) {
                position = i;
                break;
            }
        }
        mRecycler.smoothScrollToPosition(position);
    }

    public abstract String getName();

    public void toTop() {
        mRecycler.smoothScrollToPosition(0);
    }
}
