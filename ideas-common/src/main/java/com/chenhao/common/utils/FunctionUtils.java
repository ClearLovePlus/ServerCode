package com.chenhao.common.utils;

/**
 * @description:
 * @author: chenhao
 * @date: 2021-9-2 15:16
 */
public class FunctionUtils {
    /**
     * 获取index名字
     * @param s
     * @return
     */
    public static String getIndex(String s) {
        return "blog";
    }

    /**
     * 获取DocId
     * @param indexName
     * @return
     */
    public static String getDocId(String indexName){
        return "AXRfpHsBhubEUyMaCPZw";
    }
    public static String [] getTwoDocId(String indexName){
        String [] docIds=new String[2];
        docIds[0]="AXRfpHsBhubEUyMaCPZw";
        docIds[1]="AnRgpHsBhubEUyMaGfYB";
        return docIds;
    }

}
