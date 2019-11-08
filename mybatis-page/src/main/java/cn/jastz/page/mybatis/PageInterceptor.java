package cn.jastz.page.mybatis;

import cn.jastz.page.domain.Page;
import cn.jastz.page.domain.PageList;
import cn.jastz.page.domain.PageRequest;
import org.apache.ibatis.cache.CacheKey;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ResultMap;
import org.apache.ibatis.mapping.ResultMapping;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * @author zhiwen
 */
@Intercepts({
        @Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class, CacheKey.class, BoundSql.class}),
        @Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class})
})
public class PageInterceptor implements Interceptor {

    private DBType dbType;

    public PageInterceptor() {
        this.dbType = DBType.MYSQL;
    }

    public PageInterceptor(DBType dbType) {
        this.dbType = dbType;
    }

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        System.out.println("Page plugin");
        Object[] args = invocation.getArgs();
        MappedStatement ms = (MappedStatement) args[0];
        Object parameter = args[1];
        RowBounds rowBounds = (RowBounds) args[2];
        ResultHandler resultHandler = (ResultHandler) args[3];
        Executor executor = (Executor) invocation.getTarget();
        CacheKey cacheKey;
        BoundSql boundSql;
        //由于逻辑关系，只会进入一次
        if (args.length == 4) {
            //4 个参数时
            boundSql = ms.getBoundSql(parameter);
            cacheKey = executor.createCacheKey(ms, parameter, rowBounds, boundSql);
        } else {
            //6 个参数时
            cacheKey = (CacheKey) args[4];
            boundSql = (BoundSql) args[5];
        }

        PageRequest pageRequest = null;
        try {
            pageRequest = getPageRequest(parameter);
        } catch (Exception e) {

        }

        if (pageRequest == null) {
            return invocation.proceed();
        }

        BoundSql pageBoundSql = pageBoundSql(ms.getConfiguration(), boundSql, pageRequest, parameter);
        long total = queryTotal(newCountMappedStatement(ms, String.format("%s%s", ms.getId(), "_COUNT")), executor
                , boundSql, parameter, resultHandler);
        List list = new ArrayList();
        if(total>0){
            list = executor.query(ms, parameter, rowBounds, resultHandler, cacheKey, pageBoundSql);
        }
        Page page = new Page(list, pageRequest, total);
        PageList pageList = new PageList();
        pageList.setPage(page);
        return pageList;
    }

    private PageRequest getPageRequest(Object parameter) {
        Map map = (Map) parameter;
        Object object = map.get("pageRequest");
        return (PageRequest) object;
    }

    private Long queryTotal(MappedStatement ms, Executor executor, BoundSql boundSql, Object parameter
            , ResultHandler resultHandler) throws SQLException {
        //创建 count 查询的缓存 key
        CacheKey countKey = executor.createCacheKey(ms, parameter, RowBounds.DEFAULT, boundSql);
        String countSql = getCountSql(boundSql);
        BoundSql countBoundSql = new BoundSql(ms.getConfiguration(), countSql, boundSql.getParameterMappings(), parameter);
        Object countResultList = executor.query(ms, parameter, RowBounds.DEFAULT, resultHandler, countKey, countBoundSql);
        Long count = (Long) ((List) countResultList).get(0);
        return count;
    }

    private BoundSql pageBoundSql(Configuration configuration, BoundSql boundSql, PageRequest pageRequest, Object parameter) {
        String pageSql = getPageSql(boundSql, pageRequest);
        BoundSql pageBoundSql = new BoundSql(configuration, pageSql, boundSql.getParameterMappings(), parameter);
        return pageBoundSql;
    }

    private String getCountSql(BoundSql boundSql) {
        String pageSql = null;
        switch (this.dbType) {
            case MYSQL:
                pageSql = String.format("select count(1) from (%s) as temp", boundSql.getSql());
        }
        return pageSql;
    }

    private String getPageSql(BoundSql boundSql, PageRequest pageRequest) {
        String pageSql = null;
        switch (this.dbType) {
            case MYSQL:
                pageSql = String.format("select * from (%s) as temp limit %s,%s", boundSql.getSql(), pageRequest.getOffset(),
                        pageRequest.getPageSize());
        }
        return pageSql;
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {

    }


    private MappedStatement newCountMappedStatement(MappedStatement ms, String newMsId) {
        MappedStatement.Builder builder = new MappedStatement.Builder(ms.getConfiguration(), newMsId, ms.getSqlSource(), ms.getSqlCommandType());
        builder.resource(ms.getResource());
        builder.fetchSize(ms.getFetchSize());
        builder.statementType(ms.getStatementType());
        builder.keyGenerator(ms.getKeyGenerator());
        if (ms.getKeyProperties() != null && ms.getKeyProperties().length != 0) {
            StringBuilder keyProperties = new StringBuilder();
            for (String keyProperty : ms.getKeyProperties()) {
                keyProperties.append(keyProperty).append(",");
            }
            keyProperties.delete(keyProperties.length() - 1, keyProperties.length());
            builder.keyProperty(keyProperties.toString());
        }
        builder.timeout(ms.getTimeout());
        builder.parameterMap(ms.getParameterMap());
        //count查询返回值int
        List<ResultMap> resultMaps = new ArrayList<ResultMap>();
        ResultMap resultMap = new ResultMap.Builder(ms.getConfiguration(), ms.getId(), Long.class, new ArrayList<ResultMapping>(0)).build();
        resultMaps.add(resultMap);
        builder.resultMaps(resultMaps);
        builder.resultSetType(ms.getResultSetType());
        builder.cache(ms.getCache());
        builder.flushCacheRequired(ms.isFlushCacheRequired());
        builder.useCache(ms.isUseCache());

        return builder.build();
    }
}
