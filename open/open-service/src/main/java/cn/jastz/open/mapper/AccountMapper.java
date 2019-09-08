package cn.jastz.open.mapper;

import cn.jastz.open.entity.Account;
import org.apache.ibatis.annotations.Param;

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

    Account selectByAccountNameAndAppId(@Param("accountName") String accountName, @Param("appId") String appId);
}