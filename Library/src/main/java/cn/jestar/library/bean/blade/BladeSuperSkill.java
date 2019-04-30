package cn.jestar.library.bean.blade;

import cn.jestar.library.bean.Model;

/**
 * Created by 花京院 on 2019/4/26.
 */

public class BladeSuperSkill extends Model {
    //等级
    private int level;
    //无视防御
    private boolean ignoreDefense;
    //攻击类型（以太/物理）
    private String attackType;
    //攻击段数
    private int attackNum;
    //攻击力
    private int dmg;
    //命中加成
    private int hitPlus;
    //暴击加成
    private int critPlus;
    //特效
    private String effect;

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public boolean isIgnoreDefense() {
        return ignoreDefense;
    }

    public void setIgnoreDefense(boolean ignoreDefense) {
        this.ignoreDefense = ignoreDefense;
    }

    public String getAttackType() {
        return attackType;
    }

    public void setAttackType(String attackType) {
        this.attackType = attackType;
    }

    public int getAttackNum() {
        return attackNum;
    }

    public void setAttackNum(int attackNum) {
        this.attackNum = attackNum;
    }

    public int getDmg() {
        return dmg;
    }

    public void setDmg(int dmg) {
        this.dmg = dmg;
    }

    public int getHitPlus() {
        return hitPlus;
    }

    public void setHitPlus(int hitPlus) {
        this.hitPlus = hitPlus;
    }

    public int getCritPlus() {
        return critPlus;
    }

    public void setCritPlus(int critPlus) {
        this.critPlus = critPlus;
    }

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }

}
