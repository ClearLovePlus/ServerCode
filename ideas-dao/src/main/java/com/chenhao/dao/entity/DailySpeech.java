package com.chenhao.dao.entity;

import java.io.Serializable;
import java.util.Date;

public class DailySpeech implements Serializable {
    private Integer id;

    private String mood;

    private Date publishdate;

    private Integer isActive;

    private String content;

    private String picsurl;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMood() {
        return mood;
    }

    public void setMood(String mood) {
        this.mood = mood == null ? null : mood.trim();
    }

    public Date getPublishdate() {
        return publishdate;
    }

    public void setPublishdate(Date publishdate) {
        this.publishdate = publishdate;
    }

    public Integer getIsActive() {
        return isActive;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getPicsurl() {
        return picsurl;
    }

    public void setPicsurl(String picsurl) {
        this.picsurl = picsurl == null ? null : picsurl.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", mood=").append(mood);
        sb.append(", publishdate=").append(publishdate);
        sb.append(", isActive=").append(isActive);
        sb.append(", content=").append(content);
        sb.append(", picsurl=").append(picsurl);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}