package cn.jastz.post.mapper;

import cn.jastz.page.domain.PageRequest;
import cn.jastz.post.entity.Post;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PostMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Post record);

    Post selectByPrimaryKey(Integer id);

    List<Post> selectAll();

    int updateByPrimaryKey(Post record);

    List<Post> queryPageByAppId(@Param("pageRequest") PageRequest pageRequest
            , @Param("appId") String appId);

    List<Post> selectAllByYear(@Param("year") int year, @Param("appId") String appId);

    List<Integer> selectYears(String appId);
}