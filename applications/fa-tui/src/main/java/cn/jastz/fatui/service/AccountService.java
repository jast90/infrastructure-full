/*
package cn.jastz.fatui.service;

import cn.jastz.app.mini.wechat.domain.WxaSessionValue;
import cn.jastz.open.client.AccountClient;
import me.jastz.common.json.result.BaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

*/
/**
 * @author zhangzhiwen on 2019/12/21
 **//*

@Service
public class AccountService {

    @Autowired
    private AccountClient accountClient;

    public BaseResult saveAccount(WxaSessionValue wxaSessionValue){
        return accountClient.addAccount(null);
    }

}
*/
