package com.lm.testOriginalDao;

import com.lm.daos.UserDao;
import com.lm.pojo.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by 龙鸣 on 2017/8/18.
 */
public class UserDaoTest {

    ApplicationContext applicationContext;
    @Before
    public void setUp(){
        applicationContext=new ClassPathXmlApplicationContext("config/spring/applicationContext.xml");
    }

    @Test
    public void getUser(){
        UserDao userDao= (UserDao) applicationContext.getBean("userDao");
        User user=userDao.getUserById(6);
        System.out.println(user);
    }
}
