package me.jastz.common.haomai.pdd.domain;

/**
 * @author zhangzhiwen on 2019/12/6
 **/
public class QueryForm {
    private int categoryId;
    private String crawlerInfo;
    private String keyword;
    private int pageNumber;
    private int pageSize;

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCrawlerInfo() {
        return crawlerInfo;
    }

    public void setCrawlerInfo(String crawlerInfo) {
        this.crawlerInfo = crawlerInfo;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
