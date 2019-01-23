package cn.jastz.open.form;

import cn.jastz.open.enums.AttrName;

/**
 * @author zhiwen
 */
public class AppPayConfigDetailsAddForm {
    private AttrName attrName;
    private String attrValue;

    public AttrName getAttrName() {
        return attrName;
    }

    public void setAttrName(AttrName attrName) {
        this.attrName = attrName;
    }

    public String getAttrValue() {
        return attrValue;
    }

    public void setAttrValue(String attrValue) {
        this.attrValue = attrValue;
    }
}
