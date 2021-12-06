package com.chenhao.api.request;

import java.io.Serializable;

/**
 * 加法请求参数
 */
public class AddRequest implements Serializable {
    private static final long serialVersionUID=2L;
    private  int var1;
    private  int var2;

    public int getVar1() {
        return var1;
    }

    public void setVar1(int var1) {
        this.var1 = var1;
    }

    public int getVar2() {
        return var2;
    }

    public void setVar2(int var2) {
        this.var2 = var2;
    }

    @Override
    public String toString() {
        return "AddRequest{" +
                "var1=" + var1 +
                ", var2=" + var2 +
                '}';
    }
}
