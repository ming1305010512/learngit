package com.lm.daos.Impl;

import com.lm.daos.UserDao;
import com.lm.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

/**
 * Created by 龙鸣 on 2017/8/18.
 */
public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao {

    public User getUserById(int id) {
        SqlSession sqlSession=this.getSqlSession();
        //参数一：指定哪一个操作标签
        //参数二：传入的参数值
        User user=sqlSession.selectOne("test.queryUser",id);
        return user;
    }
}
