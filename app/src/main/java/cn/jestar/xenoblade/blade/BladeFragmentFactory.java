package cn.jestar.xenoblade.blade;

import java.util.HashMap;
import java.util.Map;

import cn.jestar.xenoblade.Constance;
import cn.jestar.xenoblade.base.BaseListFragment;

/**
 * Created by 花京院 on 2019/4/30.
 */

public class BladeFragmentFactory {
    private Map<String, BaseListFragment> mFragmentMap = new HashMap<>();

    public BaseListFragment getFragment(String name) {
        BaseListFragment fragment = mFragmentMap.get(name);
        if (fragment == null) {
            fragment = create(name);
            mFragmentMap.put(fragment.getName(), fragment);
        }
        return fragment;
    }

    private BaseListFragment create(String name) {
        switch (name) {
            case Constance.BLADE:
                return new BladeListFragment();
            case Constance.BLADE_LOVE:
                return new BladeLoveFragment();
            case Constance.MAP_SKILL:
                return new MapSkillFragment();
            case Constance.SUPER_SKILL:
                return new SuperSkillFragment();
        }
        return null;
    }
}
