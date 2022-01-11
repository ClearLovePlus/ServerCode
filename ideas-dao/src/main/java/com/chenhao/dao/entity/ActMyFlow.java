package com.chenhao.dao.entity;

import java.io.Serializable;
import java.util.Date;

public class ActMyFlow implements Serializable {
    private Integer id;

    private Integer userId;

    private String processId;

    private String currentInstanceId;

    private Integer bizId;

    private Integer flowCategory;

    private String flowTheme;

    private String description;

    private String tenantId;

    private String batchNo;

    private Integer flowStatus;

    private String remark;

    private Integer createby;

    private Integer updateby;

    private Date createdate;

    private Date updatedate;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getProcessId() {
        return processId;
    }

    public void setProcessId(String processId) {
        this.processId = processId == null ? null : processId.trim();
    }

    public String getCurrentInstanceId() {
        return currentInstanceId;
    }

    public void setCurrentInstanceId(String currentInstanceId) {
        this.currentInstanceId = currentInstanceId == null ? null : currentInstanceId.trim();
    }

    public Integer getBizId() {
        return bizId;
    }

    public void setBizId(Integer bizId) {
        this.bizId = bizId;
    }

    public Integer getFlowCategory() {
        return flowCategory;
    }

    public void setFlowCategory(Integer flowCategory) {
        this.flowCategory = flowCategory;
    }

    public String getFlowTheme() {
        return flowTheme;
    }

    public void setFlowTheme(String flowTheme) {
        this.flowTheme = flowTheme == null ? null : flowTheme.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId == null ? null : tenantId.trim();
    }

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo == null ? null : batchNo.trim();
    }

    public Integer getFlowStatus() {
        return flowStatus;
    }

    public void setFlowStatus(Integer flowStatus) {
        this.flowStatus = flowStatus;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getCreateby() {
        return createby;
    }

    public void setCreateby(Integer createby) {
        this.createby = createby;
    }

    public Integer getUpdateby() {
        return updateby;
    }

    public void setUpdateby(Integer updateby) {
        this.updateby = updateby;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Date getUpdatedate() {
        return updatedate;
    }

    public void setUpdatedate(Date updatedate) {
        this.updatedate = updatedate;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", processId=").append(processId);
        sb.append(", currentInstanceId=").append(currentInstanceId);
        sb.append(", bizId=").append(bizId);
        sb.append(", flowCategory=").append(flowCategory);
        sb.append(", flowTheme=").append(flowTheme);
        sb.append(", description=").append(description);
        sb.append(", tenantId=").append(tenantId);
        sb.append(", batchNo=").append(batchNo);
        sb.append(", flowStatus=").append(flowStatus);
        sb.append(", remark=").append(remark);
        sb.append(", createby=").append(createby);
        sb.append(", updateby=").append(updateby);
        sb.append(", createdate=").append(createdate);
        sb.append(", updatedate=").append(updatedate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}