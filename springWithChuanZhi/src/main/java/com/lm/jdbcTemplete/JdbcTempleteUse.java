package com.lm.jdbcTemplete;

import com.lm.pojo.User;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by 龙鸣 on 2017/8/17.
 */
public class JdbcTempleteUse {

    //使用jdbcTemplete来实现数据库的CRUD操作
    //添加操作
    @Test
    public void add(){

        //设置数据库信息
        DriverManagerDataSource dataSource=new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/servletexercise?characterEncoding=utf-8");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");

        //创建JdbcTemplete对象
        JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
        //使用jdbcTemplete的方法来实现添加操作
        String sql="INSERT into user(userName,password,nickname,headPicture,birthday) VALUES(?,?,?,?,?)";
        int count =jdbcTemplate.update(sql,"xiaokkk","123456","kkk","kkk.png","2016-12-12");
        System.out.println(count);
    }

    //更新操作
    //添加操作
    @Test
    public void update(){

        //设置数据库信息
        DriverManagerDataSource dataSource=new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/servletexercise?characterEncoding=utf-8");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");

        //创建JdbcTemplete对象
        JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
        //使用jdbcTemplete的方法来实现添加操作
        String sql="update user set userName=?,password=?,nickname=?,headPicture=? where id=?";
        int count =jdbcTemplate.update(sql,"xiaozhang","123456","ming","ming.png",16);
        System.out.println(count);
    }

    //查询返回结果只有一条且列也是一条的记录
    @Test
    public void queryOneRecoredAndOnecolumn(){
        //设置数据库信息
        DriverManagerDataSource dataSource=new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/servletexercise?characterEncoding=utf-8");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");

        //创建JdbcTemplete对象
        JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);

        //使用jdbcTemplete的方法来实现添加操作
        String sql="select count(1) from user";
        //参数一表示sql语句
        //参数二表示返回值得类
        int count=jdbcTemplate.queryForObject(sql,Integer.class);
        System.out.println(count);
    }

    //查询返回一个对象
    @Test
    public void queryResultObject(){

        //设置数据库信息
        DriverManagerDataSource dataSource=new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/servletexercise?characterEncoding=utf-8");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");

        //创建JdbcTemplete对象
        JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
        //写出sql语句
        String sql="select userName,headPicture from user where userName=? and password=?";
        //使用JdbcTemplate的方法
        /**
         * 参数一：表示sql语句
         * 参数二：一个接口，需要自己实现
         * 参数三和四：sql中的占位符填充
         * */
        User user=jdbcTemplate.queryForObject(sql,new MyRowMapper(),"xiaoming","123456");
        System.out.println(user);
    }
}

class MyRowMapper implements RowMapper<User>{

    //参数一：结果集
    //参数二：表示第几条记录
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        //得到结果集中的数据
        String userName=resultSet.getString(1);
        String headPicture=resultSet.getString(2);

        //将数据封装到User对象中
        User user=new User();
        user.setUserName(userName);
        user.setHeadPicture(headPicture);
        //返回user对象
        return user;
    }
}


