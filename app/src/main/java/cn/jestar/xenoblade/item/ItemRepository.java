package cn.jestar.xenoblade.item;

import android.content.Context;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import cn.jestar.xenoblade.base.BaseRepository;
import cn.jestar.xenoblade.utils.JsonUtils;

/**
 * Created by 花京院 on 2019/4/29.
 */

public class ItemRepository extends BaseRepository {
    private final String mFileName = "item.json";
    private List<CollectionItem> collections;
    private List<Goods> goods;
    private List<Eqiupment> jewelry;
    private List<Eqiupment> subCore;

    public ItemRepository(Context context) {
        try (InputStreamReader reader = getReader(context, mFileName)) {
            ItemRepository items = JsonUtils.readObject(reader, ItemRepository.class);
            collections = items.getCollections();
            goods = items.getGoods();
            jewelry = items.getJewelry();
            subCore = items.getSubCore();
        } catch (IOException e) {
            e.printStackTrace();
        }
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

    public List<Eqiupment> getJewelry() {
        return jewelry;
    }

    public void setJewelry(List<Eqiupment> jewelry) {
        this.jewelry = jewelry;
    }

    public List<Eqiupment> getSubCore() {
        return subCore;
    }

    public void setSubCore(List<Eqiupment> subCore) {
        this.subCore = subCore;
    }
}
