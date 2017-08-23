package com.lm.service;

import com.lm.dao.UserDao;

/**
 * Created by 龙鸣 on 2017/8/16.
 */
public class UserService {

    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    //测试无参构造实例化bean
    public void add(){
        System.out.println("add..........");
    }
    //测试注入对象属性值
    public void getUserDao(){
        System.out.println("UserService..........");
        userDao.add();
    }
}
