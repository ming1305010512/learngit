package com.lm.po;

import java.util.List;
import java.util.Map;

/**
 * Created by 龙鸣 on 2017/8/19.
 * Description:
 *
 * @author:龙鸣
 * @version:1.0
 */
public class QueryItemsVo {
    //商品信息
    private Items items;
    //扩展商品
    private ItemCustom itemCustom;

    //批量商品信息
    private List<ItemCustom> itemsList;

    //批量商品信息，使用Map
    private Map<String,ItemCustom> itemsMap;

    public Items getItems() {
        return items;
    }

    public void setItems(Items items) {
        this.items = items;
    }

    public ItemCustom getItemCustom() {
        return itemCustom;
    }

    public void setItemCustom(ItemCustom itemCustom) {
        this.itemCustom = itemCustom;
    }

    public List<ItemCustom> getItemsList() {
        return itemsList;
    }

    public void setItemsList(List<ItemCustom> itemsList) {
        this.itemsList = itemsList;
    }

    public Map<String, ItemCustom> getItemsMap() {
        return itemsMap;
    }

    public void setItemsMap(Map<String, ItemCustom> itemsMap) {
        this.itemsMap = itemsMap;
    }
}
