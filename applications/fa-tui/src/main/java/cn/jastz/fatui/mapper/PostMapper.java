package cn.jastz.fatui.mapper;

import cn.jastz.fatui.entity.Post;
import cn.jastz.page.domain.PageList;
import cn.jastz.page.domain.PageRequest;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface PostMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Post record);

    Post selectByPrimaryKey(Long id);

    List<Post> selectAll();

    int updateByPrimaryKey(Post record);

    PageList<Post> selectPage(@Param("pageRequest") PageRequest pageRequest, @Param("sort") Sort sort);
}