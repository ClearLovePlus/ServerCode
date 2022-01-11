package com.chenhao.dao.plugin;

import org.apache.ibatis.cache.CacheKey;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ResultMap;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.lang.reflect.Field;
import java.util.*;

/**
 * @description: 自定义的mysql分页插件
 * 分页拦截器，用于拦截需要进行分页查询的操作，然后对其进行分页处理。利用拦截器实现Mybatis分页的原理： 要利用JDBC对数据库进行操作就必须要有一个对应的Statement对象，
 * Mybatis在执行Sql语句前就会产生一个包含Sql语句的Statement对象， 而且对应的Sql语句是在Statement之前产生的，所以我们就可以在它生成Statement之前对用来生成Statement
 * 的Sql语句下手。 在Mybatis中Statement语句是通过RoutingStatementHandler对象的prepare方法生成的。 所以利用拦截器实现Mybatis分页的一个思路就是拦截StatementHandler
 * 接口的prepare方法，然后在拦截器方法中把Sql语句改成对应的分页查询Sql语句，之后再调用 StatementHandler对象的prepare方法，即调用invocation.proceed()。 对于分页而言，
 * 在拦截器里面我们还需要做的一个操作就是统计满足当前条件的记录一共有多少， 这是通过获取到了原始的Sql语句后，把它改为对应的统计语句再利用Mybatis封装好的参数和设 置参数的功能把
 * Sql语句中的参数进行替换，之后再执行查询记录数的Sql语句进行总记录数的统计
 * @author: chenhao
 * @date: 2022-1-10 14:32
 */
@Intercepts(@Signature(type = Executor.class,method = "query",args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class}))
public class DefaultPageInterceptor implements Interceptor {
    private static final String COUNT_SQL="select count(*) from (%s)temp";
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        Object[] args=invocation.getArgs();
        MappedStatement ms= (MappedStatement) args[0];
        Object parameterObject=args[1];
        RowBounds rowBounds= (RowBounds) args[2];
        if(rowBounds !=RowBounds.DEFAULT){
            Executor executor= (Executor) invocation.getTarget();
            BoundSql boundSql= ms.getBoundSql(parameterObject);
            Field additionalParametersField = BoundSql.class.getDeclaredField("additionalParameters");
            additionalParametersField.setAccessible(true);
            Map<String, Object> additionalMap= (Map<String, Object>) additionalParametersField.get(boundSql);
            if (rowBounds instanceof DefaultRowBounds){
                MappedStatement standMs= newMs(ms,Long.class);
                CacheKey cacheKey=executor.createCacheKey(standMs,parameterObject,RowBounds.DEFAULT,boundSql);
                String countSql=String.format(COUNT_SQL,boundSql.getSql());
                BoundSql countBoundSql=new BoundSql(ms.getConfiguration(),countSql,boundSql.getParameterMappings(),parameterObject);
                for(String key:additionalMap.keySet()){
                    countBoundSql.setAdditionalParameter(key,additionalMap.get(key));
                }
                List<Object> countQueryResult = executor.query(standMs, parameterObject, RowBounds.DEFAULT, (ResultHandler) args[3], cacheKey, countBoundSql);
                Long count = (Long) countQueryResult.get(0);
                ((DefaultRowBounds) rowBounds).setTotal(count);
            }
            CacheKey pageKey=executor.createCacheKey(ms,parameterObject,rowBounds,boundSql);
            pageKey.update("RowBounds");
            String pageSql=boundSql.getSql()+" limit "+ rowBounds.getOffset()+"," + rowBounds.getLimit();
            BoundSql pageBoundSql = new BoundSql(ms.getConfiguration(), pageSql, boundSql.getParameterMappings(), parameterObject);
            for(String key:additionalMap.keySet()){
                pageBoundSql.setAdditionalParameter(key,additionalMap.get(key));
            }
            return executor.query(ms,parameterObject,RowBounds.DEFAULT,(ResultHandler) args[3], pageKey, pageBoundSql);
        }

        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target,this);
    }

    @Override
    public void setProperties(Properties properties) {

    }

    private MappedStatement newMs(MappedStatement ms,Class<Long> longClass){
        MappedStatement.Builder builder=new MappedStatement.Builder(ms.getConfiguration(),ms.getId()+"_count",ms.getSqlSource(),ms.getSqlCommandType());
        ResultMap resultMap=new ResultMap.Builder(ms.getConfiguration(), ms.getId(), longClass, new ArrayList<>(0)).build();
        builder.resource(ms.getResource())
                .fetchSize(ms.getFetchSize())
                .statementType(ms.getStatementType())
                .timeout(ms.getTimeout())
                .parameterMap(ms.getParameterMap())
                .resultSetType(ms.getResultSetType())
                .cache(ms.getCache())
                .flushCacheRequired(ms.isFlushCacheRequired())
                .useCache(ms.isUseCache())
                .resultMaps(Arrays.asList(resultMap));
        if(ms.getKeyProperties()!=null && ms.getKeyProperties().length>0){
            StringBuilder keyBuilder=new StringBuilder();
            for(String keyProperty:ms.getKeyProperties()){
                keyBuilder.append(keyProperty).append(",");
            }
            keyBuilder.delete(keyBuilder.length() - 1, keyBuilder.length());
            builder.keyProperty(keyBuilder.toString());
        }
        return builder.build();
    }
}
