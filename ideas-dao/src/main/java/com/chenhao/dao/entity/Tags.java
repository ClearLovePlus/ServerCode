package com.chenhao.dao.entity;

import java.io.Serializable;

public class Tags implements Serializable {
    private Integer id;

    private String tagname;

    private Integer tagsize;

    private Integer isActive;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTagname() {
        return tagname;
    }

    public void setTagname(String tagname) {
        this.tagname = tagname == null ? null : tagname.trim();
    }

    public Integer getTagsize() {
        return tagsize;
    }

    public void setTagsize(Integer tagsize) {
        this.tagsize = tagsize;
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
        sb.append(", tagname=").append(tagname);
        sb.append(", tagsize=").append(tagsize);
        sb.append(", isActive=").append(isActive);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}