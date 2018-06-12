package cn.jastz.cms.controller;

import cn.jastz.cms.controller.base.BaseController;
import cn.jastz.post.client.PostClient;
import cn.jastz.post.form.PostAddForm;
import me.jastz.common.json.result.BaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author zhiwen
 */
@Controller
public class PostController extends BaseController {

    @Autowired
    private PostClient postClient;

    @GetMapping("post")
    public String addPostView() {
        return "post/add";
    }

    @ResponseBody
    @PostMapping("post")
    public BaseResult addPost(PostAddForm postAddForm) {
        postAddForm.setPostAuthor(getCurrentAccountId());
        return postClient.addPost(postAddForm);
    }

}
