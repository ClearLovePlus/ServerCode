package com.chenhao.dao.entity;

import java.io.Serializable;

public class LeaveMessageLikesRecord implements Serializable {
    private Integer id;

    private String pagename;

    private Integer pid;

    private Integer likerid;

    private String likedate;

    private Integer isActive;

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

    public Integer getLikerid() {
        return likerid;
    }

    public void setLikerid(Integer likerid) {
        this.likerid = likerid;
    }

    public String getLikedate() {
        return likedate;
    }

    public void setLikedate(String likedate) {
        this.likedate = likedate == null ? null : likedate.trim();
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
        sb.append(", pagename=").append(pagename);
        sb.append(", pid=").append(pid);
        sb.append(", likerid=").append(likerid);
        sb.append(", likedate=").append(likedate);
        sb.append(", isActive=").append(isActive);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}