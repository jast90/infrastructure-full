package me.jastz.common.china.district.vo;

import java.util.Arrays;
import java.util.List;

/**
 * @author zhiwen
 */
public class Item {
    private String diji;
    private String quHuaDaiMa;
    private String quhao;
    private String shengji;
    private String xianji;
    private List<Item> children;

    public String getDiji() {
        return diji;
    }

    public void setDiji(String diji) {
        this.diji = diji;
    }

    public String getQuHuaDaiMa() {
        return quHuaDaiMa;
    }

    public void setQuHuaDaiMa(String quHuaDaiMa) {
        this.quHuaDaiMa = quHuaDaiMa;
    }

    public String getQuhao() {
        return quhao;
    }

    public void setQuhao(String quhao) {
        this.quhao = quhao;
    }

    public String getShengji() {
        return shengji;
    }

    public void setShengji(String shengji) {
        this.shengji = shengji;
    }

    public String getXianji() {
        return xianji;
    }

    public void setXianji(String xianji) {
        this.xianji = xianji;
    }

    public List<Item> getChildren() {
        return children;
    }

    public void setChildren(List<Item> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "{\"_class\":\"Item\", " +
                "\"diji\":" + (diji == null ? "null" : "\"" + diji + "\"") + ", " +
                "\"quHuaDaiMa\":" + (quHuaDaiMa == null ? "null" : "\"" + quHuaDaiMa + "\"") + ", " +
                "\"quhao\":" + (quhao == null ? "null" : "\"" + quhao + "\"") + ", " +
                "\"shengji\":" + (shengji == null ? "null" : "\"" + shengji + "\"") + ", " +
                "\"xianji\":" + (xianji == null ? "null" : "\"" + xianji + "\"") + ", " +
                "\"children\":" + (children == null ? "null" : Arrays.toString(children.toArray())) +
                "}";
    }
}
