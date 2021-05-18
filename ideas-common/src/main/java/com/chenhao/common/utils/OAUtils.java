package com.chenhao.common.utils;

import sun.misc.BASE64Encoder;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * OAUtils.java
 * Created on 2020-10-12
 * Copyright 2020 Tebon Financial. All  Rights Reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 * <p>
 * Please contact Fosun Corporation or visit
 * www.tebon.com.cn
 * if you need additional information or have any questions.
 *
 * @author hify
 * @version 1.0
 */
public class OAUtils {

    public static String encrypt(String json) throws NoSuchAlgorithmException {
        StringBuilder sb = new StringBuilder();
        String enJson = (new BASE64Encoder()).encode(json.getBytes(StandardCharsets.UTF_8));
        enJson = enJson.replaceAll("[\\s*\t\n\r]", "");
        byte[] signByteArray = MessageDigest.getInstance("MD5").digest(enJson.getBytes(StandardCharsets.UTF_8));
        byte[] var4 = signByteArray;
        int var5 = signByteArray.length;

        for(int var6 = 0; var6 < var5; ++var6) {
            byte b = var4[var6];
            String str = Integer.toHexString(b & 255);
            if (str.length() == 1) {
                sb.append("0");
            }

            sb.append(str);
        }

        return sb.toString().toUpperCase();
    }
}
