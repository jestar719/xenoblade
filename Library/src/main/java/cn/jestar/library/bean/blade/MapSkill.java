package cn.jestar.library.bean.blade;

import android.arch.persistence.room.ColumnInfo;


import cn.jestar.library.bean.BaseModel;


/**
 * Created by 花京院 on 2019/4/22.
 */

public class MapSkill extends BaseModel{
    private int level;
    @ColumnInfo(name = "blade_id")
    private int bladeId;

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getBladeId() {
        return bladeId;
    }

    public void setBladeId(int bladeId) {
        this.bladeId = bladeId;
    }

    @Override
    public String toString() {
        return String.format("%s (%s)", name, level);
    }
}
