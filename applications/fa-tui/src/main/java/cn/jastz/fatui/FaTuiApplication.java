package cn.jastz.fatui;

import cn.jastz.fatui.redis.JsonRedisSerializer;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @author zhiwen
 */
@SpringBootApplication(scanBasePackages = {"cn.jastz"})
@MapperScan(basePackages = {"cn.jastz.fatui.mapper"})
public class FaTuiApplication {

    public static void main(String[] args) {
        SpringApplication.run(FaTuiApplication.class, args);
    }

    @Bean
    public RedisTemplate redisTemplate(RedisConnectionFactory rcf) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(rcf);
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(new JsonRedisSerializer());
        return template;
    }

}
