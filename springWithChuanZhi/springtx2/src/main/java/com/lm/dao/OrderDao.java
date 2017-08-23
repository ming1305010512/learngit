package com.lm.dao;

import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Created by 龙鸣 on 2017/8/18.
 */
public class OrderDao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    //减少1000
    public void lessMoney(int num,int id){
        String sql ="update user set salary=salary-? where id=?";
        jdbcTemplate.update(sql,num,id);
    }
    //增加1000
    public void moreMoney(int num,int id){
        String sql="update user set salary=salary+? where id=?";
        jdbcTemplate.update(sql,num,id);
    }
}
