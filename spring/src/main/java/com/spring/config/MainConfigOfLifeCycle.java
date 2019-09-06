package com.spring.config;

import com.spring.pojo.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * bean的生命周期：
 *      bean的创建---初始化----销毁的过程
 * 容器管理Bean的生命周期
 * 我们可以自定义初始化和销毁方法，容器在Bean进行到当前生命周期的时候来调用我们自定义的初始化和销毁方法。
 *
 *  构造(对象创建)
 *      单实例，在容器启动的时候创建对象
 *      多实例，在每次获取的时候创建对象
 *
 *  初始化：
 *      对象创建完成，并赋值好，调用初始化方法
 *   销毁：
 *      容器关闭的时候。
 *
 *      单实例：容器关闭的时候
 *      多实例：容器只创建，不销毁，
 *
 *
 * 1),指定初始化和销毁方法：
 *     init_method 和destroy_method
 * 2),通过bean实现InitializingBean(定义初始化方法)接口
 *              DisposableBean(定义销毁方法)
 *
 * 3),可以使用JSR250
 *      @ PostConstruct,在bean创建完成并且属性赋值完成，来执行初始化方法
 *      @ PreDestroy,在容器销毁Bean之前通知我们进行清理工作。
 *
 * 4),BeanPostProcessor,bean的后置处理器
 *      postProcessBeforeInitialization:在初始化之前调用，
 *      postProcessAfterInitialization：在初始化之后调用
 */

@ComponentScan("com.spring.pojo")
@Configuration
public class MainConfigOfLifeCycle {

    @Scope("prototype")
    @Bean(initMethod = "init",destroyMethod = "destroy")
    public Car car(){
        return new Car();
    }

}
