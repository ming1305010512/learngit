package com.lm.service;

import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * Created by 龙鸣 on 2017/8/16.
 */
public class TestConstructorInject {

    private String name;

    //测试set属性注入
    private String description;

    //测试p名称空间注入
    private String category;

    //测试注入复杂属性
    //数组
    private String [] arrays;
    //list集合
    private List<String> list;
    //map集合
    private Map<String,String> map;
    //properties属性
    private Properties properties;

    public void setArrays(String[] arrays) {
        this.arrays = arrays;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TestConstructorInject(String name){

        this.name=name;
    }

    public void getName(){
        System.out.println("名字："+name);
    }

    public void getDescription(){
        System.out.println("描述信息："+description);
    }

    public void getCategory(){
        System.out.println("类别："+category);
    }

    //测试复杂属性
    public void getComplexProperty(){
        System.out.println(arrays);
        System.out.println(list);
        System.out.println(map);
        System.out.println(properties);
    }

    public TestConstructorInject(){}
}
