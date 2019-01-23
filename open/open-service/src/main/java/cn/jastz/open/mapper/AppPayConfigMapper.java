package cn.jastz.open.mapper;

import cn.jastz.open.entity.AppPayConfig;
import java.util.List;

public interface AppPayConfigMapper {
    int deleteByPrimaryKey(Long appPayConfigId);

    int insert(AppPayConfig record);

    AppPayConfig selectByPrimaryKey(Long appPayConfigId);

    List<AppPayConfig> selectAll();

    int updateByPrimaryKey(AppPayConfig record);
}