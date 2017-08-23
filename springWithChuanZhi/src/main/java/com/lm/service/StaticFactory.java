package com.lm.service;

/**
 * Created by 龙鸣 on 2017/8/16.
 */
public class StaticFactory {

    public static UserService getUserService(){
        return new UserService();
    }
}
