package com.lzr.something.rabbitmq.service;

import com.lzr.something.rabbitmq.bean.User;

public interface RabbitmqService {

    public void sendMsg(String msg);
    public void sendUser(User user);
}
