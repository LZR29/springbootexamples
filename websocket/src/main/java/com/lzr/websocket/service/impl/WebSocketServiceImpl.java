package com.lzr.websocket.service.impl;

import org.springframework.stereotype.Service;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author linzerong
 * @create 2019-06-03 12:26
 */
@ServerEndpoint("/ws")
@Service
public class WebSocketServiceImpl {

    /**
     * 记录当前在线数量，应该设置为线程安全
     */
    private static int onlineCount = 0;

    /**
     * 用来存放每个客户端对于的WebSocketServiceImpl对象
     */
    private static CopyOnWriteArraySet<WebSocketServiceImpl> webSocket = new CopyOnWriteArraySet<>();

    /**
     * 通过会话给客户端发送数据
     */
    private Session session;

    /**
     * 连接成功的方法
     * @param session
     */
    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
        webSocket.add(this);
        add();
        System.out.println("有新连接加入！当前在线人数为：" + onlineCount);
        try {
            sendMsg("有新成员到了！");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 连接关闭的方法
     */
    @OnClose
    public void onClose() {
        webSocket.remove(this);
        sub();
        System.out.println("有连接关闭，在线人数为：" + onlineCount);
    }

    /**
     * 给客户端发送消息
     * @param message
     * @param session
     */
    @OnMessage
    public void onMessage(String message, Session session) {
        System.out.println("收到客户端消息：" + message);
        for(WebSocketServiceImpl item : webSocket){
            try {
                item.sendMsg(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 发生错误时调用
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session, Throwable error) {
        System.out.println("发生错误！");
        error.printStackTrace();
    }

    /**
     * 发送消息
     * @param msg
     * @throws IOException
     */
    private void sendMsg(String msg) throws IOException {
        this.session.getBasicRemote().sendText(msg);
    }

    /**
     * 在线数量
     * @return
     */
    private static synchronized int getOnlineCount(){
        return onlineCount;
    }

    private static synchronized void add(){
        onlineCount++;
    }

    private static synchronized void sub(){
        onlineCount--;
    }
}
