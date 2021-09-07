package com.chenhao.dto.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @description:修改密码请求实体
 * @author: chenhao
 * @date: 2021-6-9 13:42
 */
@ApiModel(value = "ChangePwdRequestDTO",description = "修改密码请求实体")
@Data
public class ChangePwdRequestDTO {
    @ApiModelProperty(value = "旧密码")
    private String oldPwd;
    @ApiModelProperty(value = "新密码")
    private String newPwd;
    @ApiModelProperty(value = "验证码")
    private String authCode;
    @ApiModelProperty(value = "手机号")
    private String phoneNum;
}
