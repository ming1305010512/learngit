package com.lm.daos;

import com.lm.pojo.User;

/**
 * Created by 龙鸣 on 2017/8/18.
 */
public interface UserDao {

    //根据id查询用户
    public User getUserById(int id);
}
