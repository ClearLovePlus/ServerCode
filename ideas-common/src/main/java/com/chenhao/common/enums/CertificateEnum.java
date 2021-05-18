package com.chenhao.common.enums;

/**
 * @description:
 * @author: chenhao
 * @date: 2021-1-21 17:38
 */
public enum CertificateEnum {
    ID_CARD("身份证",1),
    HONGKONG_AND_MACAO_PASSPORT("港澳通行证",2),
    PERMAENT_RESIDENCE_CARD("外国永居证",3),
    PASSPORT("护照",4),
    TAIWAN_CARD("台胞证",5),
    HOMETOWN_CARD("回乡证",6),
    ANOTHER("其它",7)
    ;
    private String certificateMsg;
    private Integer certificateCode;

    CertificateEnum(String certificateMsg, int certificateCode) {
        this.certificateCode=certificateCode;
        this.certificateMsg=certificateMsg;
    }

    public String getCertificateMsg() {
        return certificateMsg;
    }

    public void setCertificateMsg(String certificateMsg) {
        this.certificateMsg = certificateMsg;
    }

    public Integer getCertificateCode() {
        return certificateCode;
    }

    public void setCertificateCode(Integer certificateCode) {
        this.certificateCode = certificateCode;
    }

    public static int getCodeByKey(String key){
        for (CertificateEnum p:values()){
            if(p.getCertificateMsg().equals(key))
                return p.getCertificateCode();
        }
        return 0;
    }

    public static String getMsgByCode(int code){
        for (CertificateEnum p:values()){
            if(p.getCertificateCode()==code)
            {
                return p.getCertificateMsg();
            }
        }
        return "";
    }
}
