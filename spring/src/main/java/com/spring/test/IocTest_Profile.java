package com.spring.test;

import com.spring.config.MainconfigOfprofile;
import com.spring.pojo.Yellow;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;

public class IocTest_Profile {
    //创建一个无参数的对象，容器
    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

    /**
     * 1,运行的参数
     */
    @Test
    public void test01(){
        //创建一个容器
        //1.设置需要激活的环境
        applicationContext.getEnvironment().setActiveProfiles("test");
        //2.注册主配置类
        applicationContext.register(MainconfigOfprofile.class);
        //3.启动刷新容器
        applicationContext.refresh();

        String[] names = applicationContext.getBeanNamesForType(DataSource.class);
        for (String name:names) {
            System.out.println(name);
        }

        Yellow yellow = applicationContext.getBean(Yellow.class);
        System.out.println(yellow);
    }

}
