package com.spring.config;

import com.spring.dao.BookDao;
import com.spring.pojo.Car;
import com.spring.pojo.Color;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * 自动装配，
 *      spring依赖DI自动装配
 * 1),autowired 自动注入
 *      1，默认优先按照类型去容器中找对应的组件，applicationContext.getBean(BookDao.class);
 *      2,如果找到多个相同类型的组件，再将属性的名称作为组件的id去容器中查找
 *          applicationContext.getBean("BookDao")
 *      3,qualifier("bookDao")使用@Qualifer指定需要装配的组件的id,而不是使用属性名
 *      4，自动装配默认一定要将属性赋值好，没有就会报错。
 *          可以使用@Autowired(required = false)
 *      5，@Primary，让spring进行自动装配，使用首选装配bean
 *      BookService{
 *         @Autowired
 *         BookDao bookdao;
 *      }
 * 2),spring 换支持使用@resource(Js250)和  @Inject (JSR330)
 *          @ Resource:可以和@Autowired一样实现自动装配，默认是按照组件名称进行装配的
 *          没有能支持@Primary功能，没有@autowired(required=false)功能
 *          @ Inject
 *          需要导入@ autowired一样，但是需要导入javax.inject包
 * 不同之处：
 * @autowired:是spring支持的
 * @resource和@inject：是java底层的规范
 *
 * 3),@Autowired:构造器，参数，方法，属性，
 *         1，构造器，
 *         2，方法上
 *         3，参数位置：如果只有一个有参构造器，这个构造器参数位置的@autoWired可以省略，
 *
 * 4),自定义组件想要使用Spring容器底层的一些组件（applicationContext,BeanFactory,xxx）
 *      自定义组件实现xxxAware.在创建对象的时候，会调用接口规定的方法注入相关的组件Aware，
 *      把spring底层的一些组件注入到自定义的bean中
 *      xxxAware:功能使用xxxProcessor
 *          ApplicationContextAware==>ApplicationContextAwareProcessor
 *
 */


@Configuration
@ComponentScan({"com.spring.dao",
        "com.spring.service",
        "com.spring.controller",
        "com.spring.pojo",
})
public class MainConfigOfAutowired {

    @Primary
    @Bean("bookDao2")
    public BookDao bookDao(){
        BookDao bookDao = new BookDao();
        bookDao.setLable("2");
        return bookDao;
    }

    /**
     * @bean标注的方法创建对象的时候，方法参数的值从容器中获取
     *
     * @param car
     * @return
     */
    @Bean
    public Color color(Car car){
        Color color = new Color();
        color.setCar(car);
        return color;
    }
}
