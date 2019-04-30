package cn.jestar.xenoblade.blade;

import cn.jestar.xenoblade.base.BaseData;

/**
 * Created by 花京院 on 2019/4/22.
 */

public class MapSkill extends BaseData {
    private int level;

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return String.format("%s (%s)", name, level);
    }
}
