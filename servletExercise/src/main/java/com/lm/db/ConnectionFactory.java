package com.lm.db;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by 龙鸣 on 2017/8/10.
 */
public class ConnectionFactory {
    //创建静态字段
    private static String driver;
    private static  String user;
    private static  String password;
    private static String url;

    //创建jdbcFactory实例，采用单例模式
    private  static final ConnectionFactory factory=new ConnectionFactory();

    private ConnectionFactory(){

    }

    public static ConnectionFactory getInstance(){
        return factory;
    }

    //声明一个连接实例
    Connection connection=null;
    //创建一个连接实例
    public Connection makeConnection(){
        try {
            Class.forName(driver);
            connection= DriverManager.getConnection(url,user,password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    //创建静态代码块，该出用来获取Properties文件中的内容
    static {

        //创建Properties对象
        Properties properties=new Properties();
        //使用类加载器读取资源文件
        InputStream inputStream=ConnectionFactory.class.getClassLoader().getResourceAsStream("dbConfig.properties");
        try {
            //读取流中的内容
            properties.load(inputStream);
            driver=properties.getProperty("driver");
            user=properties.getProperty("user");
            password=properties.getProperty("password");
            url=properties.getProperty("url");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
