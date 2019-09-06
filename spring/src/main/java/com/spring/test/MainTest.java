package com.spring.test;

import com.spring.config.config;
import com.spring.pojo.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainTest {
    public static void main(String[] args){

        ApplicationContext applicationgcontext=new AnnotationConfigApplicationContext(config.class);
        Person person=applicationgcontext.getBean(Person.class);
        System.out.print(person);
    }
}
