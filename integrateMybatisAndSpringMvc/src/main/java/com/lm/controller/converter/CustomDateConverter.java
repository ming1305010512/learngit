package com.lm.controller.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 龙鸣 on 2017/8/20.
 * Description:
 *
 * @author:龙鸣
 * @version:1.0
 */
public class CustomDateConverter implements Converter<String,Date> {
    public Date convert(String s) {

        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date date=format.parse(s);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
