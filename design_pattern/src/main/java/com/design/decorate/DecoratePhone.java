package com.design.decorate;

/**
 *  装饰模式（decorate）：只是在原有的bean外面添加了新的功能。
 * 	接口：Phone
 * 	目标类：IPhone
 * 	装饰类：IPhoneDecorate，需要持有一个目标类的引用
 * 	测试类
 *
 * 装饰模式在spring中的具体体现都是通过xxxWrapper类去体现的。
 *
 */
public class DecoratePhone implements Phone  {

    private Phone phone;

    public DecoratePhone(Phone phone) {
        this.phone = phone;
    }

    //对已有的类的功能性增强
    @Override
    public void call() {
        phone.call();
        System.out.println("听音乐");
    }
}
