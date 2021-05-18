package com.chenhao.dao.entity;

import java.io.Serializable;

public class LeaveMessageRecord implements Serializable {
    private Integer id;

    private String pagename;

    private Integer pid;

    private Integer answererid;

    private Integer respondentid;

    private String leavemessagedate;

    private Integer likes;

    private Boolean isread;

    private Integer isActive;

    private String leavemessagecontent;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPagename() {
        return pagename;
    }

    public void setPagename(String pagename) {
        this.pagename = pagename == null ? null : pagename.trim();
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
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

    public String getLeavemessagedate() {
        return leavemessagedate;
    }

    public void setLeavemessagedate(String leavemessagedate) {
        this.leavemessagedate = leavemessagedate == null ? null : leavemessagedate.trim();
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

    public String getLeavemessagecontent() {
        return leavemessagecontent;
    }

    public void setLeavemessagecontent(String leavemessagecontent) {
        this.leavemessagecontent = leavemessagecontent == null ? null : leavemessagecontent.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", pagename=").append(pagename);
        sb.append(", pid=").append(pid);
        sb.append(", answererid=").append(answererid);
        sb.append(", respondentid=").append(respondentid);
        sb.append(", leavemessagedate=").append(leavemessagedate);
        sb.append(", likes=").append(likes);
        sb.append(", isread=").append(isread);
        sb.append(", isActive=").append(isActive);
        sb.append(", leavemessagecontent=").append(leavemessagecontent);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}