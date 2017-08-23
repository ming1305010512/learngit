package com.lm.IocTest;

import com.lm.service.TestConstructorInject;
import com.lm.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by 龙鸣 on 2017/8/16.
 */
public class InstantiationTest {

    //测试使用类的无参构造来创建bean实例
    @Test
    public void instantiationBeanWithOne(){

        //获取配置文件
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("config/applicationContext.xml");
        UserService userService= (UserService) applicationContext.getBean("user");
        userService.add();
    }

    //测试使用静态工厂来创建bean的实例
    @Test
    public void instatiationBeanWithTwo(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("config/applicationContext.xml");
        UserService userService= (UserService) applicationContext.getBean("userServiceTwo");
        userService.add();
    }

    //测试使用实例工厂创建bean的实例
    @Test
    public void instatiationBeanWithThree(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("config/applicationContext.xml");
        UserService userService= (UserService) applicationContext.getBean("userServiceThree");
        userService.add();
    }

    //测试属性注入
    @Test
    public void constructorInject(){

        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("config/applicationContext.xml");
        TestConstructorInject testConstructorInject= (TestConstructorInject) applicationContext.getBean("constructorInject");
        //有参构造注入
        testConstructorInject.getName();
        //set注入
        testConstructorInject.getDescription();
    }
    //测试对象属性注入
    @Test
    public void ObjectInject(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("config/applicationContext.xml");
        UserService userService= (UserService) applicationContext.getBean("injectObject");
        userService.getUserDao();
    }
    //测试p名称空间注入
    @Test
    public void pNameInject(){
        ApplicationContext applicationContext=new
                ClassPathXmlApplicationContext("config/applicationContext.xml");
        TestConstructorInject testConstructorInject= (TestConstructorInject) applicationContext.getBean("pNameInject");
        testConstructorInject.getCategory();
    }

    //测试复杂属性注入
    @Test
    public void getComplexPropertyInject(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("config/applicationContext.xml");
        TestConstructorInject testConstructorInject= (TestConstructorInject) applicationContext.getBean("complexPropertyInject");
        testConstructorInject.getComplexProperty();
    }
}
