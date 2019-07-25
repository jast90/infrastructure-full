package cn.jastz.open.mapper;

import cn.jastz.open.entity.AppPayConfig;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppPayConfigMapper {
    int deleteByPrimaryKey(Long appPayConfigId);

    int insert(AppPayConfig record);

    List<AppPayConfig> selectByAppId(String appId);

    AppPayConfig selectByPrimaryKey(Long appPayConfigId);

    List<AppPayConfig> selectAll();

    int updateByPrimaryKey(AppPayConfig record);
}
