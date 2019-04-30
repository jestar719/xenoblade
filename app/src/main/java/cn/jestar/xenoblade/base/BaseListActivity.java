package cn.jestar.xenoblade.base;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import cn.jestar.xenoblade.R;

/**
 * Created by 花京院 on 2019/4/26.
 */

public abstract class BaseListActivity extends AppCompatActivity implements View.OnClickListener {

    protected ViewGroup mFrgContainer;
    protected View mFab;
    protected SearchView mSearchView;
    protected View mFabContainer;
    protected Toolbar mToolbar;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        mFrgContainer = findViewById(R.id.frg_container);
        initToolbar();
        init();
    }


    @LayoutRes
    protected abstract int getLayout();

    protected abstract void init();

    private void initToolbar() {
        mToolbar = findViewById(R.id.toolbar);
        mToolbar.setNavigationIcon(android.R.drawable.ic_menu_revert);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        setSupportActionBar(mToolbar);
        mFabContainer = findViewById(R.id.ll_fab_container);
        mFab = findViewById(R.id.fab_top);
        mFab.setOnClickListener(this);
        findViewById(R.id.fab_up).setOnClickListener(this);
        findViewById(R.id.fab_down).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fab_top:
                toTop();
                break;
            case R.id.fab_up:
                up();
                break;
            case R.id.fab_down:
                down();
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(getMenuLayout(), menu);
        MenuItem item = menu.findItem(R.id.action_search);
        mSearchView = (SearchView) MenuItemCompat.getActionView(item);
        mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if (!TextUtils.isEmpty(query)) {
                    onSearch(query);
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        initSearchView(mSearchView);
        return super.onCreateOptionsMenu(menu);
    }

    protected int getMenuLayout() {
        return R.menu.menu_title;
    }


    protected void initSearchView(SearchView searchView) {
    }

    protected abstract void onSearch(String query);

    protected abstract void down();

    protected abstract void up();

    protected abstract void toTop();
}
