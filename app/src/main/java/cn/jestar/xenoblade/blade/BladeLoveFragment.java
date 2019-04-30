package cn.jestar.xenoblade.blade;

import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseViewHolder;

import java.util.LinkedList;
import java.util.List;

import cn.jestar.xenoblade.R;
import cn.jestar.xenoblade.base.BaseAdapter;
import cn.jestar.xenoblade.base.BaseListFragment;
import cn.jestar.xenoblade.item.Goods;
import cn.jestar.xenoblade.utils.NameComparator;
import cn.jestar.xenoblade.utils.SequenceComparator;

import static cn.jestar.xenoblade.Constance.BLADE_LOVE;

/**
 * Created by 花京院 on 2019/4/30.
 */

public class BladeLoveFragment extends BaseListFragment<BladeLoveItem> {

    private BladeViewModel mModel;

    @Override
    protected int getSortList() {
        return R.array.blade_love_sort;
    }

    @Override
    protected void onItemClick(BladeLoveItem item) {

    }

    @Override
    protected BaseAdapter getAdapter() {
        mModel = ViewModelProviders.of(getActivity()).get(BladeViewModel.class);
        List<BladeLoveItem> loves = mModel.getBladeLoves();
        return new BladeLoveAdapter(loves);
    }

    @Override
    public String getName() {
        return BLADE_LOVE;
    }

    private class BladeLoveAdapter extends BaseAdapter<BladeLoveItem> {

        private String mNameTemp = "名称: %s 种类: %s";
        private String mBladeTemp = "异刃: %s 产地: %s";

        public BladeLoveAdapter(@Nullable List<BladeLoveItem> data) {
            super(R.layout.layout_item_goods, data);
        }

        @Override
        protected SequenceComparator<BladeLoveItem> getComparator() {
            return new BladeLoveComparator();
        }

        @Override
        protected void convert(BaseViewHolder helper, BladeLoveItem item) {
            String name = String.format(mNameTemp, item.getName(), item.getType());
            String blade = String.format(mBladeTemp, item.getBlade(), item.getLocation());
            helper.setText(R.id.tv_1, name)
                    .setText(R.id.tv_2, blade);
        }
    }

    private class BladeLoveComparator extends SequenceComparator<BladeLoveItem> {

        @NonNull
        @Override
        protected LinkedList<NameComparator<BladeLoveItem>> getComparators() {
            LinkedList<NameComparator<BladeLoveItem>> list = new LinkedList<>();
            list.add(new NameComparator<BladeLoveItem>("异刃") {
                @Override
                public int compare(BladeLoveItem o1, BladeLoveItem o2) {
                    return o1.getBlade().compareTo(o2.getBlade());
                }
            });
            list.add(new NameComparator<BladeLoveItem>("种类") {
                @Override
                public int compare(BladeLoveItem o1, BladeLoveItem o2) {
                    return o1.getType().compareTo(o2.getType());
                }
            });
            list.add(new NameComparator<BladeLoveItem>("地点") {
                @Override
                public int compare(BladeLoveItem o1, BladeLoveItem o2) {
                    return o1.getLocation().compareTo(o2.getLocation());
                }
            });
            list.add(new NameComparator<BladeLoveItem>("名称") {
                @Override
                public int compare(BladeLoveItem o1, BladeLoveItem o2) {
                    return o1.getName().compareTo(o2.getName());
                }
            });
            return list;
        }
    }
}
