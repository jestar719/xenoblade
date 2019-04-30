package cn.jestar.library.bean.blade;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.TypeConverter;

import java.util.ArrayList;
import java.util.List;

import cn.jestar.library.bean.BaseItem;
import cn.jestar.library.bean.BaseModel;
import cn.jestar.library.bean.Model;

/**
 * Created by 花京院 on 2019/4/17.
 */

public class BladeLove extends Model {
    private List<String> loveType;
    private List<BaseItem> loveItem;

    public List<String> getLoveType() {
        return loveType;
    }

    public void setLoveType(List<String> loveType) {
        this.loveType = loveType;
    }

    public List<BaseItem> getLoveItem() {
        return loveItem;
    }

    public void setLoveItem(List<BaseItem> loveItem) {
        this.loveItem = loveItem;
    }

    public void addLoveType(String type) {
        if (loveType == null) {
            loveType = new ArrayList<>();
        }
        loveType.add(type);
    }

    public void addLoveItem(BaseItem item) {
        if (loveItem == null) {
            loveItem = new ArrayList<>();
        }
        loveItem.add(item);
    }
}
