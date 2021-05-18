package com.chenhao.dao.entity;

import java.io.Serializable;

public class CommentRecord implements Serializable {
    private Long id;

    private Long pid;

    private Long articleid;

    private Integer answererid;

    private Integer respondentid;

    private String commentdate;

    private Integer likes;

    private Boolean isread;

    private Integer isActive;

    private String commentcontent;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public Long getArticleid() {
        return articleid;
    }

    public void setArticleid(Long articleid) {
        this.articleid = articleid;
    }

    public Integer getAnswererid() {
        return answererid;
    }

    public void setAnswererid(Integer answererid) {
        this.answererid = answererid;
    }

    public Integer getRespondentid() {
        return respondentid;
    }

    public void setRespondentid(Integer respondentid) {
        this.respondentid = respondentid;
    }

    public String getCommentdate() {
        return commentdate;
    }

    public void setCommentdate(String commentdate) {
        this.commentdate = commentdate == null ? null : commentdate.trim();
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public Boolean getIsread() {
        return isread;
    }

    public void setIsread(Boolean isread) {
        this.isread = isread;
    }

    public Integer getIsActive() {
        return isActive;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

    public String getCommentcontent() {
        return commentcontent;
    }

    public void setCommentcontent(String commentcontent) {
        this.commentcontent = commentcontent == null ? null : commentcontent.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", pid=").append(pid);
        sb.append(", articleid=").append(articleid);
        sb.append(", answererid=").append(answererid);
        sb.append(", respondentid=").append(respondentid);
        sb.append(", commentdate=").append(commentdate);
        sb.append(", likes=").append(likes);
        sb.append(", isread=").append(isread);
        sb.append(", isActive=").append(isActive);
        sb.append(", commentcontent=").append(commentcontent);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}