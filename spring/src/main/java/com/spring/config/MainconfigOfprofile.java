package com.spring.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.spring.pojo.Yellow;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.util.StringValueResolver;

import javax.sql.DataSource;

/**
 * Profile
 *      Spring 为我们提供了可以根据环境，动态的激活和切换一系列组件的功能
 *
 *      开发环境，测试环境，生产环境
 *      数据源：/A ,/B,/C
 * @ Profile指定组件在哪个环境的情况下才能被注册到容器中，不指定任何环境下都能注册这个组件
 *      1.加了环境标识的bean ,只有这个环境被激活的时候才能注册到容器中，默认是default环境。
 *          在虚拟机中添加参数 -Dspring.profiles.active=test
 *      2.写在配置类上，只有指定的环境的时候，整个配置类里面的所有配置才能生效。
 *      3.没有标注环境标识的bean，在任何环境都会加载。
 *
 */
//@Profile("test")
//使用值解析器
@PropertySource("classpath:/dbconfig.properties")
@Configuration
public class MainconfigOfprofile implements EmbeddedValueResolverAware {

    @Value("${db.user}")
    private String user;

    private StringValueResolver resolver;

    private String driverClass;

//    @Profile("test")
    @Bean
    public Yellow yellow(){
        return new Yellow();
    }

//    @Profile("default")
    @Profile("test")
    @Bean("testDataSource")
    public DataSource dataSourceTest(@Value("${db.password}")String pwd) throws Exception{
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser(user);
        dataSource.setPassword(pwd);
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/mysql_test");
        dataSource.setDriverClass(driverClass);
        return dataSource;
    }

    @Profile("dev")
    @Bean("devDataSource")
    public DataSource dataSourceDev(@Value("${db.password}")String pwd) throws Exception{
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser(user);
        dataSource.setPassword(pwd);
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/mysql");
        dataSource.setDriverClass(driverClass);
        return dataSource;
    }

    @Profile("pro")
    @Bean("proDataSource")
    public DataSource dataSourcePro(@Value("${db.password}")String pwd) throws Exception{
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser(user);
        dataSource.setPassword(pwd);
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test");
        dataSource.setDriverClass(driverClass);
        return dataSource;
    }

    public void setEmbeddedValueResolver(StringValueResolver resolver) {
        this.resolver=resolver;
        driverClass = resolver.resolveStringValue("${db.driverClass}");
    }
}
