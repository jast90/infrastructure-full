package me.jastz.common.freemarker.directive;

import cn.jastz.page.domain.IPage;
import cn.jastz.page.domain.Page;
import cn.jastz.page.domain.PageRequest;
import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import freemarker.core.Environment;
import freemarker.ext.beans.StringModel;
import freemarker.template.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Freemarker 分页指令：传入分页page
 * <p>
 * 模板中使用方式：<@pagination modelName="page" url="/city/page" pageNumberParamName="pageNumber"
 * pageSizeParamName="pageSize"></@pagination>
 * modelName 是 Srpring MVC Controller model.addAttribute("page", page);中的 attributeName
 *
 * @author zhiwen
 */
public class PageDirective implements TemplateDirectiveModel {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body)
            throws TemplateException, IOException {
        if (body != null) {
            throw new TemplateModelException(
                    "This directive doesn't allow body.");
        }
        IPage page;
        String url, pageNumberParamName = "pageNumber", pageSizeParamName = "pageSize";
        if (params.isEmpty()) {
            throw new TemplateModelException("This directive need param.");
        }
        String modelNameStr = "page";
        Object urlParam = params.get("url");

        if (urlParam == null) {
            throw new TemplateModelException("Url must assign.");
        }
        url = ((SimpleScalar) urlParam).getAsString();
        Object pageNumberParam = params.get("pageNumberParamName");
        if (pageNumberParam != null) {
            pageNumberParamName = ((SimpleScalar) pageNumberParam).getAsString();
        }
        Object pageSizeParam = params.get("pageSizeParamName");
        if (pageNumberParam != null) {
            pageSizeParamName = ((SimpleScalar) pageSizeParam).getAsString();
        }

        Object modelName = params.get("modelName");
        if (modelName instanceof SimpleScalar) {
            modelNameStr = ((SimpleScalar) modelName).getAsString();
        }
        Object wrapper = env.getVariable(modelNameStr);
        Object object = null;
        if (null != wrapper) {
            if (wrapper instanceof StringModel) {
                object = ((StringModel) wrapper).getWrappedObject();
            } else {
                object = wrapper;
            }
        }
        if (object != null) {
            page = (IPage) object;
        } else {
            page = getPage();
        }


        env.getOut().write(render(page, url, pageNumberParamName, pageSizeParamName));
    }

    private IPage getPage() {
        List<String> content = new ArrayList<String>();
        for (int i = 0; i < 100; i++) {
            content.add("" + i);
        }
        IPage page = new Page(content, PageRequest.of(0, 15), content.size());
        return page;
    }

    /**
     * 分页显示
     * 1、首页：
     * 首页（当前页） 2 3 4 末页 下一页
     * 2、中间页：
     * 上一页 首页 2 3 4 5（当前页） 6 7 8 末页 下一页
     * 3、末页：
     * 上一页 首页 5 末页（当前页）
     * 4、当前页的位置：前后各显示3页如果存在的话，不存在的话就显示可用的
     * <p>
     * <p>
     * <p>
     * <nav>
     * <ul class="pagination pagination-lg">
     * <li><a href="#" aria-label="Previous"><span aria-hidden="true">«</span></a></li>
     * <li><a href="#">1</a></li>
     * <li><a href="#">2</a></li>
     * <li><a href="#">3</a></li>
     * <li><a href="#">4</a></li>
     * <li><a href="#">5</a></li>
     * <li><a href="#" aria-label="Next"><span aria-hidden="true">»</span></a></li>
     * </ul>
     * </nav>
     */
    private String render(IPage page, String url, String pageNumberParamName, String pageSizeParamName) {

        //只有一页
        if (page.getTotalPages() == 1 || page.getContent().size() == 0) {
            return "";
        }

        List<String> nav = Lists.newArrayList();
        nav.add("<nav>");
        nav.add("<ul class=\"pagination pagination-sm\">");
        if (!page.isFirst()) {
            nav.add("<li class=\"page-item\" ><a class=\"page-link\" href=" + getUrl(url, pageNumberParamName, page.getNumber()
                    , pageSizeParamName, page.getSize()) + ">上一页</a></li>");
            nav.add("<li class=\"page-item\" ><a class=\"page-link\" href=" + getUrl(url, pageNumberParamName, 1, pageSizeParamName
                    , page.getSize()) + ">首页</a></li>");
        } else {
            nav.add("<li class=\"page-item active\"><a class=\"page-link\"  href=\"#\">" + (page.getNumber() + 1) + "</a></li>");//首页，显示在第一个位置
        }
        //往前显示3页
        for (int i = 2; i >= 0; i--) {
            int previousNumber = page.getNumber() - (i + 1);
            if (previousNumber >= 0) {
                nav.add("<li class=\"page-item\"><a class=\"page-link\" href=" + getUrl(url, pageNumberParamName, (previousNumber + 1), pageSizeParamName
                        , page.getSize()) + ">" + (previousNumber + 1) + "</a></li>");
            }
        }
        if (!page.isFirst() && !page.isLast()) {
            nav.add("<li class=\"page-item active\"><a class=\"page-link\" href=" + getUrl(url, pageNumberParamName, (page.getNumber() + 1), pageSizeParamName
                    , page.getSize()) + ">" + (page.getNumber() + 1) + "</a></li>");//非首页、非末页，显示在中间位置
        }
        //往后显示3页
        for (int i = 0; i < 3; i++) {
            int nextNumber = page.getNumber() + (i + 1);
            if (nextNumber < page.getTotalPages()) {
                nav.add("<li class=\"page-item\"><a class=\"page-link\" href=" + getUrl(url, pageNumberParamName, (nextNumber + 1), pageSizeParamName
                        , page.getSize()) + ">" + (nextNumber + 1) + "</a></li>");
            }
        }
        if (!page.isLast()) {
            nav.add("<li class=\"page-item\"><a class=\"page-link\" href=" + getUrl(url, pageNumberParamName, page.getTotalPages(), pageSizeParamName
                    , page.getSize()) + ">末页</a></li>");
            nav.add("<li class=\"page-item\"><a class=\"page-link\" href=" + getUrl(url, pageNumberParamName, page.getNumber() + 2, pageSizeParamName
                    , page.getSize()) + ">下一页</a></li>");
        } else {
            if (page.getTotalPages() > 1) {
                nav.add("<li class=\"page-item active\"><a class=\"page-link\" href=" + getUrl(url, pageNumberParamName
                        , page.getTotalPages(), pageSizeParamName, page.getSize()) + ">" + page.getTotalPages() + "</a></li>");//末页，显示在最后位置
            }
        }
        return Joiner.on("").join(nav);
    }

    /**
     * 拼接URL
     *
     * @param url
     * @param pageNumberParamName
     * @param pageNumber
     * @param pageSizeParamName
     * @param pageSize
     * @return
     */
    private String getUrl(String url, String pageNumberParamName, int pageNumber, String pageSizeParamName, int pageSize) {
        String resultUrl = String.format("%s?%s=%s&%s=%s", url, pageNumberParamName, pageNumber, pageSizeParamName, pageSize);
        resultUrl = String.format("%s%s", url, pageNumber);
        return resultUrl;
    }
}
