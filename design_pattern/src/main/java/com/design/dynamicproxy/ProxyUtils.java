package com.design.dynamicproxy;

import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;

public class ProxyUtils {

    public static void generatorClass(Object proxy){
        FileOutputStream out=null;
        try{
            byte[] generatorProxyClass= ProxyGenerator.generateProxyClass(proxy.getClass().getSimpleName(),
                    new Class[]{proxy.getClass()});
            out=new FileOutputStream(generatorProxyClass.getClass().getSimpleName()+".class");
            out.write(generatorProxyClass);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(out!=null){
                try {
                    out.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
}
