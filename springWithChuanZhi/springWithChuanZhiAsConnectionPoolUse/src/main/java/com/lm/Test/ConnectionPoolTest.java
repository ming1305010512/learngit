package com.lm.Test;

import com.lm.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by 龙鸣 on 2017/8/17.
 */
public class ConnectionPoolTest {

    @Test
    public void updateTest(){
        ApplicationContext applicationContext=
                new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService= (UserService) applicationContext.getBean("userService");
//        userService.update();
        userService.getUser();
    }
}
