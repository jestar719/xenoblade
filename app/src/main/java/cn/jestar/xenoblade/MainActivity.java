package cn.jestar.xenoblade;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.chad.library.adapter.base.BaseQuickAdapter;

import cn.jestar.xenoblade.blade.BladeActivity;
import cn.jestar.xenoblade.blade.BladeAdapter;
import cn.jestar.xenoblade.blade.BladeRepository;
import cn.jestar.xenoblade.item.ItemActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.tv_blade).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_blade:startActivity(new Intent(this, BladeActivity.class));break;
        }
    }
}
