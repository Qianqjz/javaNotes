package com.design.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDKFactoryProxy implements InvocationHandler {

    public Object target;

    public JDKFactoryProxy(Object target) {
        this.target = target;
    }

    /**
     * 如何生成一个代理类呢？
     * 	1、编写源文件
     * 	2、编译源文件为class文件
     * 	3、将class文件加载到JVM中(ClassLoader)
     * 	4、将class文件对应的对象进行实例化（反射）
     *
     * 	Proxy是JDK中的API类
     * 	第一个参数：目标对象的类加载器
     * 	第二个参数：目标对象的接口
     * 	第二个参数：代理对象的执行处理器
     *
     * @return
     */
    public Object getProxy(){

        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("代理对象的方法:" + method.toString());
        System.out.println("这是jdk的代理方法");
        // 下面的代码，是反射中的API用法
        // 该行代码，实际调用的是[目标对象]的方法
        // 利用反射，调用[目标对象]的方法
        Object returnValue = method.invoke(target, args);
        return returnValue;
    }
}
