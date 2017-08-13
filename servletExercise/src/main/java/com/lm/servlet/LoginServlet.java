package com.lm.servlet;

import com.lm.dao.UserDao;
import com.lm.daoImpl.UserDaoImpl;
import com.lm.db.ConnectionFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;

/**
 * Created by 龙鸣 on 2017/8/11.
 */
public class LoginServlet  extends HttpServlet{

    private UserDao userDao=new UserDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            String userName=request.getParameter("userName");
            String password=request.getParameter("password");

            HttpSession session=request.getSession();

            boolean flag=userDao.isUserExist(userName,password);
            if (flag){
                System.out.println("登陆成功!");
                session.setAttribute("userName",userName);
                session.setAttribute("password",password);
                int id=userDao.getUserId(userName,password);
                session.setAttribute("userId",id);
                request.getRequestDispatcher("userServlet?type=all").forward(request,response);
            }else {
                System.out.println("登陆失败！");
                request.setAttribute("message","用户名或密码错误");
                request.getRequestDispatcher("/WEB-INF/content/login.jsp").forward(request,response);
            }

    }
}
