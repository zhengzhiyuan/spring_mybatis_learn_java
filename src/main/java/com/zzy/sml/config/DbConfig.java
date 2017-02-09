package com.zzy.sml.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 数据库配置
 */
@Configuration
@EnableTransactionManagement
public class DbConfig {

    @Autowired
    private Environment env;

    /**
     * 取得dataSource
     * 
     * @return
     */
    @Bean(name = "dataSource", destroyMethod = "close")
    public BasicDataSource getDataSource(@Value("${db.url}") String url, @Value("${db.username}") String username, @Value("${db.password}") String password,
            @Value("${db.initailSize}") int initailSize, @Value("${db.maxIdle}") int maxIdle) {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setInitialSize(initailSize);
        dataSource.setMaxIdle(maxIdle);
        // default:1000*60*30 连接在池中保持空闲而不被空闲连接回收器线程(如果有)回收的最小时间值,单位毫秒 -->
        dataSource.setMinEvictableIdleTimeMillis(60000);
        // default:不限制 statement池能够同时分配的打开的statements的最大数量,如果设置为0表示不限制
        dataSource.setMaxOpenPreparedStatements(20);
        // 指明是否在从池中取出连接前进行检验,如果检验失败,则从池中去除连接并尝试取出另一个.注意: 设置为true后如果要生效,validationQuery参数必须设置为非空字符串
        dataSource.setTestOnBorrow(true);
        // SQL查询,用来验证从连接池取出的连接,在将连接返回给调用者之前.如果指定,则查询必须是一个SQL SELECT并且必须返回至少一行记录
        dataSource.setValidationQuery("select 1");
        return dataSource;
    }

    /**
     * SessionFactory
     * 
     * @param dataSource
     * @return
     */
    @Bean("sqlSessionFactoryBean")
    @Autowired
    public SqlSessionFactoryBean getSqlSessionFactoryBean(BasicDataSource dataSource) {

        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);

        Resource mapperLocation = new ClassPathResource("classpath*:mappers/**/*.xml");
        Resource[] mapperLocations = { mapperLocation };
        sqlSessionFactoryBean.setMapperLocations(mapperLocations);

        Resource configLocation = new ClassPathResource("classpath:mybatis-config.xml");
        sqlSessionFactoryBean.setConfigLocation(configLocation);
        return sqlSessionFactoryBean;
    }

    /**
     * 事务管理器
     * 
     * @param dataSource
     * @return
     */
    @Bean("transactionManager")
    @Autowired
    public DataSourceTransactionManager getTransactionManager(BasicDataSource dataSource) {
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
        transactionManager.setDataSource(dataSource);
        return transactionManager;
    }

}
