package com.lm.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 龙鸣 on 2017/8/11.
 */
//给servlet用于页面的跳转
public class TranspondServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

       String parameter=req.getParameter("parameter");
        System.out.println("TranspondServlet参数parameter值为："+parameter);
        //跳转到注册页面
        if("register".equals(parameter)){
            req.getRequestDispatcher("/WEB-INF/content/register.jsp").forward(req,resp);
        }
        if("login".equals(parameter)){
            req.getRequestDispatcher("/WEB-INF/content/login.jsp").forward(req,resp);
        }
    }
}
