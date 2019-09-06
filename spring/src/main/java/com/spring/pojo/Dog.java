package com.spring.pojo;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Dog implements ApplicationContextAware {
    public Dog() {
        System.out.println("dog...constructor...");
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

    }

    //对象创建并赋值之后调用
    @PostConstruct
    public void init(){
        System.out.println("Dog...@PostConstruct...");
    }

    //对象移除对象之前，调用
    @PreDestroy
    public void destroy(){
        System.out.println("Dog...@PreDestroy...");
    }
}
