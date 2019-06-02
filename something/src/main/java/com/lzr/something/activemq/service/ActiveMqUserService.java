package com.lzr.something.activemq.service;

import com.lzr.something.activemq.bean.User;

public interface ActiveMqUserService {
    /**
     * 发送消息
     * @param user
     */
    public void sendMsg(User user);

    /**
     * 接收信息
     * @param user
     */
    public void receiveMsg(User user);
}
