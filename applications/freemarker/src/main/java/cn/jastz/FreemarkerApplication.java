package cn.jastz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author zhiwen
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class FreemarkerApplication {


    public static void main(String[] args) {
        SpringApplication.run(FreemarkerApplication.class, args);
    }

}
