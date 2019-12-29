package cn.jastz.fatui.controller.login;

import cn.jastz.app.mini.AppMiniTemplate;
import cn.jastz.app.mini.wechat.domain.WxaSessionValue;
import cn.jastz.fatui.form.CodeForm;
import cn.jastz.fatui.form.SessionVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangzhiwen on 2019/12/20
 **/
@RestController
public class WechatLoginController {

    @Autowired
    @Qualifier("wechatMiniTemplate")
    private AppMiniTemplate<WxaSessionValue> wechatMiniTemplate;

    @PostMapping("session")
    public SessionVo session(@RequestBody CodeForm codeForm){
        SessionVo sessionVo = new SessionVo();
        sessionVo.setSession(wechatMiniTemplate.getSession(codeForm.getCode(),false));
        try {
            WxaSessionValue wxaSessionValue = wechatMiniTemplate.getWechatSessionKey(sessionVo.getSession());
            //TODO 添加用户到数据库
//            codeForm.getWxaUserInfo();
            if(codeForm.getWxaUserInfo()!=null){
                sessionVo.setAvatarUrl(codeForm.getWxaUserInfo().getAvatarUrl());
                sessionVo.setNickName(codeForm.getWxaUserInfo().getNickName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sessionVo;
    }
}
