package cn.jastz.fatui.config;

import cn.jastz.page.mybatis.PageInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhiwen
 */
@Configuration
public class MybatisConfig {
    @Bean
    public PageInterceptor pageInterceptor() {
        return new PageInterceptor();
    }
}
