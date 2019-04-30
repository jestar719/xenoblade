package cn.jestar.libmaker;

import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import cn.jestar.library.bean.blade.Blade;
import cn.jestar.library.bean.blade.BladeLove;
import cn.jestar.library.bean.blade.BladeSuperSkill;
import cn.jestar.library.bean.blade.FullBlade;
import cn.jestar.library.bean.blade.MapSkill;
import cn.jestar.library.utils.JsonUtils;

/**
 * Created by 花京院 on 2019/4/17.
 */
public class BladeCompilerTest {

    private BladeCompiler mBladeCompiler;
    private File mFile;

    @Before
    public void setUp() throws Exception {
        mBladeCompiler = new BladeCompiler();
        mFile = new File("data");
    }

    @Test
    public void compileBlade() throws Exception {
        String name = "blade";
        mBladeCompiler.compileBlade(mFile, name);
    }

    @Test
    public void compileBladeLove() throws Exception {
        String name = "bladeLove";
        mBladeCompiler.compileBladeLove(mFile, name);
    }

    @Test
    public void compileBladeSuperSkill() throws Exception {
        String name = "superSkill";
        mBladeCompiler.compileBladeSuperSkill(mFile, name);
    }

    @Test
    public void compileCollectionItem() throws Exception {
        String name = "collect";
        mBladeCompiler.compileCollectItem(mFile, name);
    }

    @Test
    public void compileGoods() throws Exception {
        String name = "goods";
        mBladeCompiler.compileGoods(mFile, name);
    }


    @Test
    public void compile() throws FileNotFoundException {
       mBladeCompiler.compileBaseItem(mFile,"shipin.json","饰品");
       mBladeCompiler.compileBaseItem(mFile,"subCore.json","辅助核心");
    }

}
