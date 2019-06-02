package com.lzr.something.activemq.service;

public interface ActiveMqService {
    /**
     * 发送消息
     * @param msg
     */
    public void sendMsg(String msg);

    /**
     * 接收信息
     * @param msg
     */
    public void receiveMsg(String msg);
}
