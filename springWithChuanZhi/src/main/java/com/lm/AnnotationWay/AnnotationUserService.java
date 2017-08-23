package com.lm.AnnotationWay;

import com.lm.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by 龙鸣 on 2017/8/17.
 */
//相当于在配置文件中配置<bean id="userService" class="com.lm.AnnotationWay.UserService"/>
@Component(value = "userService")
@Scope(value = "prototype")//将bean实例设置为多实例
public class AnnotationUserService {

    //测试注解注入属性的方法，使用注解不需要给属性设置set值
    //(1)使用autoWired注解
    //该注解会自动根据UserDao找到这个类，然后再找到该类的对象，注入到该属性中
    @Autowired
    private UserDao userDao;

    //(2)使用Resource注解
    //该注解就相当于
    /**
     *  <bean id="userService" class="com.lm.AnnotationWay.AnnotationUserService">
     *      <property name="userDao2" ref="userDao"></property>
     *  </bean>
     *      */
    @Resource(name = "userDao3")
    private UserDao userDao2;

    //测试使用注解创建bean实例
    public void add(){
        System.out.println("add......");
    }


    //测试属性注入
    public void getUserService(){
        System.out.println("UserService........");
//        userDao.add();
        userDao2.add();
    }
}
