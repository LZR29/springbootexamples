package com.lzr.springmvc_deep.config;

import com.lzr.springmvc_deep.interceptor.MulitiInterceptor1;
import com.lzr.springmvc_deep.interceptor.MulitiInterceptor2;
import com.lzr.springmvc_deep.interceptor.MulitiInterceptor3;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**拦截器配置类，实现WebMvcConfigurer的addInterceptors方法
 * @author linzerong
 * @create 2019-06-01 13:20
 */
@Configuration
public class MulitiInterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册拦截器到spring mvc机制，然后他会返回一个拦截器注册
        InterceptorRegistration ir1 = registry.addInterceptor(new MulitiInterceptor1());
        //使用拦截器注册指定匹配模式，限制请求
        ir1.addPathPatterns("/interceptor/*");
        //注册拦截器到spring mvc机制，然后他会返回一个拦截器注册
        InterceptorRegistration ir2 = registry.addInterceptor(new MulitiInterceptor2());
        //使用拦截器注册指定匹配模式，限制请求
        ir2.addPathPatterns("/interceptor/*");
        //注册拦截器到spring mvc机制，然后他会返回一个拦截器注册
        InterceptorRegistration ir3 = registry.addInterceptor(new MulitiInterceptor3());
        //使用拦截器注册指定匹配模式，限制请求
        ir3.addPathPatterns("/interceptor/*");
    }
}
