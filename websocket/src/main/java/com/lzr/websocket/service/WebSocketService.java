package com.lzr.websocket.service;

import javax.websocket.Session;

public interface WebSocketService {

    public void onOpen(Session session);
    public void onClose();
    public void onMessage(String message, Session session);
    public void onErroe(Session session, Throwable error);
}
