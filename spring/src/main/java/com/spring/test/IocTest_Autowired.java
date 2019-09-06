package com.spring.test;

import com.spring.config.MainConfigOfAutowired;
import com.spring.pojo.Boss;
import com.spring.pojo.Car;
import com.spring.pojo.Color;
import com.spring.service.BookService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IocTest_Autowired {

    AnnotationConfigApplicationContext applicationContext
            = new AnnotationConfigApplicationContext(MainConfigOfAutowired.class);
    @Test
    public void test01() {
        BookService bean = applicationContext.getBean(BookService.class);
        System.out.println(bean);

//        BookDao bean1 = applicationContexttext.getBean(BookDao.class);
//        System.out.println(bean1);

        //使用的car都是一样的。
        Boss boss = applicationContext.getBean(Boss.class);
        System.out.println(boss);
        Car car = applicationContext.getBean(Car.class);
        System.out.println(car);

        Color color = applicationContext.getBean(Color.class);
        System.out.println(color);


    }
    /**
     * 打印所有的bean
     * @param applicationgcontext
     */
    private void printBeans( ApplicationContext applicationgcontext){
        String[] beanDefinitionNames = applicationgcontext.getBeanDefinitionNames();
        for (String beanName:beanDefinitionNames
        ) {
            System.out.println(beanName);
        }
    }
}