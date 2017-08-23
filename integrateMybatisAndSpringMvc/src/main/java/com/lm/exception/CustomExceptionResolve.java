package com.lm.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by 龙鸣 on 2017/8/21.
 * Description:全局异常处理器
 *
 * @author:龙鸣
 * @version:1.0
 */
public class CustomExceptionResolve implements HandlerExceptionResolver{

    //最后一个参数：表示从controller、service、dao中抛过来的异常
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                         Object o, Exception exception) {

        //声明自定义异常处理类
        CustomException customException=null;
        //如果异常是自己定义的异常
        if(exception instanceof CustomException){

            customException=(CustomException)exception;
        }
        //如果不是系统自定义的异常
        else{
            customException=new CustomException("未知错误!");
        }
        //错误信息
        String message=customException.getMessage();

        ModelAndView modelAndView=new ModelAndView();

        //将错误信息保存到ModelAndView中
        modelAndView.addObject("message",message);

        modelAndView.setViewName("error");


        return modelAndView;
    }
}
