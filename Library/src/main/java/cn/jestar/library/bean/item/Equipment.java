package cn.jestar.library.bean.item;

import cn.jestar.library.bean.Model;

/**
 * Created by 花京院 on 2019/4/30.
 */

public class Equipment extends Model {
    private String type;
    private String subType;
    private String effect;


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSubType() {
        return subType;
    }

    public void setSubType(String subType) {
        this.subType = subType;
    }

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }
}
