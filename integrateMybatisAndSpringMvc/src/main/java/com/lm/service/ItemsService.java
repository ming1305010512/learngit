package com.lm.service;


import com.lm.po.ItemCustom;
import com.lm.po.QueryItemsVo;

import java.util.List;

/**
 * Created by 龙鸣 on 2017/8/19.
 * Description:
 *
 * @author:龙鸣
 * @version:1.0
 */
public interface ItemsService {

    //查询商品列表
    public List<ItemCustom> getItemsList(QueryItemsVo queryItemsVo) throws Exception;

    //根据id查询商品
    public ItemCustom findItemsById(Integer id)throws Exception;
    //更新商品的id
    public void updateItems(Integer id,ItemCustom itemCustom);
}
