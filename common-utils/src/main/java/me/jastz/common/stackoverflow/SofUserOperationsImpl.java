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
        try {


            String html = restTemplate.getForObject(SofUrl.users.getUrl(), String.class, page, tab, filter);
            Document document = Jsoup.parse(html);
            Elements userBrowser = document.select("#user-browser");
            if (userBrowser.size() <= 0) {
                System.out.println(html);
            }
            Elements userInfo = userBrowser.select(".user-info");
            Iterator<Element> iterator = userInfo.iterator();
            while (iterator.hasNext()) {
                Element element = iterator.next();
                Element a = element.select(".user-details").select("a").first();
                Element l = element.select(".user-details").select(".user-location").first();
                Element reputation = element.select(".user-details").select(".-flair").select(".reputation-score").first();
                Element gold = element.select(".user-details").select(".-flair").select("span:eq(1)").first().select(".badgecount").first();
                Element silver = element.select(".user-details").select(".-flair").select("span:eq(3)").first();
                if (silver != null) {
                    silver = silver.select(".badgecount").first();
                }

                Element bronze = element.select(".user-details").select(".-flair").select("span:eq(5)").first();
                if (bronze != null) {
                    bronze = bronze.select(".badgecount").first();
                }
                String url = a.attr("href");
                String name = a.html();
                String location = l.html();
                String re = reputation.html();
                Long goldI = Long.parseLong(gold.html());
                Long silverI = 0L;
                if (silver != null) {
                    silverI = Long.parseLong(silver.html());
                }
                Long bronzeI = 0L;
                if (bronze != null) {
                    bronzeI = Long.parseLong(bronze.html());
                }
                userVos.add(new UserVo(String.format("https://stackoverflow.com/%s", url), name, location, re, goldI, silverI, bronzeI));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userVos;
    }
}
