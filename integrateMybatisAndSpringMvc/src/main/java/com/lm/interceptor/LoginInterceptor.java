package com.lm.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by 龙鸣 on 2017/8/23.
 * Description:
 *
 * @author:龙鸣
 * @version:1.0
 */
public class LoginInterceptor implements HandlerInterceptor {

    //在进入处理器方法之前执行
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {

        String uri=httpServletRequest.getRequestURI();
        //如果是登陆请求,放行
        if(uri.indexOf("login")>=0){
            return true;
        }

        HttpSession session=httpServletRequest.getSession();

        if(session.getAttribute("name")!=null){
            return true;
        }

        //执行到这里表示用户需要登陆
        httpServletRequest.getRequestDispatcher("/WEB-INF/login.jsp")
                .forward(httpServletRequest,httpServletResponse);
        return false;
    }

    //在进入处理器方法之后，返回ModelAndView之前执行
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    //在处理器方法完成后执行
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
