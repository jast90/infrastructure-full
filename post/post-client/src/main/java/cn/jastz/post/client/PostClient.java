package cn.jastz.post.client;

import cn.jastz.page.domain.IPage;
import cn.jastz.page.domain.PageRequest;
import cn.jastz.post.entity.Post;
import cn.jastz.post.form.PostAddForm;
import cn.jastz.post.form.PostCommentAddForm;
import me.jastz.common.json.result.BaseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @author zhiwen
 */
@FeignClient("post")
public interface PostClient {
    @PostMapping("/post")
    BaseResult addPost(@RequestBody PostAddForm postAddForm);

    @PostMapping("/post/comment")
    BaseResult addPostComment(@RequestBody PostCommentAddForm postCommentAddForm);

    @PostMapping("/post/page")
    IPage<Post> queryPage(@RequestBody PageRequest pageRequest);

    @GetMapping("/post/{id}")
    Post queryById(@PathVariable("id") int id);

    @GetMapping("/post/listByYear/{year}")
    List<Post> queryByYear(@PathVariable("year") int year);

    @GetMapping("/post/years")
    List<Integer> queryPostYears();
}
