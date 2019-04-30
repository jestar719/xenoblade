package cn.jestar.library.bean.item;

import cn.jestar.library.bean.BaseItem;

/**
 * Created by 花京院 on 2019/4/26.
 */

public class Goods extends BaseItem {
    private String effect;

    private String condition;

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }
}
