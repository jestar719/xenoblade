package cn.jestar.xenoblade.item;

import java.util.List;
import java.util.Map;

/**
 * Created by 花京院 on 2019/4/26.
 */

public class Items {
    private Map<String,Map<String,Map<String,String>>> equipment;
    private List<CollectionItem> collections;
    private List<Goods> goods;

    public Map<String, Map<String, Map<String, String>>> getEquipment() {
        return equipment;
    }

    public void setEquipment(Map<String, Map<String, Map<String, String>>> equipment) {
        this.equipment = equipment;
    }

    public List<CollectionItem> getCollections() {
        return collections;
    }

    public void setCollections(List<CollectionItem> collections) {
        this.collections = collections;
    }

    public List<Goods> getGoods() {
        return goods;
    }

    public void setGoods(List<Goods> goods) {
        this.goods = goods;
    }
}
