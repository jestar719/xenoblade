package cn.jestar.xenoblade.blade;

import android.arch.lifecycle.ViewModelProviders;
import android.view.MenuItem;

import cn.jestar.xenoblade.R;
import cn.jestar.xenoblade.base.BaseListActivity;
import cn.jestar.xenoblade.base.BaseListFragment;

import static cn.jestar.xenoblade.Constance.BLADE;
import static cn.jestar.xenoblade.Constance.BLADE_LOVE;
import static cn.jestar.xenoblade.Constance.MAP_SKILL;
import static cn.jestar.xenoblade.Constance.SUPER_SKILL;

/**
 * Created by 花京院 on 2019/4/26.
 */

public class BladeActivity extends BaseListActivity {

    private BladeViewModel mModel;
    private BladeFragmentFactory mFactory;
    private String mCurrentFrg;

    @Override
    protected int getLayout() {
        return R.layout.activity_base_list;
    }

    @Override
    protected void init() {
        mModel = ViewModelProviders.of(this).get(BladeViewModel.class);
        mFactory = new BladeFragmentFactory();
        showFrag(BLADE);
    }

    @Override
    protected int getMenuLayout() {
        return R.menu.menu_blade;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        switch (itemId) {
            case R.id.blade:
                showFrag(BLADE);
                return true;
            case R.id.map_skill:
                showFrag(MAP_SKILL);
                return true;
            case R.id.love_item:
                showFrag(BLADE_LOVE);
                return true;
            case R.id.super_skill:
                showFrag(SUPER_SKILL);
                return true;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void showFrag(String name) {
        if (name.equals(mCurrentFrg)){
            return;
        }
        BaseListFragment fragment = getFrag(name);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frg_container, fragment, name)
                .addToBackStack(name)
                .commit();
        mToolbar.setTitle(name);
        mCurrentFrg=name;
    }

    private BaseListFragment getFrag(String name) {
        return mFactory.getFragment(name);
    }

    @Override
    protected void onSearch(String query) {
        mModel.onSearch(query);
    }

    @Override
    protected void down() {

    }

    @Override
    protected void up() {

    }

    @Override
    protected void toTop() {
        BaseListFragment frag = getFrag(mCurrentFrg);
        frag.toTop();
    }
}
