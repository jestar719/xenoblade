package cn.jestar.xenoblade.item;

/**
 * Created by 花京院 on 2019/4/26.
 */

public class Goods extends BaseItem {
    private String location;
    private String effect;
    private String condition;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }
}
