package me.jastz.common.haomai.smzdm;

import com.google.common.collect.Lists;
import me.jastz.common.json.JsonUtil;
import me.jastz.common.haomai.smzdm.domain.Category;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.List;

/**
 * @author zhangzhiwen on 2019/12/6
 **/
public class SmzdmOperationsImpl implements SmzdmOperations{

    public SmzdmOperationsImpl() {
    }

    @Override
    public List<Category> getCategories() throws IOException {
        Document document = Jsoup.connect(SmzdmURLs.category_url.getUrl()).get();
        Elements elements = document.select("#category");
        Element element = elements.first();
        return parseLevel1(element);
    }

    /**
     * 获取一级类目
     * @param categoryDiv
     * @return
     */
    private List<Category> parseLevel1(Element categoryDiv){
        List<Category> categories = Lists.newArrayList();
        Elements elements = categoryDiv.select("ul>li");
        elements.forEach(element -> {
            Element a = element.select("a").first();
            String firstLevelName = a.html();
            Category categoryLevel1 = new Category(firstLevelName);
            Element categoryList = element.select(".category-list").first();
            List<Category> categoryLevel2 = parseLevel2(categoryList);
            categoryLevel1.setSubList(categoryLevel2);
            categories.add(categoryLevel1);
        });
        return categories;
    }

    private List<Category> parseLevel2(Element categoryList){
        List<Category> categories = Lists.newArrayList();
        Elements categoryRowsDiv = categoryList.select(".category-text >.category-row");
        categoryRowsDiv.forEach(categoryRow->{
            String nameLevel2 = categoryRow.select("a").first().html();
            Category categoryLevel2 = new Category(nameLevel2);
            categoryLevel2.setSubList(parseLevel3(categoryRow.selectFirst(".cate-list")));
            categories.add(categoryLevel2);
        });
        return categories;
    }

    private List<Category> parseLevel3(Element cateList){
        List<Category> categories = Lists.newArrayList();
        cateList.select("a").forEach(element -> {
            categories.add(new Category(element.html()));
        });
        return categories;
    }


    public static void main(String[] args) {
        try {
            List<Category> list = new SmzdmOperationsImpl().getCategories();
            System.out.println(JsonUtil.objectToPrettyJson(list));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
