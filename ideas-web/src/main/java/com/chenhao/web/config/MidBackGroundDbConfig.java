package com.chenhao.web.config;

import org.apache.ibatis.io.VFS;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.SpringBootVFS;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * @description:中后台数据源配置
 * @author: chenhao
 * @date: 2021-1-14 14:45
 */
@Configuration
@MapperScan(basePackages = {"com.chenhao.dao.mapper"},sqlSessionFactoryRef = "blogDbSqlFactory")
public class MidBackGroundDbConfig {

    @ConfigurationProperties(prefix = "spring.datasource.blog")
    @Bean("blogBDataSource")
    @Primary
    public DataSource blogDb(){
       return DataSourceBuilder.create().build();
    }

    @Bean(name = "blogDbSqlFactory")
    public SqlSessionFactory blogFactory(@Qualifier("blogBDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean=new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mapper/blog/*.xml"));
        System.out.println("blog datasource init successfully");
        return bean.getObject();
    }

    @Bean(name = "blogSqlTemplate")
    public SqlSessionTemplate blogTemplate(@Qualifier("blogDbSqlFactory") SqlSessionFactory factory)
    {
        return new SqlSessionTemplate(factory);
    }

}
