package com.lm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * Created by 龙鸣 on 2017/8/23.
 * Description:
 *
 * @author:龙鸣
 * @version:1.0
 */
@Controller
public class LoginController {

    //登陆
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(HttpSession session, String name, String password){

        //调用service验证用户身份。。。
        System.out.println("login:......");

        //在session中保存用户身份
        session.setAttribute("name",name);
        //重定向到商品列表
        return "redirect:items/queryItems";
    }

    //退出
    @RequestMapping(value = "/logout")
    public String logout(HttpSession session){

        session.invalidate();

        //重定向到商品列表
        return "redirect:items/queryItems";
    }
}
