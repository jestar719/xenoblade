package cn.jestar.xenoblade.base;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.Collections;
import java.util.List;

import cn.jestar.xenoblade.utils.SequenceComparator;

/**
 * Created by 花京院 on 2019/4/29.
 */

public abstract class BaseAdapter<T> extends BaseQuickAdapter<T, BaseViewHolder> {

    protected SequenceComparator<T> mComparator = getComparator();

    public BaseAdapter(@Nullable List<T> data) {
        super(data);
    }

    public BaseAdapter(int layoutResId) {
        super(layoutResId);
    }

    public BaseAdapter(int layoutResId, @Nullable List<T> data) {
        super(layoutResId, data);
    }

    protected abstract SequenceComparator<T> getComparator();

    public void sort(String name) {
        mComparator.setSequence(name);
        sort();
    }

    private void sort() {
        Collections.sort(mData, mComparator);
        notifyDataSetChanged();
    }

    public void refresh() {
        mComparator.reset();
        sort();
    }

}
