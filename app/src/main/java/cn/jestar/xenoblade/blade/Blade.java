package cn.jestar.xenoblade.blade;

import cn.jestar.xenoblade.base.BaseData;

/**
 * 异刃
 * Created by 花京院 on 2019/4/12.
 */
public class Blade extends BaseData{
    //属性
    private String element;
    //武器类别
    private String weaponType;
    //战斗类别
    private String fightType;
    //是否能抽取
    private boolean draw;
    //芯片数量
    private String coreNum;
    //获取方式
    private String getType;
    //最早获取章节
    private int firstStage;
    //能力加成
    private String attrPlus;
    //能力加成数值
    private int attrPlusValue;


    public String getElement() {
        return element;
    }

    public void setElement(String element) {
        this.element = element;
    }

    public String getWeaponType() {
        return weaponType;
    }

    public void setWeaponType(String weaponType) {
        this.weaponType = weaponType;
    }

    public String getFightType() {
        return fightType;
    }

    public void setFightType(String fightType) {
        this.fightType = fightType;
    }

    public boolean isDraw() {
        return draw;
    }

    public void setDraw(boolean draw) {
        this.draw = draw;
    }

    public String getGetType() {
        return getType;
    }

    public void setGetType(String getType) {
        this.getType = getType;
    }

    public int getFirstStage() {
        return firstStage;
    }

    public void setFirstStage(int firstStage) {
        this.firstStage = firstStage;
    }

    public String getAttrPlus() {
        return attrPlus;
    }

    public void setAttrPlus(String attrPlus) {
        this.attrPlus = attrPlus;
    }

    public int getAttrPlusValue() {
        return attrPlusValue;
    }

    public void setAttrPlusValue(int attrPlusValue) {
        this.attrPlusValue = attrPlusValue;
    }

    public String getCoreNum() {
        return coreNum;
    }

    public void setCoreNum(String coreNum) {
        this.coreNum = coreNum;
    }

    public String getPlus() {
        return attrPlusValue+"%"+attrPlus;
    }
}
