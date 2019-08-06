package cn.jastz.page;

import cn.jastz.page.domain.Page;

public class PageHolder {
    private static ThreadLocal<Page> pageThreadLocal = new ThreadLocal<>();

    public static Page getPage() {
        if (pageThreadLocal.get() == null) {
            return new Page();
        }
        return pageThreadLocal.get();
    }

    public static void setPage(Page page) {
        pageThreadLocal.set(page);
    }
}
