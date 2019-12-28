package cn.jastz.fatui.mapper;

import cn.jastz.fatui.entity.Chat;
import cn.jastz.fatui.entity.Store;
import cn.jastz.page.domain.PageList;
import cn.jastz.page.domain.PageRequest;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface ChatMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Chat record);

    Chat selectByPrimaryKey(Long id);

    List<Chat> selectAll();

    int updateByPrimaryKey(Chat record);

    PageList<Chat> selectPage(@Param("pageRequest") PageRequest pageRequest, @Param("sort") Sort sort);
}