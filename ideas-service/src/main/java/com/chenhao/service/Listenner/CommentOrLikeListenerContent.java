package com.chenhao.service.Listenner;

import lombok.Builder;

/**
 * @description:
 * @author: chenhao
 * @date: 2022-11-30 14:21
 */
public class CommentOrLikeListenerContent {
    private Integer userId;
    private Integer type;
    private Object extendInfo;

    /**
     * builder 进行构造
     *
     * @param builder
     */
    public CommentOrLikeListenerContent(Builder builder) {
        this.userId = builder.userId;
        this.extendInfo = builder.extendInfo;
        this.type = builder.type;
    }

    public static class Builder {
        private Integer userId;
        private Integer type;
        private Object extendInfo;

        public Builder userId(Integer userId) {
            this.userId = userId;
            return this;
        }

        public Builder type(Integer type) {
            this.type = type;
            return this;
        }

        public Builder extendInfo(Object extendInfo) {
            this.extendInfo = extendInfo;
            return this;
        }

        public CommentOrLikeListenerContent build() {
            return new CommentOrLikeListenerContent(this);
        }

    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Object getExtendInfo() {
        return extendInfo;
    }

    public void setExtendInfo(Object extendInfo) {
        this.extendInfo = extendInfo;
    }
}
