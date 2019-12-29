package cn.jastz.fatui.controller;

import cn.jastz.fatui.entity.Post;
import cn.jastz.fatui.entity.Store;
import cn.jastz.fatui.mapper.PostMapper;
import cn.jastz.page.domain.Page;
import cn.jastz.page.domain.PageList;
import cn.jastz.page.domain.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

/**
 * @author zhangzhiwen on 2019/12/29
 **/
@RestController
public class PostController {

    @Autowired
    private PostMapper postMapper;

    @PostMapping("/post/page")
    public Page<Post> page(@RequestBody PageRequest pageRequest){
        PageList<Post> pageList =  postMapper.selectPage(pageRequest, Sort.by("create_time").descending());
        return pageList.getPage();
    }

    @GetMapping("/post/{id}")
    public Post detail(@PathVariable("id") long id){
        Post post = postMapper.selectByPrimaryKey(id);
        return post;
    }
}
