package cn.jestar.xenoblade.blade;

import cn.jestar.xenoblade.base.BaseAdapter;
import cn.jestar.xenoblade.base.BaseListFragment;

import static cn.jestar.xenoblade.Constance.MAP_SKILL;

/**
 * Created by 花京院 on 2019/4/30.
 */

public class MapSkillFragment extends BaseListFragment<MapSkill> {
    @Override
    protected int getSortList() {
        return 0;
    }

    @Override
    protected void onItemClick(MapSkill item) {

    }

    @Override
    protected BaseAdapter getAdapter() {
        return null;
    }

    @Override
    public String getName() {
        return MAP_SKILL;
    }
}
