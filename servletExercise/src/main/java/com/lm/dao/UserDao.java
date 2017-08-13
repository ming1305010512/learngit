package com.lm.dao;

import com.lm.db.ConnectionFactory;
import com.lm.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 * Created by 龙鸣 on 2017/8/11.
 */
public interface UserDao {

    //判断用户是否存在
   public boolean isUserExist(String userName,String password);
   //查询所有用户对象并保存在集合中
   public List<User> getAllUser();

   //根据id来获取用户
    public  User getUser(int id);
    //更新用户
    public void update(int id,String userName,String password,String nickname,String headPicture,Date birthday);
    //删除用户
    public void delete(int id);
    //增加用户,返回用户id
    public int  insert(String userName, String password, String nickname, String headPicture, Date birthday);
    //根据用户名和密码查询用户id
    public int getUserId(String userName,String password);
    //根据起始行index和页记录数pageCount查询当前页要显示的用户记录
    public List<User> getCurrentPageUser(int index,int pageCount);
    //查询总记录数
    public int getTotalCount();
}
