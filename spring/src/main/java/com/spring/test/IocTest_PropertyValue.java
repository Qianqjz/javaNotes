package com.spring.test;

import com.spring.config.MainConfigOfPropertyValue;
import com.spring.pojo.Person;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

public class IocTest_PropertyValue {

    AnnotationConfigApplicationContext applicationContext
            = new AnnotationConfigApplicationContext(MainConfigOfPropertyValue.class);
    @Test
    public void test01() {
        printBeans(applicationContext);
        System.out.println("=============");

        Person person = (Person) applicationContext.getBean("person");
        System.out.println(person);


        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        String property = environment.getProperty("person.nickName");
        System.out.println(property);
        applicationContext.close();
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