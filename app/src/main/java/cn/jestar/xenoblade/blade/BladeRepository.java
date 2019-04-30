package cn.jestar.xenoblade.blade;

import android.content.Context;

import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import cn.jestar.xenoblade.base.BaseRepository;
import cn.jestar.xenoblade.utils.JsonUtils;


/**
 * Created by 花京院 on 2019/4/17.
 */

public class BladeRepository extends BaseRepository {
    private static final String BLADE_FILE = "fullBlade.json";
    private List<FullBlade> mFullBlades;
    private List<Blade> mBlades;

    public BladeRepository(Context context) {
        init(context);
    }

    private void init(Context context) {
        try {
            Reader reader = getReader(context, BLADE_FILE);
            Type type = new TypeToken<List<FullBlade>>() {
            }.getType();
            mFullBlades = JsonUtils.readList(reader, type);
            mBlades = new ArrayList<>(mFullBlades.size());
            for (FullBlade fullBlade : mFullBlades) {
                mBlades.add(fullBlade.getBlade());
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public List<FullBlade> getFullBlades() {
        return mFullBlades;
    }

    public List<Blade> getBlades() {
        return mBlades;
    }
}
