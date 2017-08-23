package com.lm.testMapper;

import com.lm.daos.UserDao;
import com.lm.mapper.UserMapper;
import com.lm.pojo.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

/**
 * Created by 龙鸣 on 2017/8/18.
 */
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;
    ApplicationContext applicationContext;
    @Before
    public void setUp(){
        applicationContext=new ClassPathXmlApplicationContext("config/spring/applicationContext.xml");
    }

    @Test
    public void getUser(){
        UserMapper userMapper= (UserMapper) applicationContext.getBean("userMapper");
        User user=userMapper.queryUser(6);
        System.out.println(user);
    }
}
