package com.lm.service;

import com.lm.dao.OrderDao;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by 龙鸣 on 2017/8/18.
 */
@Transactional
public class OrderService {

    private OrderDao orderDao;

    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    public void accountMoney(){

        //减少xiaohong1000
        orderDao.lessMoney(1000,15);

        int count=10/0;
        //增加hong1000
        orderDao.moreMoney(1000,16);
    }

}
