package cn.jastz.product.config;

import cn.jastz.datasource.DBTypeEnum;
import cn.jastz.datasource.MyRoutingDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangzhiwen on 2019/10/26
 **/
@Configuration
public class DataSourceConfig {

    @Bean("productWrite")
    @ConfigurationProperties("spring.datasource")
    public DataSource productWrite(){
        return DruidDataSourceBuilder.create().build();
    }

    @Bean("stackOverFlow")
    @ConfigurationProperties("stack.over.flow.write")
    public DataSource stackOverFlow(){
        return DruidDataSourceBuilder.create().build();
    }

    @Autowired
    @Bean("dataSource")
    public DataSource dataSource(DataSource productWrite, DataSource stackOverFlow){
        MyRoutingDataSource myRoutingDataSource = new MyRoutingDataSource();
        Map<Object,Object> dataSources = new HashMap<>(10);
        dataSources.put(DBTypeEnum.MASTER.name(),productWrite);
        dataSources.put(DBTypeEnum.STACK.name(),stackOverFlow);
        myRoutingDataSource.setTargetDataSources(dataSources);
        return myRoutingDataSource;
    }

    @Autowired
    @Bean(name = "transactionManager")
    public DataSourceTransactionManager getTransactionManager(DataSource dataSource) {
        DataSourceTransactionManager txManager = new DataSourceTransactionManager();
        txManager.setDataSource(dataSource);
        return txManager;
    }


}
