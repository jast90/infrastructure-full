package me.jastz.common.zhihu.topic.vo;

import com.google.common.collect.Lists;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.util.List;

/**
 * @author zhiwen
 */
public class TopicsPlazzaListVo {
    private int r;
    private List<String> msg;

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public List<String> getMsg() {
        return msg;
    }

    public void setMsg(List<String> msg) {
        this.msg = msg;
    }

    public List<Topic> toTopics() {
        List<Topic> topics = Lists.newArrayList();
        for (String msg : getMsg()) {
            Document document = Jsoup.parse(msg);
            String url = document.select("a").first().attr("href");
            String name = document.select("strong").html();
            String desc = document.select("p").html();
            String img = document.select("img").attr("src");
            topics.add(new Topic(url, name, desc, img));
        }
        return topics;
    }
}
