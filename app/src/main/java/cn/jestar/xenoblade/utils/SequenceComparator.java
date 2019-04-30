package cn.jestar.xenoblade.utils;

import android.support.annotation.NonNull;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by 花京院 on 2019/4/24.
 */

public abstract class SequenceComparator<T> implements Comparator<T> {
    protected LinkedList<NameComparator<T>> mList;
    protected Map<String, NameComparator<T>> mMap = new HashMap<>();

    public SequenceComparator() {
        reset();
        for (NameComparator<T> comparator : mList) {
            mMap.put(comparator.getName(), comparator);
        }
    }

    @NonNull
    protected abstract LinkedList<NameComparator<T>> getComparators();


    @Override
    public int compare(T o1, T o2) {
        int result = 0;
        for (NameComparator<T> comparator : mList) {
            result = comparator.compare(o1, o2);
            if (result != 0)
                break;
        }
        return result;
    }

    public void setSequence(String name) {
        NameComparator<T> comparator = mMap.get(name);
        mList.remove(comparator);
        mList.addFirst(comparator);
    }

    public void reset() {
        mList = getComparators();
    }
}
