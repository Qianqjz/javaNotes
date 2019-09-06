package com.spring.test;

import com.spring.config.MainConfigOfLifeCycle;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IocTest_LifeCycle {

    @Test
    public void test01() {
        //创建Ioc容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfLifeCycle.class);
        System.out.println("容器创建成功...");

        applicationContext.getBean("car");
        //容器关闭
        applicationContext.close();
    }
}