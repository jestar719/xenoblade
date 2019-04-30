package cn.jestar.xenoblade.blade;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import cn.jestar.xenoblade.AppRepository;
import cn.jestar.xenoblade.item.Goods;

/**
 * Created by 花京院 on 2019/4/29.
 */

public class BladeViewModel extends ViewModel {

    private final BladeRepository mBladeRepository;
    private List<BladeLoveItem> mLoveItems;
    private MutableLiveData<String> mSearchData = new MutableLiveData<>();

    public BladeViewModel() {
        AppRepository instance = AppRepository.getInstance();
        mBladeRepository = instance.getBladeRepository();
        List<Goods> goodsList = instance.getItemRepository().getGoods();
        HashMap<String,Goods> map=new HashMap<>();
        for (Goods goods : goodsList) {
            map.put(goods.getName(),goods);
        }
        mLoveItems = new ArrayList<>();
        for (FullBlade fullBlade : mBladeRepository.getFullBlades()) {
            BladeLove bladeLove = fullBlade.getBladeLove();
            String name = fullBlade.getName();
            List<Goods> loveItem = bladeLove.getLoveItem();
            for (Goods goods : loveItem) {
                BladeLoveItem item = new BladeLoveItem();
                item.setBlade(name);
                Goods goods1 = map.get(goods.getName());
                if (goods1==null){
                   goods1=goods;
                    Log.i("BladeViewModel",goods.getName());
                }
                item.setGoods(goods1);
                mLoveItems.add(item);
            }
        }
    }

    public List<Blade> getBlades() {
        return mBladeRepository.getBlades();
    }

    public LiveData<String> getSearchData() {
        return mSearchData;
    }

    public void onSearch(String query) {
        mSearchData.setValue(query);
    }

    public List<BladeLoveItem> getBladeLoves() {
        return mLoveItems;
    }
}
