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
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author zhiwen
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = PostServiceApplication.class)
@ActiveProfiles("localhost")
public class PostServiceTest {

    @Autowired
    private PostService postService;

    @Test
    public void test() {
        Page<Post> page = postService.queryPageByAppId(PageRequest.of(0, 15), "30b1b99af55f4936a6d03440b77b8cce");
        System.out.println(JsonUtil.objectToPrettyJson(page.getContent()));
    }

    @Test
    public void addTest() {
        Post post = new Post();
        post.setPostTitle("hhhh");
        post.setAppId("123");
        post.setPostAuthor(1);
        post.setPostContent("hhhh");
        post.setPostDescription("hhhh");
        postService.addPost(post);
        Post post1 = new Post();
        post1.setPostTitle("jjjj");
        post1.setAppId("123");
        post1.setPostAuthor(1);
        post1.setPostContent("jjjj");
        post1.setPostDescription("jjjj");
        postService.addPost(post1);
    }
}
