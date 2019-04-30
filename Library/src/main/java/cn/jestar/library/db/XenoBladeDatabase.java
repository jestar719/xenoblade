package cn.jestar.library.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import cn.jestar.library.bean.BaseItem;
import cn.jestar.library.bean.blade.Blade;
import cn.jestar.library.bean.blade.BladeLove;
import cn.jestar.library.bean.blade.FullBlade;
import cn.jestar.library.bean.blade.MapSkill;

import static cn.jestar.library.db.DbConstans.DB_VERSION;

/**
 * Created by 花京院 on 2019/4/12.
 */

public abstract class XenoBladeDatabase extends RoomDatabase {
    public abstract BladeDao getBladeDao();
}
