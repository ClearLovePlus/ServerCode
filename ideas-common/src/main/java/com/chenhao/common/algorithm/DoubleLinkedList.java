package com.chenhao.common.algorithm;

/**
 * @description:双向链表
 * @author: chenhao
 * @date: 2021-7-15 14:12
 */
public class DoubleLinkedList <T>{

    /**
     * 透节点
     */
    private  Node<T> head;
    /**
     * 尾节点
     */
    private  Node<T> tail;
    /**
     * 容量
     */
    private  int size;

    public DoubleLinkedList(){

    }

    /**
     * 通过头结点进行双向链表的初始化
     * @param head
     */
    public DoubleLinkedList(Node<T> head){
        this.head=head;
        if (head.next != null) {
            while (head.next != null) {
                head = head.next;
            }
        }
        this.tail=head;
    }

    /**
     * 往双向链表中添加数据
     * @param data
     */
    public void add(T data){
        if(this.head==null){
            Node<T> head =new Node<>(data,null,null);
            this.head=head;
            this.tail=head;
        }else {
            //尾插法新增数据
            Node<T> next=new Node<>(data,this.tail,null);
            this.tail.next=next;
            this.tail=this.tail.next;
        }
        size++;
    }
    /**
     * 双向链表的节点定义
     * @param <T>
     */
    private static class Node<T>{
         T data;
         Node<T> pre;
         Node<T> next;
         public Node(T data,Node<T> pre,Node<T> next){
             this.data=data;
             this.pre=pre;
             this.next=next;
         }
    }
}
