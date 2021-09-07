package com.chenhao.common.algorithm;

import java.util.Arrays;
import java.util.Stack;

/**
 * @description:
 * @author: chenhao
 * @date: 2021-7-15 15:39
 */
public class HaoStack<T> {
    /**
     * 数据存储的容器
     */
    protected Object[] stack;
    /**
     * stack最大容量
     */
    int maxSize;
    /**
     * 元素下标
     */
    int itemCount = 0;

    public HaoStack() {
        this.stack = new Object[]{};
    }

    /**
     * 带最大容量的stack
     *
     * @param maxSize
     */
    public HaoStack(int maxSize) {
        this.maxSize = maxSize;
        this.stack = new Object[maxSize];
    }

    /**
     * 入栈
     *
     * @param t
     */
    public void push(T t) {
        if (maxSize == 0) {
            maxSize = Integer.MAX_VALUE;
        }
        if (itemCount > maxSize) {
            return;
        }
        stack[itemCount++] = t;
    }

    /**
     * 出栈
     *
     * @return
     */
    public T pop() {
        if (stack == null || stack.length == 0) {
            return null;
        }
        itemCount--;
        T t = (T) stack[itemCount];
        //此处有内存泄露
        Object[] copy = new Object[itemCount];
        for (int i = 0; i < itemCount; i++) {
            copy[i] = stack[i];
        }
        stack = copy;
        return t;
    }

    public T getTop() {
        if (stack == null || stack.length == 0) {
            return null;
        }
        return (T) stack[stack.length - 1];
    }

    public Boolean isEmpty() {
        return stack == null || stack.length == 0;
    }

    @Override
    public String toString() {
        return "HaoStack{" +
                "stack=" + Arrays.toString(stack) +
                ", maxSize=" + maxSize +
                ", itemCount=" + itemCount +
                '}';
    }

    /**
     * 进制转换
     *
     * @param var
     */
    public String covertDiv(int var, int div, HaoStack<Integer> stack) {
        while (var > 0) {
            stack.push(var % div);
            var = var / div;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
                sb.append(stack.pop());

        }
        return sb.toString();
    }

    /**
     * 判断带括号的多项式的括号是否合法
     * @param var
     * @return
     */
    public boolean isIllegalString(String var){
        HaoStack<Character> stack=new HaoStack<Character>(100);
        for(int i=0;i<var.length();i++){
            if(var.charAt(i)=='['||var.charAt(i)=='{'||var.charAt(i)=='('){
                stack.push(var.charAt(i));
            }else {
                if(stack.isEmpty()){
                    return false;
                }
                if(var.charAt(i)==']'&&stack.pop()!='['){
                    return false;
                }
                if(var.charAt(i)=='}'&&stack.pop()!='{'){
                    return false;
                }
                if(var.charAt(i)==')'&&stack.pop()!='('){
                    return false;
                }
            }
        }
        return true;
    }


    public static void main(String[] args) {
        HaoStack<Integer> stack = new HaoStack<>(10);
        System.out.println(stack.isIllegalString("([[]])"));
//        for (int i=0;i<10;i++){
//            stack.push(String.valueOf(i));
//        }
//        System.out.println(stack.toString());
//        while (!stack.isEmpty()){
//            System.out.print(stack.pop()+",");
//        }
        System.out.println(stack.covertDiv(10, 8, stack));
    }
}
