package cn.jestar.xenoblade.item;

import android.arch.lifecycle.ViewModel;

import cn.jestar.xenoblade.AppRepository;

/**
 * Created by 花京院 on 2019/4/29.
 */

public class ItemViewModel extends ViewModel {

    private final ItemRepository mRepository;

    public ItemViewModel() {
        mRepository = AppRepository.getInstance().getItemRepository();
    }
}
