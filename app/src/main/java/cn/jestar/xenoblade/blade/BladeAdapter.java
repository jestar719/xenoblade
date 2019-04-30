package cn.jestar.xenoblade.blade;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.Collections;
import java.util.List;

import cn.jestar.xenoblade.R;
import cn.jestar.xenoblade.base.BaseAdapter;
import cn.jestar.xenoblade.utils.SequenceComparator;

/**
 * Created by 花京院 on 2019/4/24.
 */

public class BladeAdapter extends BaseAdapter<Blade> {

    private String nameTemp = "姓名:%s  武器类型:%s  战斗类型:%s";
    private String elmTemp = "属性:%s  加成:%s";
    private String introTemp = "%s可抽取 获取章节:第%s章 ";

    public BladeAdapter() {
        super(R.layout.layout_item_blade);
    }

    public BladeAdapter(@Nullable List<Blade> data) {
        super(R.layout.layout_item_blade, data);
    }

    @Override
    protected SequenceComparator<Blade> getComparator() {
        return new BladeComparator();
    }

    @Override
    protected void convert(BaseViewHolder helper, Blade item) {
        String name = String.format(nameTemp, item.getName(), item.getWeaponType(), item.getFightType());
        String elm = String.format(elmTemp, item.getElement(), item.getPlus());
        String s = item.isDraw() ? "" : "不";
        String intro = String.format(introTemp, s, item.getFirstStage());
        helper.setText(R.id.tv_name, name)
                .setText(R.id.tv_elm, elm)
                .setText(R.id.tv_intro, intro);
    }

}
