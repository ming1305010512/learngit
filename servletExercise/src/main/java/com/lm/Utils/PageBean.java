package com.lm.Utils;

import com.lm.entity.User;

import java.util.List;

/**
 * Created by 龙鸣 on 2017/8/13.
 */
public class PageBean {
    private int currentPage=1;//当前页
    private  int pageCount=4;//每页显示的行数
    private int totalCount;//总记录数
    private  int totalPage;//总页数
    private List<User> pageUser;//每页显示的用户

    //返回总页数
    public int getTotalPage(){
        return totalPage;
    }
    public void setTotalPage(int totalPage){
        this.totalPage=totalPage;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public List<User> getPageUser() {
        return pageUser;
    }

    public void setPageUser(List<User> pageUser) {
        this.pageUser = pageUser;
    }
}
