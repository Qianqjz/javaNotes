package com.design.singleton;

import org.junit.Test;

/**
 *
 * 1.构造私有。
 * 2.以静态方法或者枚举返回实例。
 * 3.确保实例只有一个，尤其是多线程环境。
 * 4.确保反序列换时不会重新构建对象。
 *
 *
 */
public class TestSingleton {

    @Test
    public void testSingleton01(){
        Singleton01 singleton01=Singleton01.getInstance();
        Singleton01 singleton02=Singleton01.getInstance();
        System.out.println(singleton01);
        System.out.println(singleton02);

        System.out.println(singleton01==singleton02);

    }

    @Test
    public void testSingleton02(){
        Singleton02 s01=Singleton02.getInstance();
        Singleton02 s02=Singleton02.getInstance();
        System.out.println(s01);
        System.out.println(s02);

        System.out.println(s01==s02);

    }
    @Test
    public void testSingleton03(){
        Singleton03 s01=Singleton03.getInstance();
        Singleton03 s02=Singleton03.getInstance();
        System.out.println(s01);
        System.out.println(s02);

        System.out.println(s01==s02);

    }
    @Test
    public void testSingleton04(){
        Singleton04 s01=Singleton04.SINGLETON_04;
        Singleton04 s02=Singleton04.SINGLETON_04;
        System.out.println(s01);
        System.out.println(s02);

        System.out.println(s01==s02);

    }

    @Test
    public void test05(){
        Singleton05 s=Singleton05.getInstance();
        Singleton05 s1=Singleton05.getInstance();
        System.out.println(s);
        System.out.println(s1);
        System.out.println(s==s1);
    }

}
