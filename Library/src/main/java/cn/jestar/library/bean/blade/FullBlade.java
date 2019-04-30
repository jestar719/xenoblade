package cn.jestar.library.bean.blade;

import java.util.ArrayList;
import java.util.List;

import cn.jestar.library.bean.Model;

/**
 * Created by 花京院 on 2019/4/22.
 */
public class FullBlade extends Model {
    private Blade blade;
    private List<MapSkill> mapSkill;
    private BladeLove bladeLove;
    private List<BladeSuperSkill> superSkill;

    public Blade getBlade() {
        return blade;
    }

    public void setBlade(Blade blade) {
        this.blade = blade;
    }

    public List<MapSkill> getMapSkill() {
        return mapSkill;
    }

    public void setMapSkill(List<MapSkill> mapSkill) {
        this.mapSkill = mapSkill;
    }

    public BladeLove getBladeLove() {
        return bladeLove;
    }

    public void setBladeLove(BladeLove bladeLove) {
        this.bladeLove = bladeLove;
    }

    public List<BladeSuperSkill> getSuperSkill() {
        return superSkill;
    }

    public void setSuperSkill(List<BladeSuperSkill> superSkill) {
        this.superSkill = superSkill;
    }

    public void addSuperSkill(BladeSuperSkill skill) {
        if (superSkill == null) {
            superSkill = new ArrayList<>(3);
        }
        superSkill.add(skill);
    }
}
