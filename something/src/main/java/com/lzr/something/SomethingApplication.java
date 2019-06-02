package com.lzr.something;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
public class SomethingApplication {

    public static void main(String[] args) {
        SpringApplication.run(SomethingApplication.class, args);
    }

}
