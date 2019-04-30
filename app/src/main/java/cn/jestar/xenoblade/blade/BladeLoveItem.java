package cn.jestar.xenoblade.blade;

import cn.jestar.xenoblade.item.Goods;

/**
 * Created by 花京院 on 2019/4/30.
 */

public class BladeLoveItem extends Goods {
    private String blade;

    public String getBlade() {
        return blade;
    }

    public void setBlade(String blade) {
        this.blade = blade;
    }

    public void setGoods(Goods goods) {
        setType(goods.getType());
        setLocation(goods.getLocation());
        setName(goods.getName());
        setCondition(goods.getCondition());
        setEffect(goods.getEffect());
    }
}
