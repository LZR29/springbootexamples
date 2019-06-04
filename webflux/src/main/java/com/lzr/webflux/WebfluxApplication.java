package com.lzr.webflux;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

/**
 * 因为引入jpa所以默认情况下要配置数据源，所以要排除原有的自动配置
 * 在webflux下，驱动MongoDB的jpa接口
 */
@SpringBootApplication(scanBasePackages = "com.lzr.webflux")
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
@EnableReactiveMongoRepositories(basePackages = "com.lzr.webflux.repository")
public class WebfluxApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebfluxApplication.class, args);
    }

}
