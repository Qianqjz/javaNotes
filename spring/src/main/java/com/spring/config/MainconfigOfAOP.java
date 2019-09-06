package com.spring.config;

import com.spring.aop.LogAspects;
import com.spring.aop.MathCalculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * AOP:动态代理
 *     指在程序运行期间动态的将某段代码切入到指定方法指定位置进行运行的编程方式
 *  1,导入aop模块，spring AOP(spring-aspects)
 *  2, 定义一个业务逻辑类MathCalculator：在业务逻辑运行的时候讲日志进行打印（方法之前，方法结束，出现异常）
 *  3,定义一个日志切面类LogAspects:切面类里面的方法需要动态的感知MathCalculator.div运行到的位置
 *         通知方法：
 *              前置通知(@Before)：logStart:在目标方法（div）运行之前运行
 *              后置通知(@After)：logEnd:在目标方法（div）运行之后运行 ,无论方法正常，异常结束都会运行
 *              返回通知(@AfterReturning)：logReturn:正常返回之后运行
 *              异常通知(@AfterThrowing)：logException 在方法异常以后运行
 *              环绕通知(@Around)：动态代理：手动推进目标方法进行（joinPoint.procced())
 *
 *  4, 给切面类的目标方法标注何时何地运行（通知注解）
 *  5，将切面类和业务逻辑类(目标方法所在类)都加入到容器中
 *  6，必须告诉spring那个类是切面类，那个是业务逻辑类
 *  7，给配置类中加@EnableAspectJAutoProxy：开启注解的aop模式
 *      在spring中有很多@Enablexxx:开启某项功能；
 *
 *  三步，
 *      1，将业务逻辑组件都加入spring 中，告诉spring那个是切面类
 *      2，在切面类上的每一个通知方法上标注通知注解，告诉spring何时何地运行（切入点）
 *      3，开启aop模式@EnableAspectJAutoProxy，这一点很重要，
 *
 */

@EnableAspectJAutoProxy
@Configuration
public class MainconfigOfAOP {

    //业务逻辑类加入容器中
    @Bean
    public MathCalculator mathCalculator(){
        return new MathCalculator();
    }

    //切面类加入容器中
    @Bean
    public LogAspects logAspects(){
        return new LogAspects();
    }

}
