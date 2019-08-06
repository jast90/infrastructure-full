package me.jastz.html;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author zhiwen
 */
public class MongoDBDocument {
    private String title;
    private String url;
    private List<MongoDBDocument> subList;

    public MongoDBDocument() {
        this.subList = Lists.newArrayList();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<MongoDBDocument> getSubList() {
        return subList;
    }

    public void setSubList(List<MongoDBDocument> subList) {
        this.subList = subList;
    }
}
