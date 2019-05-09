package com.example.more;


import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@Configuration // 该注解类似于spring配置文件
@MapperScan(value="com.example.mapper.*")
public class MyBatisConfig {
    @Autowired
    private Environment env;


    @Bean
    public DataSource myTestDbDataSource() throws Exception {
        Properties props = new Properties();
        props.put("driverClassName", env.getProperty("spring.datasource.driver-class-name"));
        props.put("url", env.getProperty("spring.datasource.url"));
        props.put("username", env.getProperty("spring.datasource.username"));
        props.put("password", env.getProperty("spring.datasource.password"));
        return DruidDataSourceFactory.createDataSource(props);
    }


    @Bean
    public DataSource myTestDb02DataSource() throws Exception {
        Properties props = new Properties();
        props.put("driverClassName", env.getProperty("spring.datasource.driver-class-name2"));
        props.put("url", env.getProperty("spring.datasource.url2"));
        props.put("username", env.getProperty("spring.datasource.username2"));
        props.put("password", env.getProperty("spring.datasource.password2"));
        return DruidDataSourceFactory.createDataSource(props);
    }

    /**
       * @Primary 该注解表示在同一个接口有多个实现类可以注入的时候，默认选择哪一个，而不是让@autowire注解报错
      * @Qualifier 根据名称进行注入，通常是在具有相同的多个类型的实例的一个注入（例如有多个DataSource类型的实例）
       */
    @Bean
    @Primary
    public DynamicDataSource dataSource(@Qualifier("myTestDbDataSource") DataSource myTestDbDataSource,
                                        @Qualifier("myTestDb02DataSource") DataSource myTestDb2DataSource) {
        Map<Object, Object> targetDataSources = new HashMap<>();
        targetDataSources.put(DataSourceType.mySql01, myTestDbDataSource);
        targetDataSources.put(DataSourceType.mySql02, myTestDb2DataSource);
        DynamicDataSource dataSource = new DynamicDataSource();
        dataSource.setTargetDataSources(targetDataSources);// 该方法是AbstractRoutingDataSource的方法
        dataSource.setDefaultTargetDataSource(myTestDbDataSource);// 默认的datasource设置为myTestDbDataSource
        return dataSource;
    }


         /**
           * 根据数据源创建SqlSessionFactory
         */
         @Bean
    public SqlSessionFactory sqlSessionFactory(DynamicDataSource ds) throws Exception {
             SqlSessionFactoryBean fb = new SqlSessionFactoryBean();
             fb.setDataSource(ds);// 指定数据源(这个必须有，否则报错)
             // 下边两句仅仅用于*.xml文件，如果整个持久层操作不需要使用到xml文件的话（只用注解就可以搞定），则不加
            fb.setTypeAliasesPackage(env.getProperty("mybatis.typeAliasesPackage"));// 指定基包
            fb.setMapperLocations(
                       new PathMatchingResourcePatternResolver().getResources(env.getProperty("mybatis.mapperLocations")));//

             return fb.getObject();
           }

    /**
     * 配置事务管理器
     */
      @Bean
      public DataSourceTransactionManager transactionManager(DynamicDataSource dataSource) throws Exception {
                 return new DataSourceTransactionManager(dataSource);
      }
}
