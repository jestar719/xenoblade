package cn.jestar.library.bean;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * 数据的基类
 * Created by 花京院 on 2019/4/12.
 */

public abstract class BaseModel extends Model{
    protected int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
