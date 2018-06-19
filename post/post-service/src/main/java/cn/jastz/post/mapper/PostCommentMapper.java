package cn.jastz.post.mapper;

import cn.jastz.post.entity.PostComment;

import java.util.List;

public interface PostCommentMapper {
    int deleteByPrimaryKey(Integer commentId);

    int insert(PostComment record);

    PostComment selectByPrimaryKey(Integer commentId);

    List<PostComment> selectAll();

    int updateByPrimaryKey(PostComment record);
}