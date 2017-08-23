package com.lm.dao;

import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Created by 龙鸣 on 2017/8/17.
 */
public class UserDao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void update() {

        String sql="update user set userName=?,password=?,nickname=?,headPicture=? where id=?";
        int count =jdbcTemplate.update(sql,"hong","123456","hong","hong.png",16);
        System.out.println(count);
    }
}
