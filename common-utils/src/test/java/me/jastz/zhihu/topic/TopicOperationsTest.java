package me.jastz.zhihu.topic;

import com.google.common.collect.Lists;
import me.jastz.common.file.FileUtils;
import me.jastz.common.json.JsonUtil;
import me.jastz.common.zhihu.topic.TopicOperations;
import me.jastz.common.zhihu.topic.TopicOperationsImpl;
import me.jastz.common.zhihu.topic.vo.TopicsPlazzaListVo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;

import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author zhiwen
 */
public class TopicOperationsTest {

    private RestTemplate restTemplate;

    private TopicOperations topicOperations;

    @Before
    public void setUp() {
        restTemplate = new RestTemplate();
        topicOperations = new TopicOperationsImpl(restTemplate);
    }

    @Test
    public void list() {
        int offset = 19;
        TopicsPlazzaListVo vo = topicOperations.list("next", 1761, offset, "9cef480724bc04772e8ee646e2e76d8f");
        Assert.assertNotNull(vo);
        System.out.println(JsonUtil.objectToPrettyJson(vo.toTopics()));
        FileUtils.writeJsonToFile(JsonUtil.objectToPrettyJson(vo.toTopics()), String.format("topic_%s.json", offset), Paths.get("E:", "zhihu", "topic"));
    }

    @Test
    public void listAll() {
        List<Integer> offsetList = Lists.newArrayList();
        for (int i = 0; i < 500; i++) {
            if (i % 20 == 0) {
                offsetList.add(i);
            }
        }
        ExecutorService pool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        offsetList.forEach(offset -> pool.submit(() -> {
            TopicsPlazzaListVo vo = topicOperations.list("next", 1761, offset, "9cef480724bc04772e8ee646e2e76d8f");
            if (!CollectionUtils.isEmpty(vo.toTopics())) {
                FileUtils.writeJsonToFile(JsonUtil.objectToPrettyJson(vo.toTopics()), String.format("topic_%s.json", offset), Paths.get("E:", "zhihu", "topic"));
            }
        }));
        pool.shutdown();
        while (true) {
            if (pool.isTerminated()) {
                break;
            }
        }

    }
}
