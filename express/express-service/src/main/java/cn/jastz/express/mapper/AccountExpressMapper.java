package cn.jastz.express.mapper;

import cn.jastz.express.entity.AccountExpress;

import java.util.List;

public interface AccountExpressMapper {
    int deleteByPrimaryKey(Integer expressId);

    int insert(AccountExpress record);

    AccountExpress selectByPrimaryKey(Integer expressId);

    List<AccountExpress> selectAll();

    List<AccountExpress> selectByExpressIds(List<Integer> expressIds);

    int updateByPrimaryKey(AccountExpress record);
}