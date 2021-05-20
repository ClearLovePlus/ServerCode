package com.chenhao.dto.request;

import lombok.Data;

/**
 * @description:注册请求实体，内部用build模式进行参数实现
 * @author: chenhao
 * @date: 2021-5-18 15:04
 */
@Data
public class RegisterRequestDTO {
    private String authCode;
    private String phoneNum;
    private String userName;
    private String password;

    private RegisterRequestDTO(RegisterRequestDTOBuilder builder){
        this.password=builder.password;
        this.authCode=builder.authCode;
        this.userName=builder.userName;
        this.phoneNum=builder.phoneNum;
    }

    /**
     * 内部类 用于实现build模式
     */
    public static class  RegisterRequestDTOBuilder{
        private String authCode;
        private String phoneNum;
        private String userName;
        private String password;

        public  RegisterRequestDTOBuilder(String userName,String password){
            this.userName=userName;
            this.password=password;
        }

        public RegisterRequestDTOBuilder phoneNum(String phoneNum){
            this.phoneNum=phoneNum;
            return this;
        }
        public RegisterRequestDTOBuilder authCode(String authCode){
            this.authCode=authCode;
            return this;
        }
        public  RegisterRequestDTO build(){
            return new RegisterRequestDTO(this);
        }
    }



}


