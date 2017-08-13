package com.lm.daoImpl;

import com.lm.dao.UserDao;
import com.lm.db.ConnectionFactory;
import com.lm.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by 龙鸣 on 2017/8/11.
 */
public class UserDaoImpl implements UserDao{
    static Connection connection= null;
    static PreparedStatement preparedStatement=null;
    static ResultSet resultSet=null;
    //根据用户名和密码来查询数据库，如果查询到，返回true
    public boolean isUserExist(String userName,String password){
        boolean flag=false;
        connection=ConnectionFactory.getInstance().makeConnection();
        String sql="select id from user where username=? and password=?";
        try {
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,userName);
            preparedStatement.setString(2,password);
            int cid=-1;
            resultSet=preparedStatement.executeQuery();
            if (resultSet.next()){
                System.out.println(resultSet.getString(1));
                cid=resultSet.getInt(1);
                if (cid>0){
                    flag=true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close();
        }
        return flag;
    }

    //查询所有用户并返回
    public List<User> getAllUser(){
        String sql="select id,userName,password,nickname,headPicture,birthday from user";
        connection=ConnectionFactory.getInstance().makeConnection();
        List<User> userList=new ArrayList<User>();
        try {
            preparedStatement=connection.prepareStatement(sql);
            resultSet=preparedStatement.executeQuery();
            System.out.println("============================");
            while (resultSet.next()){
                User user=new User();
                user.setId(resultSet.getInt(1));
                user.setUserName(resultSet.getString(2));
                user.setPassword(resultSet.getString(3));
                user.setNickname(resultSet.getString(4));
                user.setHeadPicture(resultSet.getString(5));
                user.setBirthday(resultSet.getDate(6));
                System.out.println(user);
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close();
        }
        return userList;
    }

    public User getUser(int id) {
        connection=ConnectionFactory.getInstance().makeConnection();
        User user=new User();
        String sql="select id,userName,password,nickName,headPicture,birthday from user where id=?";
        try {
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            ResultSet resultSet=preparedStatement.executeQuery();
            if(resultSet.next()){
                user.setId(resultSet.getInt(1));
                user.setUserName(resultSet.getString(2));
                user.setPassword(resultSet.getString(3));
                user.setNickname(resultSet.getString(4));
                user.setHeadPicture(resultSet.getString(5));
                user.setBirthday(resultSet.getDate(6));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close();
        }
        return user;
    }

    //实现用户表的更新
    public void update(int id, String userName, String password, String nickname, String headPicture,Date birthday) {

        String sql="update user set userName=?,password=?,nickname=?,headPicture=?,birthday=? where id=?";
        java.sql.Date birthday_sql=new java.sql.Date(birthday.getTime());
        connection=ConnectionFactory.getInstance().makeConnection();
//        System.out.println("updateDao的userName:"+userName);
        try {
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,userName);
            preparedStatement.setString(2,password);
            preparedStatement.setString(3,nickname);
            preparedStatement.setString(4,headPicture);
            preparedStatement.setDate(5,birthday_sql);
            preparedStatement.setInt(6,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close();
        }
    }

    //
    public void delete(int id) {

        String sql="delete from user where id=?";
        connection=ConnectionFactory.getInstance().makeConnection();
        try {
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int insert(String userName, String password, String nickname, String headPicture, Date birthday) {

        java.sql.Date birthday_sql=new java.sql.Date(birthday.getTime());
        String sql="INSERT into user(userName,password,nickname,headPicture,birthday) VALUES(?,?,?,?,?)";
        connection=ConnectionFactory.getInstance().makeConnection();
        try {
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,userName);
            preparedStatement.setString(2,password);
            preparedStatement.setString(3,nickname);
            preparedStatement.setString(4,headPicture);
            preparedStatement.setDate(5,birthday_sql);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close();
        }
        return 0;
    }

    public int getUserId(String userName, String password) {
        String sql="select id from user where userName=? and password=?";
        connection=ConnectionFactory.getInstance().makeConnection();
        try {
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,userName);
            preparedStatement.setString(2,password);
            resultSet=preparedStatement.executeQuery();
            if (resultSet.next()){
                return resultSet.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close();
        }
        return 0;
    }

    public List<User> getCurrentPageUser(int index, int pageCount) {
        String sql="select id,userName,password,nickname,headPicture,birthday from user LIMIT ?,?";
        connection=ConnectionFactory.getInstance().makeConnection();
        //用来保存查询的记录数
        List<User> list=new ArrayList<User>();
        try {
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,index);
            preparedStatement.setInt(2,pageCount);
            resultSet=preparedStatement.executeQuery();
            list=getUserList(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close();
        }
        return list;
    }

    public int getTotalCount() {
        String sql ="select count(1) from user";
        connection=ConnectionFactory.getInstance().makeConnection();
        int totalCount=0;
        try {
            preparedStatement=connection.prepareStatement(sql);
            resultSet=preparedStatement.executeQuery();
            if (resultSet.next()){
                totalCount=resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("UserDao中的totalCount为："+totalCount);

        return totalCount;
    }


    //关闭数据库相关流
    public static void close(){
        try {
            if(resultSet!=null) {
                resultSet.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if(preparedStatement!=null) {
                preparedStatement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //根据结果集返回查询到的所有用户对象
    public static List<User> getUserList(ResultSet resultSet){
        List<User> list=new ArrayList<User>();
        try {
            while (resultSet.next()){
                User user=new User();
                user.setId(resultSet.getInt(1));
                user.setUserName(resultSet.getString(2));
                user.setPassword(resultSet.getString(3));
                user.setNickname(resultSet.getString(4));
                user.setHeadPicture(resultSet.getString(5));
                user.setBirthday(resultSet.getDate(6));
                list.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
