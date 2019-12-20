package me.jastz.common.haomai.smzdm.domain;

import java.util.List;

/**
 * @author zhangzhiwen on 2019/12/6
 **/
public class Category {
    private String name;
    private List<Category> subList;

    public Category() {
    }

    public Category(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Category> getSubList() {
        return subList;
    }

    public void setSubList(List<Category> subList) {
        this.subList = subList;
    }
}
