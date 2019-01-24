package cn.jastz.open.mapper;

import cn.jastz.open.entity.AppPayConfig;
import java.util.List;

public interface AppPayConfigMapper {
    int deleteByPrimaryKey(Long appPayConfigId);

    int insert(AppPayConfig record);

    List<AppPayConfig> selectByAppId(String appId);

    AppPayConfig selectByPrimaryKey(Long appPayConfigId);

    List<AppPayConfig> selectAll();

    int updateByPrimaryKey(AppPayConfig record);
}