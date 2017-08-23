package com.lm.service.impl;

import com.lm.mapper.ItemsCustomMapper;
import com.lm.mapper.ItemsMapper;
import com.lm.po.ItemCustom;
import com.lm.po.Items;
import com.lm.po.QueryItemsVo;
import com.lm.service.ItemsService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by 龙鸣 on 2017/8/19.
 * Description:
 *
 * @author:龙鸣
 * @version:1.0
 */
public class ItemsServiceImpl implements ItemsService {
    @Autowired
    private ItemsCustomMapper itemsCustomMapper;
    @Autowired
    private ItemsMapper itemsMapper;
    public List<ItemCustom> getItemsList(QueryItemsVo queryItemsVo) throws Exception {
        List<ItemCustom> list=itemsCustomMapper.getItemsList(queryItemsVo);
        return list;
    }

    //根据商品id查询商品
    public ItemCustom findItemsById(Integer id) throws Exception{
        Items items=itemsMapper.selectByPrimaryKey(id);

        ItemCustom itemCustom=new ItemCustom();
        //将items的属性值拷贝到itemCustom中
        BeanUtils.copyProperties(items,itemCustom);
        return itemCustom;
    }

    //更新商品
    public void updateItems(Integer id, ItemCustom itemCustom) {
        //一般会在这个地方添加校验
        //例如：当id为空，。。。。

        itemCustom.setId(id);
        itemsMapper.updateByPrimaryKey(itemCustom);
    }
}
