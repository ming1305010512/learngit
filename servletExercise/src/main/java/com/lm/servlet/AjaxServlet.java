package com.lm.servlet;

import com.alibaba.fastjson.JSON;
import com.lm.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * Created by 龙鸣 on 2017/8/13.
 */
public class AjaxServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("进入到了ajaxServlet");
        //读json数据
        String name=req.getParameter("name");
        System.out.println("传过来的数据为name："+name);
        String birthday=req.getParameter("birthday");
        System.out.println("传过来的数据位birthday:"+birthday);

        User user =new User();
        user.setUserName("xiaohong");
        user.setPassword("123456");
        user.setNickname("ming");
        user.setBirthday(new Date());
        user.setHeadPicture("ming.png");
        //将user对象转化为json数据
        String json= JSON.toJSONString(user);

        //将json数据传到客户端
        resp.setContentType("application/json");
        PrintWriter pw=resp.getWriter();
        pw.print(json);
    }
}
