package com.chenhao.service.Listenner;

import org.springframework.context.ApplicationEvent;

/**
 * @description: 评论事件
 * @author: chenhao
 * @date: 2022-11-24 16:39
 */
public class CommentEvent extends ApplicationEvent {
    /**
     * 构造函数
     * @param source
     */
    public CommentEvent(Object source) {
        super(source);
    }
}
