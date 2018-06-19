package cn.jastz;

import cn.jastz.page.domain.Page;
import cn.jastz.page.domain.PageRequest;
import cn.jastz.post.PostServiceApplication;
import cn.jastz.post.entity.Post;
import cn.jastz.post.service.PostService;
import me.jastz.common.json.JsonUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author zhiwen
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = PostServiceApplication.class)
public class PostServiceTest {

    @Autowired
    private PostService postService;

    @Test
    public void test() {
        Page<Post> page = postService.queryPageByAppId(PageRequest.of(0, 15), "30b1b99af55f4936a6d03440b77b8cce");
        System.out.println(JsonUtil.objectToPrettyJson(page.getContent()));
    }
}
