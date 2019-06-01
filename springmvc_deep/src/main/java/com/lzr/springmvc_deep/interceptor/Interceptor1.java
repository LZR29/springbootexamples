package com.lzr.springmvc_deep.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**拦截器需要实现HandlerInterceptor接口，接口有默认实现，自己重写逻辑
 * 另外需要注册到springmvc，需要再配置文件中实现WebMvcConfigurer接口
 * @author linzerong
 * @create 2019-06-01 13:13
 */
public class Interceptor1 implements HandlerInterceptor {
    /**
     * 如果返回false的话，被拦截的请求就无法进入控制器
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
     //   return false;
        System.out.println("执行了preHandle方法！-- 处理器前方法");
        return true;
    }

    /**
     * 在控制器执行完方法后执行
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("执行了postHandle方法！-- 处理器后方法");
    }

    /**
     * 这个方法是在控制器完成视图渲染后执行
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("执行了afterCompletion方法！-- 处理器完成方法");
    }
}
