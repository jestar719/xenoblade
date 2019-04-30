package cn.jestar.xenoblade.blade;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;

import java.util.List;

import cn.jestar.xenoblade.R;
import cn.jestar.xenoblade.base.BaseAdapter;
import cn.jestar.xenoblade.base.BaseListFragment;

import static cn.jestar.xenoblade.Constance.BLADE;

/**
 * Created by 花京院 on 2019/4/29.
 */

public class BladeListFragment extends BaseListFragment<Blade> {

    private BladeViewModel mModel;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        mModel.getSearchData().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String name) {
               onSearch(name);
            }
        });
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    protected int getSortList() {
        return R.array.blade_sort;
    }

    @Override
    protected void onItemClick(Blade item) {
        Intent intent = new Intent();
        intent.putExtra(BLADE, item.getName());
        intent.setClass(getContext(), BladeDetailActivity.class);
        startActivity(intent);
    }

    @Override
    protected BaseAdapter<Blade> getAdapter() {
        mModel = ViewModelProviders.of(getActivity()).get(BladeViewModel.class);
        List<Blade> blades = mModel.getBlades();
        Log.e("getBlades", blades.toString());
        return new BladeAdapter(blades);
    }

    @Override
    public String getName() {
        return BLADE;
    }

}
