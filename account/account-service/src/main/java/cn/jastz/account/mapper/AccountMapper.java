package cn.jastz.account.mapper;

import cn.jastz.account.entity.Account;

import java.util.List;

/**
 * @author jast
 */
public interface AccountMapper {
    int deleteByPrimaryKey(Integer accountId);

    int insert(Account record);

    Account selectByPrimaryKey(Integer accountId);

    Account selectByAccount(String accountName);

    List<Account> selectAll();

    int updateByPrimaryKey(Account record);
}