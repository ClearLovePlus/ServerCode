package com.chenhao.common.algorithm;

import javax.xml.transform.Source;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @description:
 * @author: chenhao
 * @date: 2021-7-20 15:40
 */
public class HaoQueue<Q> {
    /**
     * 存储容器
     */
    protected Object[] elementData;
    /**
     * 队尾
     */
    int tail;
    /**
     * 队头
     */
    int head;
    /**
     * 队列的容量
     */
    public int size;

    public HaoQueue(){
        this.elementData=new Object[Integer.MAX_VALUE-8];
    }

    public HaoQueue(int size){
        this.size=size;
        this.elementData=new Object[size];
    }

    /**
     * 入队列操作
     * @param element
     * @return
     */
    public int add(Q element){
        //超过了队列的最大容量
        if(tail+1>size){
            return 0;
        }
        elementData[tail]=element;
        tail++;
        return tail;
    }

    /**
     * 出队列操作
     * @return
     */
    public Q offer(){
        //表示队列是空的
        if(tail==head){
            //
            elementData=null;
            return null;
        }
        Q q=(Q)elementData[head];
        elementData[head]=null;
        head++;
        return q;
    }

    /**
     * 返回元素值
     * @return
     */
    public Q getHeadData(){
        return (Q)elementData[head];
    }

    /**
     * 返回尾元素
     * @return
     */
    public Q getTailData(){
        return (Q)elementData[tail-1];
    }

    @Override
    public String toString() {
        return "HaoQueue{" +
                "elementData=" + Arrays.toString(elementData) +
                ", tail=" + (tail-1)+
                ", head=" + head +
                ", size=" + size +
                '}';
    }

    /**
     * 返回第一个子串的开始位置
     * @param fatherString
     * @param childString
     * @return
     */
    public int getSameStringFromAnotherString(String fatherString,String childString) {
        if (childString.length() > fatherString.length()) {
            return 0;
        }
        int i=0;
        while (i<fatherString.length()){
            int k=0;
            for(int p=0;p<childString.length();p++){
                if(fatherString.charAt(i+p)==childString.charAt(p)){
                    k++;
                }
            }
            if(k==childString.length()){
                return i;
            }
            i++;
        }
        return i;
    }

    public static void main(String[] args) {
        HaoQueue<Integer> haoQueue=new HaoQueue<>(10);
//        int i=0;
//        while (i<10){
//            haoQueue.add(i);
//            i++;
//        }
//        Integer offer = haoQueue.offer();
//        System.out.println(offer);
//        System.out.println(haoQueue.getHeadData());
//        System.out.println(haoQueue.toString());
//        LinkedBlockingQueue queue=new LinkedBlockingQueue(10);
        String s="ss";
        String s1="daeessa";
        int result = haoQueue.getSameStringFromAnotherString(s1, s);
        System.out.println(result);

    }
}
