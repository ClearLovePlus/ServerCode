package com.chenhao.dao.entity;

import java.io.Serializable;

public class Visitor implements Serializable {
    private Integer id;

    private Long visitornum;

    private Integer isActive;

    private String pagename;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getVisitornum() {
        return visitornum;
    }

    public void setVisitornum(Long visitornum) {
        this.visitornum = visitornum;
    }

    public Integer getIsActive() {
        return isActive;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

    public String getPagename() {
        return pagename;
    }

    public void setPagename(String pagename) {
        this.pagename = pagename == null ? null : pagename.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", visitornum=").append(visitornum);
        sb.append(", isActive=").append(isActive);
        sb.append(", pagename=").append(pagename);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}