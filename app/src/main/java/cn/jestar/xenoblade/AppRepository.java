package cn.jestar.xenoblade;

import android.content.Context;

import cn.jestar.xenoblade.blade.BladeRepository;
import cn.jestar.xenoblade.item.ItemRepository;

/**
 * Created by 花京院 on 2019/4/29.
 */

public class AppRepository {


    private static final AppRepository INSTANCE = new AppRepository();
    private BladeRepository mBladeRepository;
    private ItemRepository mItemRepository;

    public static AppRepository getInstance() {
        return INSTANCE;
    }


    public void init(Context context) {
        mBladeRepository = new BladeRepository(context);
        mItemRepository = new ItemRepository(context);

    }

    public BladeRepository getBladeRepository() {
        return mBladeRepository;
    }

    public ItemRepository getItemRepository() {
        return mItemRepository;
    }
}
