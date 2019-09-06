package com.spring.test;

import com.spring.aop.MathCalculator;
import com.spring.config.MainconfigOfAOP;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IocTest_Aop {

    AnnotationConfigApplicationContext applicationContext
            = new AnnotationConfigApplicationContext(MainconfigOfAOP.class);
    @Test
    public void test01() {
        //1，不要自己创建对象
//        MathCalculator mathCalculator = new MathCalculator();
//        mathCalculator.div(1,1);
        MathCalculator mathCalculator =
                applicationContext.getBean(MathCalculator.class);
        int div = mathCalculator.div(1, 1);
        System.out.println(div);

        applicationContext.close();

    }

}