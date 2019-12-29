package cn.jastz.fatui.entity;

import java.util.Date;

public class Chat {
    private Long id;

    private String name;

    private String uniqueTopic;

    private Date createTime;

    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getUniqueTopic() {
        return uniqueTopic;
    }

    public void setUniqueTopic(String uniqueTopic) {
        this.uniqueTopic = uniqueTopic;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}