package com.chenhao.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @description:基础返回实体
 * @author: chenhao
 * @date: 2021-1-5 16:40
 */
@ApiModel(value = "BaseResponse",description = "基础返回实体类")
public class BaseResponse<T>{
    @ApiModelProperty(value = "返回结果值")
    private Integer status;
    @ApiModelProperty(value = "返回结果信息")
    private String  message;
    private T data;
    public BaseResponse(){
        this.status=200;
        this.message="success";
    }
    public BaseResponse(Integer resultCode,String resultMsg){
        this.status=resultCode;
        this.message=resultMsg;
    }
    public BaseResponse(T result){
        this.status=200;
        this.message="success";
        this.data=result;
    }


    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
