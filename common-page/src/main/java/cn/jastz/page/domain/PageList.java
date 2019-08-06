package cn.jastz.page.domain;

import java.util.ArrayList;

/**
 * @author zhiwen
 */
public class PageList<T> extends ArrayList<T> {
    private Page<T> page;

    public Page<T> getPage() {
        return page;
    }

    public void setPage(Page<T> page) {
        this.page = page;
    }
}
