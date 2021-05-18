package com.chenhao.dao.entity;

import java.io.Serializable;

public class PrivateWord implements Serializable {
    private Integer id;

    private String privateword;

    private String publisherid;

    private String replierid;

    private String replycontent;

    private String publisherdate;

    private Integer isActive;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPrivateword() {
        return privateword;
    }

    public void setPrivateword(String privateword) {
        this.privateword = privateword == null ? null : privateword.trim();
    }

    public String getPublisherid() {
        return publisherid;
    }

    public void setPublisherid(String publisherid) {
        this.publisherid = publisherid == null ? null : publisherid.trim();
    }

    public String getReplierid() {
        return replierid;
    }

    public void setReplierid(String replierid) {
        this.replierid = replierid == null ? null : replierid.trim();
    }

    public String getReplycontent() {
        return replycontent;
    }

    public void setReplycontent(String replycontent) {
        this.replycontent = replycontent == null ? null : replycontent.trim();
    }

    public String getPublisherdate() {
        return publisherdate;
    }

    public void setPublisherdate(String publisherdate) {
        this.publisherdate = publisherdate == null ? null : publisherdate.trim();
    }

    public Integer getIsActive() {
        return isActive;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", privateword=").append(privateword);
        sb.append(", publisherid=").append(publisherid);
        sb.append(", replierid=").append(replierid);
        sb.append(", replycontent=").append(replycontent);
        sb.append(", publisherdate=").append(publisherdate);
        sb.append(", isActive=").append(isActive);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}