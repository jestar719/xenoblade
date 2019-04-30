package cn.jestar.xenoblade.blade;

import java.util.ArrayList;
import java.util.List;

import cn.jestar.xenoblade.base.BaseData;
import cn.jestar.xenoblade.item.Goods;

/**
 * Created by 花京院 on 2019/4/17.
 */

public class BladeLove extends BaseData{
    private List<String> loveType;
    private List<Goods> loveItem;

    public List<String> getLoveType() {
        return loveType;
    }

    public void setLoveType(List<String> loveType) {
        this.loveType = loveType;
    }

    public List<Goods> getLoveItem() {
        return loveItem;
    }

    public void setLoveItem(List<Goods> loveItem) {
        this.loveItem = loveItem;
    }

    public void addLoveType(String type) {
        if (loveType == null) {
            loveType = new ArrayList<>();
        }
        loveType.add(type);
    }

    public void addLoveItem(Goods item) {
        if (loveItem == null) {
            loveItem = new ArrayList<>();
        }
        loveItem.add(item);
    }
}
