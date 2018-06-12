package cn.jastz.post.controller;

import cn.jastz.common.controller.CommonBaseController;
import cn.jastz.post.PostResult;
import cn.jastz.post.form.PostAddForm;
import cn.jastz.post.form.PostCommentAddForm;
import cn.jastz.post.service.PostService;
import me.jastz.common.json.result.IResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
}
