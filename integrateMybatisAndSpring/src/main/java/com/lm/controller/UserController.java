package com.lm.controller;

import com.lm.mapper.UserMapper;
import com.lm.pojo.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 龙鸣 on 2017/8/11.
 * 基于注解的处理器
 */
@Controller
public class UserController {

    @RequestMapping("/queryItems")
    public ModelAndView queryItems(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("config/spring/applicationContext.xml");
        UserMapper userMapper= (UserMapper) applicationContext.getBean("userMapper");
        User user=userMapper.queryUser(6);
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("user",user);
        modelAndView.setViewName("userShow");
        return modelAndView;
    }
}
