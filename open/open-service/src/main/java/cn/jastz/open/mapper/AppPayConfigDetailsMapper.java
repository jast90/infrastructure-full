package cn.jastz.open.mapper;

import cn.jastz.open.entity.AppPayConfigDetails;
import java.util.List;

public interface AppPayConfigDetailsMapper {
    int insert(AppPayConfigDetails record);

    int batchInsert(List<AppPayConfigDetails> records);

    List<AppPayConfigDetails> selectAll();
}