package cn.jastz.post.service;

import cn.jastz.post.entity.Post;
import cn.jastz.post.mapper.PostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhiwen
 */
@Service
public class PostService {

    @Autowired
    private PostMapper postMapper;

    public boolean addPost(Post post) {
        return postMapper.insert(post) > 0;
    }
}
