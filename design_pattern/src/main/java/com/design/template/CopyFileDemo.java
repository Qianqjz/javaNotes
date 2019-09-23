package com.design.template;

import java.io.*;

public class CopyFileDemo  extends GetTimeTempate{


    @Override
    public void code() {

        try {
            BufferedInputStream inputStream=new BufferedInputStream(new FileInputStream("D:\\osi.jpg.gif"));
            BufferedOutputStream outputStream=new BufferedOutputStream(new FileOutputStream("D:\\1111.gif"));
            //定义一个读文件的数组
            byte[] bytes=new byte[256];
            //标志位
            int len =0;

            //每次读满一个数组长度
            while((len=inputStream.read(bytes))!=-1){
                //就写入缓存
                outputStream.write(bytes,0,len);
                //刷新缓存
                outputStream.flush();
            }

            inputStream.close();
            outputStream.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
