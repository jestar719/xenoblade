package cn.jestar.xenoblade.item;

/**
 * Created by 花京院 on 2019/4/30.
 */

public class Eqiupment extends BaseItem {
    private String effect;
    private String subType;

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }

    public String getSubType() {
        return subType;
    }

    public void setSubType(String subType) {
        this.subType = subType;
    }
}
