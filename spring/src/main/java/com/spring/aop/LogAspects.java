package com.spring.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

/**
 * 切面类
 */
//告诉spring是一个切面类
@Aspect
public class LogAspects {

    /**
     * 抽取公共的切入点表达式
     *  1，本类引用 @Before("pointCut()")
     *  2，其他引用 写入类的全名@ After("com.spring.aop.LogAspects.pointCut()")
     */

    @Pointcut("execution(public int com.spring.aop.MathCalculator.*(..))")
    public void pointCut(){

    }

    //@before 在目标方法之前切入，切入点表达式（指定咋那个方法切入）
    @Before("pointCut()")
    public void logStart(JoinPoint joinPoint){
        //获取方法参数表
        Object[] args = joinPoint.getArgs();
        //获取签名名joinPoint.getSignature()
        System.out.println("-->"+joinPoint.getSignature().getName()+"除法运行。@logStart。。参数列表是：{"+ Arrays.asList(args)+"}");
    }

    @After("com.spring.aop.LogAspects.pointCut()")
    public void logEnd(JoinPoint joinPoint){
        System.out.println(joinPoint.getSignature().getName()+"除法结束...@logEnd....");
    }

    /**
     * JoinPoint joinPoint,一定放在第一位，不然会报错。
     * @param result
     */

    @AfterReturning(value = "pointCut()",returning = "result")
    public void logReturn(JoinPoint joinPoint,Object result){
        System.out.println("除法正常返回。@logReturn。。运行结果是：{"+result+"}");
    }
    @AfterThrowing(value = "pointCut()",throwing = "exception")
    public void logException(Exception exception){
        System.out.println("除法异常。@logException。。异常信息：{"+exception+"}");
    }
}
