package com.chenhao.dao.entity;

import java.io.Serializable;

/**
 * @description:
 * @author: chenhao
 * @date: 2022-11-15 15:09
 */
public class CommentDetail implements Serializable {
    private String userName;
    private String commentContent;
    private String articleTitle;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }
}
