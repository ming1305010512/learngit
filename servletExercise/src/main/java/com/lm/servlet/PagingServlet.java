package com.lm.servlet;

import com.lm.Utils.PageBean;
import com.lm.dao.UserDao;
import com.lm.daoImpl.UserDaoImpl;
import com.lm.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 龙鸣 on 2017/8/13.
 */
public class PagingServlet extends HttpServlet {

    private UserDao userDao=new UserDaoImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //用户集合，用于保存当前页的用户记录
        List<User> userList=new ArrayList<User>();
        //获取当前页
        String currPage=req.getParameter("currentPage");
        if (currPage==null||currPage.equals("")){
            currPage="1";
        }
        int currentPage=Integer.parseInt(currPage);
        PageBean pageBean=new PageBean();
        pageBean.setCurrentPage(currentPage);

        //获取总记录数
        int totalCount=userDao.getTotalCount();
        System.out.println("走记录数为："+totalCount);
        pageBean.setTotalCount(totalCount);

        //计算检索位置
        int index=(currentPage-1)*pageBean.getPageCount();
        System.out.println("检索位置为："+index);
        //每页的记录数
        int pageCount=pageBean.getPageCount();
        System.out.println("每页记录数为："+pageCount);
        //计算总页数
        int totalPage=0;
        if (totalCount%pageCount==0){
            totalPage=totalCount/pageCount;
        }else{
            totalPage=totalCount/pageCount+1;
        }
        pageBean.setTotalPage(totalPage);

        userList=userDao.getCurrentPageUser(index,pageCount);
        System.out.println("查询的所有用户对象为：");
        for(User user:userList){
            System.out.println(user);
        }
        pageBean.setPageUser(userList);
        req.setAttribute("pageBean",pageBean);
        req.getRequestDispatcher("/WEB-INF/content/userInfoShow.jsp").forward(req,resp);

    }
}
