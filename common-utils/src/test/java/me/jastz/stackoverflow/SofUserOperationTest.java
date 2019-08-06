package me.jastz.stackoverflow;

import com.google.common.collect.Lists;
import me.jastz.common.file.FileUtils;
import me.jastz.common.json.JsonUtil;
import me.jastz.common.stackoverflow.SofUserOperations;
import me.jastz.common.stackoverflow.SofUserOperationsImpl;
import me.jastz.common.stackoverflow.vo.UserVo;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author zhiwen
 */
public class SofUserOperationTest {

    private SofUserOperations sofUserOperations;

    @Before
    public void setUp() {
        sofUserOperations = new SofUserOperationsImpl(new RestTemplate());
    }

    @Test
    public void test() {
        List<UserVo> list = sofUserOperations.page(1, "reputation", "all");
        System.out.println(JsonUtil.objectToPrettyJson(list));
    }

    @Test
    public void queryAll() {
        ExecutorService pool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        int totalPage = 242245;
        totalPage = 247296;
        for (int i = 0; i <= totalPage / 10000 + 1; i++) {
            final int threadPageIndex = i;
            pool.submit(() -> {
                List<UserVo> list = Lists.newArrayList();
                int start = threadPageIndex * 10000 + 1;
                for (int j = start; j < start + 10000; j++) {
                    list.addAll(sofUserOperations.page(j, "reputation", "all"));
                }
                FileUtils.writeJsonToFile(JsonUtil.objectToPrettyJson(list), String.format("stackoverflow_user_page_%s.json", threadPageIndex), Paths.get("E:", "stackoverflow", "users"));
            });
        }
        pool.shutdown();
        while (true) {
            if (pool.isTerminated()) {
                break;
            }
        }
    }
}
