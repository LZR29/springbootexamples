package com.lzr.something.threadpool.service.impl;

import com.lzr.something.threadpool.service.AsyncService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Date;

/**异步服务接口实现类
 * @author linzerong
 * @create 2019-06-01 22:35
 */
@Service
public class AsyncServiceImpl implements AsyncService {
    /**
     *注解@Async用来声明使用异步调用
     */
    @Override
    @Async
    public void generator() {
        try {
            //为了更明显地看出异步效果
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("报表线程名称:【" + Thread.currentThread().getName() + "】--" + new Date());
    }
}
