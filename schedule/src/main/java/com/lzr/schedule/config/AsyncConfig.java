package com.lzr.schedule.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**配置定义线程池和启用异步
 * @EnableAsync -- 代表开启spring异步，但需要提供线程池
 * 接口AsyncConfigurer覆盖方法进行自定义线程池
 * 提供定时任务的线程池
 * @author linzerong
 * @create 2019-06-01 22:26
 */
@Configuration
@EnableAsync
@EnableScheduling
public class AsyncConfig implements AsyncConfigurer {
    /**
     * 自定义线程池
     * @return
     */
    @Override
    public Executor getAsyncExecutor() {
        //定义线程池
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        //设置核心数量
        taskExecutor.setCorePoolSize(10);
        //设置最大线程数
        taskExecutor.setMaxPoolSize(30);
        //线程队列最大线程数
        taskExecutor.setQueueCapacity(200);
        //初始化
        taskExecutor.initialize();
        return taskExecutor;
    }
}
