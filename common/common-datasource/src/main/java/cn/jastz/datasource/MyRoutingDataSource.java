package cn.jastz.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 设置多个数据源
 */
public class MyRoutingDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        if(DBContextHolder.get()!=null){
            return DBContextHolder.get().name();
        }
        return null;
    }
}
