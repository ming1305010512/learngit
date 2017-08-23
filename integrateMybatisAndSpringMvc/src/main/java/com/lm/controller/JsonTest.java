package com.lm.controller;

import com.lm.po.ItemCustom;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by 龙鸣 on 2017/8/21.
 * Description:json交互测试
 *
 * @author:龙鸣
 * @version:1.0
 */
@Controller
public class JsonTest {

    @RequestMapping(value = "/requestJson",method = RequestMethod.POST)
    //@RequestBody将商品信息的json串转为itemCustom对象
    //@ResponseBody将itemCustom对象转成json串输出
    public @ResponseBody ItemCustom requestJson(@RequestBody ItemCustom itemCustom){

        System.out.println(itemCustom.getItemDetail());
        return itemCustom;
    }

    //请求key/value，输出json
    @RequestMapping(value = "/responseJson",method = RequestMethod.POST)
    //@ResponseBody将itemCustom对象转成json串输出
    public @ResponseBody ItemCustom responseJson(ItemCustom itemCustom){

        System.out.println(itemCustom.getItemName());
        return itemCustom;
    }
}
