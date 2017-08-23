package com.lm.exception;

/**
 * Created by 龙鸣 on 2017/8/21.
 * Description:系统自定义异常类，针对预期的异常
 *
 * @author:龙鸣
 * @version:1.0
 */
public class CustomException extends Exception{

    //异常信息
    private String message;

    public CustomException(String message){
        this.message=message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
