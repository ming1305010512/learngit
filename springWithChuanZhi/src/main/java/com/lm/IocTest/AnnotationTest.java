package com.lm.IocTest;

import com.lm.AnnotationWay.AnnotationUserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by 龙鸣 on 2017/8/17.
 */
public class AnnotationTest {

    //测试使用注解创建的bean实例
    @Test
    public void instantiationBeanWithOne(){

        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("config/annotationUse.xml");
        AnnotationUserService annotationUserService= (AnnotationUserService) applicationContext.getBean("userService");
        annotationUserService.add();
    }

    //测试使用注解注入属性
    @Test
    public void userAnnotationInjectProperty(){

        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("config/annotationUse.xml");
        AnnotationUserService annotationUserService= (AnnotationUserService) applicationContext.getBean("userService");
        annotationUserService.getUserService();
    }
}
