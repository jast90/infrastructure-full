package cn.jastz.cms.controller;

import cn.jastz.cms.controller.base.BaseController;
import cn.jastz.page.domain.IPage;
import cn.jastz.page.domain.PageRequest;
import cn.jastz.post.client.PostClient;
import cn.jastz.post.entity.Post;
import cn.jastz.post.form.PostAddForm;
import cn.jastz.post.form.PostCommentAddForm;
import me.jastz.common.json.result.BaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("post/{id}")
    public String detail(@PathVariable("id") int id, Model model) {
        model.addAttribute("post", postClient.queryById(id));
        return "post/detail";
    }

    @ResponseBody
    @PostMapping("post/comment")
    public BaseResult addPost(PostCommentAddForm postCommentAddForm) {
        postCommentAddForm.setCommentAuthor(getCurrentAccountId());
        return postClient.addPostComment(postCommentAddForm);
    }

    @ResponseBody
    @GetMapping("/post/page/{page}")
    public IPage<Post> queryPage(@PathVariable("page") int page) {
        return postClient.queryPage(PageRequest.of(page - 1, 15));
    }
}
