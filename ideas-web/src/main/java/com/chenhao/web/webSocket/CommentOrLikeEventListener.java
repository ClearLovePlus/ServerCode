package com.chenhao.web.webSocket;

import com.alibaba.fastjson.JSON;
import com.chenhao.dto.response.CommentWebSocketResponseDTO;
import com.chenhao.service.ICommentService;
import com.chenhao.service.Listenner.CommentEvent;
import com.chenhao.service.Listenner.CommentOrLikeListenerContent;
import com.chenhao.service.impl.CommentServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @description: 评论事件监听器
 * @author: chenhao
 * @date: 2022-11-24 16:49
 */
@Component
@Slf4j
public class CommentOrLikeEventListener implements ApplicationListener<CommentEvent> {
    @Autowired
    private WebSocketServer webSocketServer;
    @Autowired
    private ICommentService commentService;

    @Override
    public void onApplicationEvent(CommentEvent event) {
        if (event.getSource()==null) {
            log.warn("评论监听器监听到非法的参数");
        }
        if(!(event.getSource() instanceof CommentOrLikeListenerContent)){
            log.warn("不支持的事件类型");
        }
        CommentOrLikeListenerContent content= (CommentOrLikeListenerContent) event.getSource();
        String result = "";
        try {
            CommentWebSocketResponseDTO responseDTO = commentService.commentUnReadInfoForWebSocket(content.getType(), content.getUserId());
            if (responseDTO != null) {
                result = JSON.toJSONString(responseDTO);
            }
            WebSocketServer toServer = webSocketServer.getWebServerByUserId(content.getUserId().toString());
            toServer.pushToClient(result);
        } catch (Exception e) {
            log.error("获取未读评论数据发生异常", e);
        }
    }
}
