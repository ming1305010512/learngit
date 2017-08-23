package com.lm.service;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * Created by 龙鸣 on 2017/8/18.
 */
@Aspect
public class MyBookUseAnnotation {

    @Before(value = "execution(* com.lm.service.Book.add(..))")
    public void before(){

        System.out.println("前置增强。。。");
    }
}
