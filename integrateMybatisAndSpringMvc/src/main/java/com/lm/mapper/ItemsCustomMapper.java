package com.lm.mapper;

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
public interface ItemsCustomMapper {

    //查询商品列表
    public List<ItemCustom> getItemsList(QueryItemsVo queryItemsVo);
}
