package cn.jestar.xenoblade.blade;

import cn.jestar.xenoblade.base.BaseAdapter;
import cn.jestar.xenoblade.base.BaseListFragment;

import static cn.jestar.xenoblade.Constance.SUPER_SKILL;

/**
 * Created by 花京院 on 2019/4/30.
 */

public class SuperSkillFragment extends BaseListFragment<BladeSuperSkill> {
    @Override
    protected int getSortList() {
        return 0;
    }

    @Override
    protected void onItemClick(BladeSuperSkill item) {

    }


    @Override
    protected BaseAdapter getAdapter() {
        return null;
    }

    @Override
    public String getName() {
        return SUPER_SKILL;
    }
}
