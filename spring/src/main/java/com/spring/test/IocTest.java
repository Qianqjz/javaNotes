package com.spring.test;

import com.spring.config.config;
import com.spring.config.config2;
import com.spring.pojo.Person;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;

import java.util.Map;

public class IocTest {
    ApplicationContext applicationgcontext=new AnnotationConfigApplicationContext(config2.class);


    @Test
    public void testImport(){
        printBeans(applicationgcontext);

        //工厂bean获取的是调用getObject获取的对象，
        Object colorFactoryBean = applicationgcontext.getBean("colorFactoryBean");
        Object colorFactoryBean1 = applicationgcontext.getBean("colorFactoryBean");

        System.out.println("Bean的类型-->  "+colorFactoryBean.getClass());
        System.out.println("Bean1的类型-->  "+colorFactoryBean1.getClass());
        System.out.println(colorFactoryBean==colorFactoryBean1);

        //加&获取的是工厂Bean本身
        Object colorFactoryBean4 = applicationgcontext.getBean("&colorFactoryBean");
        System.out.println(colorFactoryBean4);
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
    @Test
    public void test02(){

        Environment environment = applicationgcontext.getEnvironment();
//        String property = environment.getProperty("os.name");
//        System.out.println(property);

        String[] namesForType = applicationgcontext.getBeanNamesForType(Person.class);
        for (String name:namesForType) {
            System.out.println("-->"+name);
        }

        Map<String, Person> persons = applicationgcontext.getBeansOfType(Person.class);
        System.out.println(persons);
    }

    @Test
    public void test01(){
        System.out.println("IOC容器加载");
        applicationgcontext=new AnnotationConfigApplicationContext(config2.class);
        Person person=applicationgcontext.getBean(Person.class);
        System.out.println(person);

        Person person_1=applicationgcontext.getBean(Person.class);
        System.out.println(person_1);

        System.out.println(person==person_1);
    }

    @Test
    public void test(){
        AnnotationConfigApplicationContext annotationConfigApplicationContext
                = new AnnotationConfigApplicationContext(config.class);

        String[] beandifinations=annotationConfigApplicationContext.getBeanDefinitionNames();

        for(String str :beandifinations){
            System.out.println(str);
        }
    }



}
