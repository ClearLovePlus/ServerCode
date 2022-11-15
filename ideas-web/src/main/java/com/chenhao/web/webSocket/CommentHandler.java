package com.chenhao.web.webSocket;

import com.chenhao.service.ICommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @description: webSocket长连接
 * @author: chenhao
 * @date: 2022-11-15 9:57
 */
@Slf4j
@Component
public class CommentHandler extends TextWebSocketHandler {
    /**
     * 点评服务
     */
    private final ICommentService commentService;

    /**
     * 构造参数用来初始化
     * @param commentService
     */
    public CommentHandler(@Autowired ICommentService commentService) {
        this.commentService = commentService;
    }

    /**
     * 用来存储客户端
     */
    private Map<String, WebSocketSession> clients = new ConcurrentHashMap<>();

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        log.info(session.getRemoteAddress() + " connected...");
        clients.put(session.getId(), session);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        log.info(session.getRemoteAddress() + " disconnected...");
        clients.remove(session.getId());
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
    }
}
