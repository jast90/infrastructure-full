package cn.jastz.post.controller;

import cn.jastz.post.PostResult;
import cn.jastz.post.form.PostAddForm;
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
public class PostController {
    @Autowired
    private PostService postService;

    @PostMapping("/post")
    public IResult addPost(@RequestBody PostAddForm postAddForm) {
        if (postService.addPost(postAddForm.toPost())) {
            return PostResult.SUCCESS;
        } else {
            return PostResult.FAIL;
        }
    }
}
