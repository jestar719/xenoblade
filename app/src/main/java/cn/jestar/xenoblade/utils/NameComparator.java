package cn.jestar.xenoblade.utils;

import java.util.Comparator;

/**
 * Created by 花京院 on 2019/4/24.
 */

public abstract class NameComparator<T> implements Comparator<T> {
    private String name;

    public NameComparator(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
