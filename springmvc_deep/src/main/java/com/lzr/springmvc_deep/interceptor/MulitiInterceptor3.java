package com.lzr.springmvc_deep.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**多个拦截器，测试拦截器的顺序
 * @author linzerong
 * @create 2019-06-01 13:45
 */
public class MulitiInterceptor3 implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("【" + this.getClass().getSimpleName() + "】 处理器前的方法");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("【" + this.getClass().getSimpleName() + "】 处理器后的方法");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("【" + this.getClass().getSimpleName() + "】 处理器完成的方法");
    }
}
