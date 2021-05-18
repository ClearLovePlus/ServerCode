package com.chenhao.dao.entity;

import java.io.Serializable;
import java.util.Date;

public class Reward implements Serializable {
    private Integer id;

    private String fundraiser;

    private String fundraisingsources;

    private String fundraisingplace;

    private Float rewardmoney;

    private String remarks;

    private Date rewarddate;

    private String rewardurl;

    private Integer isActive;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFundraiser() {
        return fundraiser;
    }

    public void setFundraiser(String fundraiser) {
        this.fundraiser = fundraiser == null ? null : fundraiser.trim();
    }

    public String getFundraisingsources() {
        return fundraisingsources;
    }

    public void setFundraisingsources(String fundraisingsources) {
        this.fundraisingsources = fundraisingsources == null ? null : fundraisingsources.trim();
    }

    public String getFundraisingplace() {
        return fundraisingplace;
    }

    public void setFundraisingplace(String fundraisingplace) {
        this.fundraisingplace = fundraisingplace == null ? null : fundraisingplace.trim();
    }

    public Float getRewardmoney() {
        return rewardmoney;
    }

    public void setRewardmoney(Float rewardmoney) {
        this.rewardmoney = rewardmoney;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public Date getRewarddate() {
        return rewarddate;
    }

    public void setRewarddate(Date rewarddate) {
        this.rewarddate = rewarddate;
    }

    public String getRewardurl() {
        return rewardurl;
    }

    public void setRewardurl(String rewardurl) {
        this.rewardurl = rewardurl == null ? null : rewardurl.trim();
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
        sb.append(", fundraiser=").append(fundraiser);
        sb.append(", fundraisingsources=").append(fundraisingsources);
        sb.append(", fundraisingplace=").append(fundraisingplace);
        sb.append(", rewardmoney=").append(rewardmoney);
        sb.append(", remarks=").append(remarks);
        sb.append(", rewarddate=").append(rewarddate);
        sb.append(", rewardurl=").append(rewardurl);
        sb.append(", isActive=").append(isActive);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}