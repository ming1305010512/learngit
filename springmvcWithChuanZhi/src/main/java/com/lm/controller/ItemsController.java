package com.lm.controller;

import com.lm.domain.Items;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 龙鸣 on 2017/8/10.
 */
public class ItemsController implements Controller {
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        List<Items> list=new ArrayList<Items>();

        Items items1=new Items();
        items1.setName("联想");
        items1.setPrice("2000");
        items1.setDetail("非常便利");

        Items items2=new Items();
        items2.setName("Del");
        items2.setPrice("4000");
        items2.setDetail("非常快速");

        Items items3=new Items();
        items3.setName("惠普");
        items3.setPrice("5000");
        items3.setDetail("重量非常轻");

        list.add(items1);
        list.add(items2);
        list.add(items3);
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("itemsList",list);
        modelAndView.setViewName("/WEB-INF/items/itemsDetail.jsp");
        return modelAndView;
    }
}
