package com.chenhao.web.webSocket;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @description:
 * @author: chenhao
 * @date: 2022-11-18 9:55
 */
@Component
@Slf4j
@ServerEndpoint(value = "/api/websocket/{userId}/{type}")
public class WebSocketServer {
    /**
     * 连接上的客户端的数量
     * 需要线程安全的计数方式
     */
    private volatile static AtomicInteger count = new AtomicInteger(0);
    /**
     * 用来存放所有的客户端连接
     */
    private static CopyOnWriteArraySet<WebSocketServer> clients = new CopyOnWriteArraySet<>();
    private Session session;
    private String userId;
    /**
     * 记录活跃时间
     */
    private Long activeTimestamp;

    @OnOpen
    public void onOpen(Session session, @PathParam("userId")String userId, @PathParam("type")String type) {
        this.session = session;
        clients.add(this);
        this.userId = userId;
        int allClients = count.addAndGet(1);
        try {
            log.info("用户:{}连接成功，当前连接人数：{}", userId, allClients);
            pushToClient("connect success");
            activeTimestamp = System.currentTimeMillis();
        } catch (Exception e) {
            log.error("用户{}连接异常", userId, e);
        }
    }

    @OnClose
    public void onClose() {
        clients.remove(this);
        int updateClients = count.decrementAndGet();
        log.info("用户:{}断开连接,当前连接数{}", userId, updateClients);
    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        log.error("webSocket 发生错误", throwable);
    }

    @OnMessage
    public void onMessage(String message, Session session) {
        log.info("用户:{}发来消息:{}", userId, message);
        activeTimestamp = System.currentTimeMillis();
        try {
            this.pushToClient("恭喜来到我的博客");
        }catch (Exception e){
            log.error("发送账户异常");
        }

    }

    /**
     * 推送到当前的连接的客户端
     *
     * @param message
     * @throws IOException
     */
    public void pushToClient(String message) throws IOException {
        this.session.getBasicRemote().sendText(message);
    }

    /**
     * 获取特定的webServer
     * @param userId
     * @return
     */
    public WebSocketServer getWebServerByUserId(String userId) {
        Optional<WebSocketServer> first = WebSocketServer.clients.stream().filter(p -> p.getUserId().equals(userId)).findFirst();
        return first.orElse(null);
    }
    public String getUserId(){
        return this.userId;
    }
    public static int getOnlineCount() {
        return count.get();
    }

}
