package com.lm.test;

import com.lm.service.Book;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by 龙鸣 on 2017/8/17.
 */
public class AopTest {
    //测试前置通知
    @Test
    public void beforeEnhance(){
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        Book book= (Book) context.getBean("book");
        book.add();
    }

    //测试注解的使用
    @Test
    public void annotationUse(){
        ApplicationContext context=new ClassPathXmlApplicationContext("useAnnotation.xml");
        Book book= (Book) context.getBean("book");
        book.add();
    }

}
