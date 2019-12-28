package cn.jastz.fatui.config;

import cn.jastz.app.mini.AppMiniTemplate;
import cn.jastz.app.mini.auth.wechat.WechatAuthInfoFactory;
import cn.jastz.app.mini.session.Session;
import cn.jastz.app.mini.session.impl.RedisWxaSession;
import cn.jastz.app.mini.wechat.WechatMiniTemplate;
import cn.jastz.app.mini.wechat.domain.WxaSessionValue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @author zhangzhiwen on 2019/12/20
 **/
@Configuration
public class AppConfig {

    @Value("wechat.mini.appId")
    private String miniProgramAppId;
    @Value("wechat.mini.appSecret")
    private String miniProgramAppSecret;

    @Bean
    public WechatAuthInfoFactory wechatAuthInfoFactory(){
        return new WechatAuthInfoFactory(new WechatMiniTemplate(miniProgramAppId,miniProgramAppSecret));
    }

    @Bean(name = "wechatMiniTemplate")
    public AppMiniTemplate<WxaSessionValue> wechatAppMiniTemplate(){
        return new AppMiniTemplate<>(wechatAuthInfoFactory());
    }

    @Bean
    public Session  session(RedisTemplate redisTemplate){
        return new RedisWxaSession(redisTemplate);
    }

}
