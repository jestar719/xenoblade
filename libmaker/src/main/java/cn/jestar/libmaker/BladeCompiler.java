package cn.jestar.libmaker;

import android.support.annotation.NonNull;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import cn.jestar.library.bean.BaseItem;
import cn.jestar.library.bean.Monster;
import cn.jestar.library.bean.blade.Blade;
import cn.jestar.library.bean.blade.BladeLove;
import cn.jestar.library.bean.blade.BladeSuperSkill;
import cn.jestar.library.bean.blade.FullBlade;
import cn.jestar.library.bean.blade.MapSkill;
import cn.jestar.library.bean.item.CollectionItem;
import cn.jestar.library.bean.item.Equipment;
import cn.jestar.library.bean.item.Goods;
import cn.jestar.library.utils.JsonUtils;

/**
 * Created by 花京院 on 2019/4/16.
 */

public class BladeCompiler extends Compiler {

    public void compileBlade(File file, String fileName) throws IOException {
        compile(file, fileName, new Creator<Blade>() {
            @Override
            public void create(String text) {

            }
        });
    }

    public void compileBladeLove(File file, String fileName) throws IOException {
        compile(file, fileName, new Creator<BladeLove>() {
            @Override
            public void create(String text) {
                add(createBladeLove(text));
            }
        });
    }

    public void compileBladeSuperSkill(File file, String fileName) throws Exception {
        compile(file, fileName, new Creator<BladeSuperSkill>() {
            @Override
            public void create(String text) {
                add(createBladeSuperSkill(text));
            }
        });
    }

    public void compileCollectItem(File file, String fileName) throws IOException {
        compile(file, fileName, new Creator<CollectionItem>() {
            @Override
            public void create(String text) {
                String[] strings = text.split("_");
                CollectionItem item = new CollectionItem();
                item.setType(strings[0]);
                item.setName(strings[1]);
                item.setLevel(Integer.parseInt(strings[2]));
                item.setLocation(strings[3]);
                add(item);
            }
        });
    }

    public void compileGoods(File file, String fileName) throws IOException {
        compile(file, fileName, new Creator<Goods>() {
            @Override
            public void create(String text) {
                String[] strings = text.split("_");
                Goods item = new Goods();
                item.setName(strings[0]);
                item.setLocation(strings[1]);
                item.setType(strings[2]);
                item.setEffect(strings[3]);
                if (strings.length > 4) {
                    item.setCondition(strings[4]);
                }
                add(item);
            }
        });
    }

    public void compileBaseItem(File file, String fileName,String name) throws FileNotFoundException {
        BufferedReader reader = getReader(file, fileName);
        Map<String, Map<String, String>> hashMap = JsonUtils.readObject(reader, Map.class);
        List<Equipment> items=new ArrayList<>();
        for (Map.Entry<String, Map<String, String>> entry : hashMap.entrySet()) {
            String key = entry.getKey();
            Map<String, String> value = entry.getValue();
            for (Map.Entry<String, String> stringEntry : value.entrySet()) {
                Equipment item = new Equipment();
                item.setName(stringEntry.getKey());
                item.setEffect(stringEntry.getValue());
                item.setSubType(key);
                item.setType(name);
                items.add(item);
            }
        }
        writeObject(file,name,items);
    }

    private BladeSuperSkill createBladeSuperSkill(String text) {
        String[] strings = text.split("_");
        BladeSuperSkill skill = new BladeSuperSkill();
        skill.setName(strings[0]);
        skill.setLevel(Integer.parseInt(strings[2]));
        skill.setAttackType(strings[3]);
        skill.setAttackNum(Integer.parseInt(strings[4]));
        skill.setDmg(Integer.parseInt(strings[5]));
        skill.setIgnoreDefense(Boolean.valueOf(strings[6]));
        skill.setHitPlus(Integer.parseInt(strings[7]));
        skill.setCritPlus(Integer.parseInt(strings[8]));
        if (strings.length > 9) {
            skill.setEffect(strings[9]);
        }
        return skill;
    }

    private BladeLove createBladeLove(String text) {
        String[] split = text.split(",");
        BladeLove bladeLove = new BladeLove();
        bladeLove.addLoveType(split[0]);
        bladeLove.addLoveType(split[3]);
        bladeLove.addLoveItem(getItem(split[1], split[2]));
        bladeLove.addLoveItem(getItem(split[4], split[5]));
        return bladeLove;
    }

    private BaseItem getItem(String s, String s1) {
        BaseItem baseItem = new BaseItem();
        baseItem.setName(s);
        baseItem.setLocation(s1);
        return baseItem;
    }

    @NonNull
    public BufferedReader getTxtReader(File file, String fileName) throws FileNotFoundException {
        return getReader(file, fileName + ".txt");
    }

    public BufferedReader getReader(File file, String fileName) throws FileNotFoundException {
        File source = new File(file, fileName);
        FileReader reader = new FileReader(source);
        return new BufferedReader(reader);
    }

    public void writeObject(File file, String fileName, Object obj) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(new File(file, fileName + ".json"));
        writer.print(JsonUtils.toString(obj));
        writer.close();
    }

    private FullBlade createBlade(String text) {
        String[] split = text.split(",");
        FullBlade fullBlade = new FullBlade();
        Blade blade = new Blade();
        blade.setName(split[0]);
        blade.setElement(split[1]);
        blade.setWeaponType(split[2]);
        blade.setFightType(split[3]);
        String s = split[4];
        String num = getInt(s);
        s = s.split(num)[0];
        blade.setAttrPlus(s);
        blade.setAttrPlusValue(Integer.parseInt(num));
        blade.setCoreNum(split[5]);
        ArrayList<MapSkill> skills = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            MapSkill mapSkill = createMapSkill(split[i + 5]);
            skills.add(mapSkill);
        }
        fullBlade.setBlade(blade);
        fullBlade.setMapSkill(skills);
        fullBlade.setName(blade.getName());
        return fullBlade;
    }

    private MapSkill createMapSkill(String s) {
        String num = getInt(s);
        int i = s.indexOf("（");
        MapSkill skill = new MapSkill();
        skill.setName(s.substring(0, i));
        skill.setLevel(Integer.valueOf(num));
        return skill;
    }

    private String getInt(String s) {
        String regex = "\\d+";
        Matcher matcher = Pattern.compile(regex).matcher(s);
        matcher.find();
        return matcher.group();
    }

    public void compileMonster(File file, String name) throws IOException {
        compile(file, name, new Creator<Monster>() {
            @Override
            public void create(String text) {
                Monster monster = createMonster(text);
                add(monster);
                monster.setId(getList().size());
            }
        });
    }

    private Monster createMonster(String text) {
        String[] strings = text.split("-");
        Monster monster = new Monster();
        monster.setLocation(strings[0]);
        monster.setName(strings[1]);
        monster.setLevel(Integer.parseInt(strings[2]));
        monster.setArea(strings[3]);
        monster.setTransPoint(strings[4]);
        monster.setCondition(strings[5]);
        monster.setCore(strings[6]);
        monster.setSubCores(strings[7]);
        monster.setWafer(strings[8]);
        monster.setJewelrys(strings[9]);
        return monster;
    }
}
