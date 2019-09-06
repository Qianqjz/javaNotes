package com.spring.pojo;


import org.springframework.beans.factory.annotation.Value;

public class Person {


    /**
     * 使用Value赋值
     * 1，基本数值
     * 2，SpEL,#{}
     * 3,可以写${},取出配置文件中的值。
     *      ${}perperties,
     */
    @Value("zhangsan")
    private String name;
    @Value("#{20-2}")
    private int age;

    @Value("${person.nickName}")
    private String nickName;

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
