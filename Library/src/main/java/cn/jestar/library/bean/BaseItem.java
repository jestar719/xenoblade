package cn.jestar.library.bean;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.TypeConverter;

/**
 * Created by 花京院 on 2019/4/17.
 */

public class BaseItem extends Model {
    private String type;
    private String location;


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
