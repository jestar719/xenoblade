package cn.jestar.xenoblade.item;


/**
 * Created by 花京院 on 2019/4/26.
 */

public class CollectionItem extends BaseItem {
    private int level;
    private String location;

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
