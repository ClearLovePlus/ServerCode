package com.chenhao.common.algorithm;

import com.sun.xml.internal.bind.v2.util.CollisionCheckStack;
import org.apache.commons.lang3.StringUtils;

import java.util.*;

/**
 * @description:
 * @author: chenhao
 * @date: 2021-11-1 11:12
 */
public class HaoMap {
    public static void test(){
        Map<String,String>  test=new HashMap<>();
        test.put("1","2");
        test.put("2","3");
        test.put("3","4");
        test.forEach((key,value)->{
            System.out.println(key+"==>"+value);
            if("1".equals(key)){
                System.out.println("nice man");
            }
        });
    }

    /**
     *codeWar:Dubstep
     * https://www.codewars.com/kata/551dc350bf4e526099000ae5
     * @param song
     * @return
     */
    public static String songDecoder(String song){
        song=song.replaceAll("(WUB)+"," ").trim();
//        if(song==null || song.length()==0){
//            return null;
//        }
//        String result="";
//        String replace= song.replace("WUB", " ");
//        String[] s = replace.split(" ");
//        for (int i=0;i<s.length;i++){
//            if(s[i]==null || s[i].length()==0){
//                continue;
//            }
//            result=result+s[i]+" ";
//        }
       return song;
    }

    /**
     * codeWar:Square Every Digit
     *https://www.codewars.com/kata/546e2562b03326a88e000020
     * @param n
     * @return
     */
    public static int squareDigit(Integer n){
        if(n<=0){
            return 0;
        }
        int[] ints=new int[20];
        int ruler=0;
        while (n/10!=0){
            ints[ruler]=n%10;
            n=n/10;
            ruler++;
        }
        ints[ruler++]=n%10;
        StringBuilder sb=new StringBuilder("");
        for (int i=ruler-1;i>=0;i--){
                Double pow = Math.pow(ints[i], 2);
                sb.append(pow.intValue());

        }
        return Integer.parseInt(sb.toString());
    }
    public static void main(String[] args) {
        System.out.println(HaoMap.songDecoder("AWUBBWUBC"));
        System.out.println(HaoMap.songDecoder("AWUBWUBWUBBWUBWUBWUBC"));
        System.out.println(HaoMap.songDecoder("WUBAWUBBWUBCWUB"));
        System.out.println(HaoMap.squareDigit(0));
    }
}
