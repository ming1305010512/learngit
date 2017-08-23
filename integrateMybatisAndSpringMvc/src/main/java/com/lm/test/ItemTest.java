package com.lm.test;

import com.lm.mapper.ItemsCustomMapper;
import com.lm.po.ItemCustom;
import com.lm.po.QueryItemsVo;
import com.lm.service.ItemsService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by 龙鸣 on 2017/8/19.
 * Description:
 *
 * @author:龙鸣
 * @version:1.0
 */
public class ItemTest {

    ApplicationContext applicationContext;

    @Before
    public void setUp(){
        applicationContext=new ClassPathXmlApplicationContext("config/spring/applicationContext.xml");
    }

    @Test
    public void getItem(){
//        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("config/spring/applicationContext.xml");
        //获得代理对象
        ItemsCustomMapper itemsMapper= (ItemsCustomMapper) applicationContext.getBean("itemsCustomMapper");
        QueryItemsVo queryItemsVo=new QueryItemsVo();
        ItemCustom itemCustom=new ItemCustom();
        itemCustom.setItemName("vivo");
        queryItemsVo.setItemCustom(itemCustom);
        List<ItemCustom> list=itemsMapper.getItemsList(queryItemsVo);
        for(ItemCustom itemCustom2:list) {
            System.out.println(itemCustom2.getItemName());
        }
    }

    //测试service
    @Test
    public void getItemWithService(){

        ItemsService service= (ItemsService) applicationContext.getBean("itemsService");
        List<ItemCustom> list= null;
        QueryItemsVo queryItemsVo=new QueryItemsVo();
        ItemCustom itemCustom=new ItemCustom();
        itemCustom.setItemName("vivo");
        queryItemsVo.setItemCustom(itemCustom);
        try {
            list = service.getItemsList(queryItemsVo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        for(ItemCustom itemCustom2:list) {
            System.out.println(itemCustom2.getItemName());
        }
//        ItemCustom itemCustom3=service.findItemsById(1);
//        System.out.println(itemCustom3.getItemName());
    }
}
