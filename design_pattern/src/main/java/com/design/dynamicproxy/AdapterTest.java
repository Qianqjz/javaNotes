package com.design.dynamicproxy;

import org.junit.Test;

/**
 * 什么是代理？
 * 	简单点讲，代理就是帮[目标对象]去完成它应该做，但是不想或者不擅长做的事情。
 *
 * 	例子：
 *
 *  微信叫电话费
 *  房屋中间：
 * 	媒婆：帮你找对象。
 * 	黄牛：帮你去挂号。
 * 	社保代办：帮你缴纳社保。
 *
 *  代理模式分为静态代理和动态代理
 * 	 静态代理：就是编写一个代理类，去代理[目标对象]
 * 	 动态代理：在运行期间，通过反射，对[目标对象]产生一个[代理对象]
 *
 * 动态代理的实现方式分为两种，下面两种方式生成的代理类都是继承了Proxy：
 * 	JDK实现的		：基于接口的，也就是说[目标对象]必须实现一个接口，[目标对象]和[代理对象]都实现该接口
 * 	cglib实现的	：可以被继承的普通类，它是通过继承的方式，产生一个子类，这个子类就是代理类
 *
 * 为什么使用动态代理呢？
 * 	增强对象的功能。这种增强，是符合开闭原则的，不会对目标对象进行修改，只需要扩展就可以实现增强
 *
 */
public class AdapterTest {
    @Test
    public void JDKProxy(){
        UserService service = new UserServiceImpl();
        JDKFactoryProxy jdkFactoryProxy=new JDKFactoryProxy(service);
        Object proxy = (UserService)jdkFactoryProxy.getProxy();

        service.save();
        System.out.println("==============");
        ((UserService) proxy).save();
    }

    @Test
    public void cgLibProxy(){
        UserService service = new UserServiceImpl();
        CgLibFactoryProxy cgLibFactoryProxy=new CgLibFactoryProxy();
        Object cglibProxy = (UserServiceImpl)cgLibFactoryProxy.getProxyByCglib(service.getClass());
        service.save();
        System.out.println("===============");
        ((UserServiceImpl) cglibProxy).save();
    }
}
