package cn.jestar.libmaker;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import cn.jestar.library.bean.BaseItem;
import cn.jestar.library.bean.blade.Blade;
import cn.jestar.library.bean.blade.BladeLove;
import cn.jestar.library.bean.blade.FullBlade;
import cn.jestar.library.bean.blade.MapSkill;
import cn.jestar.library.db.BladeDao;
import cn.jestar.library.db.DbConstans;
import cn.jestar.library.db.XenoBladeDatabase;
import cn.jestar.library.utils.JsonUtils;

public class MainActivity extends AppCompatActivity {

    private XenoBladeDatabase mBuild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBuild = Room.databaseBuilder(this, XenoBladeDatabase.class, DbConstans.DB_NAME).allowMainThreadQueries().build();
        BladeDao dao = mBuild.getBladeDao();
        Reader reader = null;
        try {
            reader = getReader(this, "fullBlade.json");
            Type type = new TypeToken<List<Blade>>() {
            }.getType();
            List<FullBlade> bladeList = JsonUtils.readList(reader, type);
            ArrayList<Blade> blades = new ArrayList<>();
            ArrayList<BladeLove> bladeLoves = new ArrayList<>();
            ArrayList<MapSkill> mapSkills = new ArrayList<>();
            ArrayList<BaseItem> items = new ArrayList<>();
            for (FullBlade fullBlade : bladeList) {
                blades.add(fullBlade.getBlade());
                BladeLove bladeLove = fullBlade.getBladeLove();
                bladeLoves.add(bladeLove);
                items.addAll(bladeLove.getLoveItem());
                mapSkills.addAll(fullBlade.getMapSkill());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private InputStreamReader getReader(Context context, String fileName) throws IOException {
        InputStream open = context.getAssets().open(fileName);
        InputStreamReader reader = new InputStreamReader(open);
        return reader;
    }
}
