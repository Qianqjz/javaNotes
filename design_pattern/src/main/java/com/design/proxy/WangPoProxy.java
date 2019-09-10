package com.design.proxy;

/**
 *
 * 由王婆给潘金莲做代理给西门庆传话，西门庆直接访问王婆就可以了
 * 王婆在中间可以加上一些要求，
 * 这也是房屋中介赚钱的方法，
 */

public class WangPoProxy extends PanJinLian {

    private PanJinLian panJinLian=new PanJinLian();

    public void Speak(){

        System.out.println("西门庆，给我钱");
        panJinLian.speak();
        System.out.println("西门庆，我给你们看门");

    }

}
