package me.jastz.common.stackoverflow;

import com.google.common.collect.Lists;
import me.jastz.common.stackoverflow.vo.UserVo;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.web.client.RestTemplate;

import java.util.Iterator;
import java.util.List;

/**
 * @author zhiwen
 */
public class SofUserOperationsImpl implements SofUserOperations {

    private RestTemplate restTemplate;

    public SofUserOperationsImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<UserVo> page(int page, String tab, String filter) {
        List<UserVo> userVos = Lists.newArrayList();
        String html = restTemplate.getForObject(SofUrl.users.getUrl(), String.class, page, tab, filter);
        Document document = Jsoup.parse(html);
        Elements userBrowser = document.select("#user-browser");
        Elements userInfo = userBrowser.select(".user-info");
        Iterator<Element> iterator = userInfo.iterator();
        while (iterator.hasNext()) {
            Element element = iterator.next();
            Element a = element.select(".user-details").select("a").first();
            Element l = element.select(".user-details").select(".user-location").first();
            String url = a.attr("href");
            String name = a.html();
            String location = l.html();
            userVos.add(new UserVo(url, name, location));
        }
        return userVos;
    }
}
