package cn.jestar.xenoblade.blade;

import android.support.annotation.NonNull;

import java.util.LinkedList;

import cn.jestar.xenoblade.utils.NameComparator;
import cn.jestar.xenoblade.utils.SequenceComparator;

/**
 * Created by 花京院 on 2019/4/24.
 */

public class BladeComparator extends SequenceComparator<Blade> {

    @NonNull
    @Override
    protected LinkedList<NameComparator<Blade>> getComparators() {
        LinkedList<NameComparator<Blade>> list = new LinkedList<>();
        list.add(new NameComparator<Blade>("获取类型") {
            @Override
            public int compare(Blade o1, Blade o2) {
                int draw1 = o1.isDraw() ? 1 : 0;
                int draw2 = o2.isDraw() ? 1 : 0;
                return draw1 - draw2;
            }
        });
        list.add(new NameComparator<Blade>("出场时间") {
            @Override
            public int compare(Blade o1, Blade o2) {
                return o1.getFirstStage() - o2.getFirstStage();
            }
        });

        list.add(new NameComparator<Blade>("武器类型") {
            @Override
            public int compare(Blade o1, Blade o2) {
                return o1.getWeaponType().compareTo(o2.getWeaponType());
            }
        });
        list.add(new NameComparator<Blade>("战斗类型") {
            @Override
            public int compare(Blade o1, Blade o2) {
                return o1.getFightType().compareTo(o2.getFightType());
            }
        });
        list.add(new NameComparator<Blade>("属性") {
            @Override
            public int compare(Blade o1, Blade o2) {
                return o1.getElement().compareTo(o2.getElement());
            }
        });
        list.add(new NameComparator<Blade>("加成") {
            @Override
            public int compare(Blade o1, Blade o2) {
                return o1.getAttrPlusValue() - o2.getAttrPlusValue();
            }
        });

        return list;
    }
}
