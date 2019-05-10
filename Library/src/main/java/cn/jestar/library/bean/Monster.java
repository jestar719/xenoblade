package cn.jestar.library.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * 精英怪
 * Created by 花京院 on 2019/5/5.
 */

public class Monster extends BaseModel {
    //等级
    private int level;
    //地图
    private String location;
    //区域
    private String area;
    //传送点
    private String transPoint;
    //条件
    private String condition;
    //核心
    private String core;
    //晶片
    private String wafer;
    //饰品掉落（三星）
    private List<String> jewelrys;
    //辅助核心（最高级）
    private List<String> subCores;
    //异刃
    private List<String> blades;

    public List<String> getBlades() {
        return blades;
    }

    public void setBlades(List<String> blades) {
        this.blades = blades;
    }

    public void addJewelry(String string) {
        if (jewelrys == null) {
            jewelrys = new ArrayList<>();
        }
        jewelrys.add(string);
    }

    public void addSubCore(String string) {
        if (subCores == null) {
            subCores = new ArrayList<>();
        }
        subCores.add(string);
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getTransPoint() {
        return transPoint;
    }

    public void setTransPoint(String transPoint) {
        this.transPoint = transPoint;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getCore() {
        return core;
    }

    public void setCore(String core) {
        this.core = core;
    }

    public String getWafer() {
        return wafer;
    }

    public void setWafer(String wafer) {
        this.wafer = wafer;
    }

    public List<String> getJewelrys() {
        return jewelrys;
    }

    public void setJewelrys(String string) {
        if (string == null||string==" ")
            return;
        String[] split = string.split(",");
        for (String s : split) {
            addJewelry(s);
        }
    }

    public void setJewelrys(List<String> jewelrys) {
        this.jewelrys = jewelrys;
    }

    public List<String> getSubCores() {
        return subCores;
    }

    public void setSubCores(String string) {
        if (string == null||string==" ")
            return;
        String[] split = string.split(",");
        for (String s : split) {
            addSubCore(s);
        }
    }

    public void setSubCores(List<String> subCores) {
        this.subCores = subCores;
    }
}
