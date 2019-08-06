package cn.jastz.page.mybatis;

import cn.jastz.page.PageHolder;
import cn.jastz.page.domain.Page;
import org.apache.ibatis.session.ResultContext;
import org.apache.ibatis.session.ResultHandler;

public class PageResultHandler implements ResultHandler<Object> {
    Page<Object> page = PageHolder.getPage();

    @Override
    public void handleResult(ResultContext<? extends Object> resultContext) {
        page.getContent().add(resultContext.getResultObject());
    }

    public Page<Object> getPage() {
        return page;
    }
}
