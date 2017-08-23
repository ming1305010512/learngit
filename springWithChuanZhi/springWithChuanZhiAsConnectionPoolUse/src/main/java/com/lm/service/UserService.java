package com.lm.service;

import com.lm.dao.UserDao;
import com.lm.dao.UserDao2;

/**
 * Created by 龙鸣 on 2017/8/17.
 */
public class UserService {

    private UserDao userDao;

    private UserDao2 userDao2;

    public void setUserDao2(UserDao2 userDao2) {
        this.userDao2 = userDao2;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void update(){

        userDao.update();
    }

    public void getUser(){

        userDao2.getUser();
    }
}
