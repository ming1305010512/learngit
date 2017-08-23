package com.lm.service;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * Created by 龙鸣 on 2017/8/17.
 */
public class MyBookWithBeforeEnhance {

    public void before(){
        System.out.println("before......前置增强");
    }

    public void after(){
        System.out.println("后置增强");
    }

    //环绕通知
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        //方法前执行
        System.out.println("方法前执行");

        proceedingJoinPoint.proceed();

        //方法后执行
        System.out.println("方法后执行");
    }
}
