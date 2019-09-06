package com.spring.config;

import com.spring.pojo.Person;
import com.spring.service.BookService;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Controller;

@Configuration
@ComponentScans(value ={
        @ComponentScan(value = "com.spring" ,includeFilters ={
        @ComponentScan.Filter(type= FilterType.ANNOTATION,classes = {Controller.class}),
        @ComponentScan.Filter(type= FilterType.ASSIGNABLE_TYPE,classes = {BookService.class}),
        @ComponentScan.Filter(type= FilterType.CUSTOM,classes = {MyTypFilter.class})
},useDefaultFilters = false)})
public class config {

    @Bean
    public Person person(){
        return new Person("zhangsan",12);

    }
}
