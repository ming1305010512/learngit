package com.lm.test;

import com.lm.service.OrderService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by 龙鸣 on 2017/8/18.
 */
public class TxTest {

    @Test
    public void countTx(){
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        OrderService orderService= (OrderService) context.getBean("orderService");
        orderService.accountMoney();
    }
    //测试使用注解进行事务操作
    @Test
    public void countTxUseAnnotation(){
        ApplicationContext context=new ClassPathXmlApplicationContext("UseAnnotation.xml");
        OrderService orderService= (OrderService) context.getBean("orderService");
        orderService.accountMoney();
    }
}
