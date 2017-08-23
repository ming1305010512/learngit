package com.lm.dao;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by 龙鸣 on 2017/8/18.
 */
public class UserDao2 {

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    Connection connection=null;
    PreparedStatement preparedStatement=null;
    ResultSet resultSet=null;

    public void getUser(){
        String sql="select * from user where id=?";
        try {
            connection=dataSource.getConnection();
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,16);
            resultSet=preparedStatement.executeQuery();
            if(resultSet.next()){
                System.out.println("名字为："+resultSet.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
