package com.lzr.schedule.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**注册到容器里，配置注解@EnableScheduling来启动任务，异步线程池可以不要，会有默认任务池
 * @author linzerong
 * @create 2019-06-02 23:03
 */
@Service
public class ScheduleServiceImpl implements ScheduleService {
    /**
     * 计数器
     */
    int count1 = 1;
    int count2 = 1;
    int count3 = 1;
    int count4 = 1;

    /**
     * 任务1，每秒执行一次，异步执行
     */
    @Override
    @Scheduled(fixedRate = 1000)
    @Async
    public void job1(){
        System.out.println("【" + Thread.currentThread().getName() + "】--" + "【job1】每秒种执行1次" +
                "这是第【" + count1++ + "】次");
    }

    /**
     * 任务2，每秒执行一次，异步执行
     */
    @Override
    @Scheduled(fixedRate = 1000)
    @Async
    public void job2(){
        System.out.println("【" + Thread.currentThread().getName() + "】--" + "【job2】每秒种执行1次" +
                "这是第【" + count2++ + "】次");
    }

    /**
     * springIoc容器初始化后，第一次延迟3秒，每隔1秒执行
     */
    @Override
    @Scheduled(fixedRate = 1000, initialDelay = 3000)
    @Async
    public void job3() {
        System.out.println("【" + Thread.currentThread().getName() + "】--" + "【job3】每秒种执行1次" +
                "这是第【" + count3++ + "】次");
    }

    /**
     * 从11：00到11:59点，每分钟执行一次
     */
    @Override
    @Scheduled(cron = "0 * 11 * * ?")
    @Async
    public void job4() {
        System.out.println("【" + Thread.currentThread().getName() + "】--" + "【job4】每秒种执行1次" +
                "这是第【" + count4++ + "】次");
    }


}
