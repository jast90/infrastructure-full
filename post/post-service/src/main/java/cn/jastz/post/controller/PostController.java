package cn.jastz.post.controller;

import cn.jastz.common.controller.CommonBaseController;
import cn.jastz.page.domain.IPage;
import cn.jastz.page.domain.Page;
import cn.jastz.page.domain.PageRequest;
import cn.jastz.post.PostResult;
import cn.jastz.post.entity.Post;
import cn.jastz.post.form.PostAddForm;
import cn.jastz.post.form.PostCommentAddForm;
import cn.jastz.post.service.PostService;
import me.jastz.common.json.result.IResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author zhiwen
 */
@RestController
public class PostController extends CommonBaseController {
    @Autowired
    private PostService postService;

    @PostMapping("/post")
    public IResult addPost(@RequestBody PostAddForm postAddForm) {
        postAddForm.setAppId(getAppId());
        if (postService.addPost(postAddForm.toPost())) {
            return PostResult.SUCCESS;
        } else {
            return PostResult.FAIL;
        }
    }

    @PostMapping("/post/comment")
    public IResult addPostComment(@RequestBody PostCommentAddForm postCommentAddForm) {
        postCommentAddForm.setAppId(getAppId());
        if (postService.addPostComment(postCommentAddForm)) {
            return PostResult.SUCCESS;
        } else {
            return PostResult.FAIL;
        }
    }

    @PostMapping("/post/page")
    public IPage<Post> queryPage(@RequestBody PageRequest pageRequest) {
        Page<Post> page = postService.queryPageByAppId(pageRequest, getAppId());
        return page;
    }

    @GetMapping("/post/{id}")
    public Post queryById(@PathVariable("id") int id) {
        return postService.queryByIdAndAppId(id);
    }

    @GetMapping("/post/listByYear/{year}")
    public List<Post> queryByYear(@PathVariable("year") int year) {
        return postService.queryListByYear(year, getAppId());
    }

    @GetMapping("/post/years")
    public List<Integer> queryPostYears() {
        return postService.queryPostYears(getAppId());
    }
}
