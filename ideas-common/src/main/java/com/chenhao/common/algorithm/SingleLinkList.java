package com.chenhao.common.algorithm;

/**
 * @description:
 * @author: chenhao
 * @date: 2021-7-14 15:10
 */
public class SingleLinkList<T> {
    /**
     * 首节点
     */
    private Node<T> first;
    /**
     * 尾节点
     */
    private Node<T> last;
    /**
     * 链表容量
     */
    private int size;
    /**
     * 节点数据
     * 内部静态类实现
     * @param <T>
     */
    private static class Node<T>{
        Node<T> next;
        T data;
        public Node(Node<T> next,T data){
            this.next=next;
            this.data=data;
        }
    }

    public SingleLinkList(){
    }
    public SingleLinkList(Node<T> node){
        this.first=node;
        if (node.next != null) {
            while (node.next != null) {
                node = node.next;
            }
        }
        this.last=node;
    }
    public SingleLinkList(T data,int size){
        this.size=size;
        Node<T> node=new Node<>(null,data);
        this.first=node;
        this.last=first;
    }

    public void add(T data){
        if(first==null){
            Node<T> node=new Node<>(null,data);
            first=node;
            last=first;
        }else {
            if(last.next==null){
                Node<T> newNode=new Node<>(null,data);
                last.next=newNode;
                last=last.next;
            }
        }
    }

    /**
     * 获取头结点
     * @return
     */
    public Node<T> getFirst(){
      final Node<T> f=first;
      if(f==null){
          return null;
      }
      return f;
    }

    /**
     * 获取头结点的数据
     * @return
     */
    public T getFirstData(){
        final Node<T> f=first;
        if(f==null){
            return null;
        }
        return f.data;
    }
    /**
     * 获取尾结点
     * @return
     */
    public Node<T> getLast(){
        final Node<T> f=last;
        if(f==null){
            return null;
        }
        return f;
    }

    /**
     * 获取头结点的数据
     * @return
     */
    public T getLastData(){
        final Node<T> f=last;
        if(f==null){
            return null;
        }
        return f.data;
    }

    public void setFirst(Node<T> node){
        this.first=node;
    }
    public void setLast(Node<T> node){
        this.last=node;
    }
    /**
     * 合并两个顺序链表
     * @param var1
     * @param var2
     * @return
     */
    public SingleLinkList<Integer> mergeSingleLinkList(SingleLinkList<Integer> var1,SingleLinkList<Integer> var2,Boolean distinct){

        if (var1.getFirst()==null&&var2.getFirst()==null){
            return null;
        }
        if(var1.getFirst()==null){
            return var2;
        }
        if(var2.getFirst()==null){
            return var1;
        }
        Node<Integer> q=var2.getFirst();
        SingleLinkList<Integer> list=new SingleLinkList<Integer>(var1.getFirst());
        Node<Integer> p=list.getFirst();
        while (p!=null&&q!=null){
            //是否去重
           if(p.data<q.data){
              p=p.next;
           }else {
               if(distinct){
                   if(p.data.equals(q.data)){
                       q=q.next;
                       continue;
                   }
               }
               Node<Integer> tmp=q;
               q=q.next;
               tmp.next=p.next;
               p.next=tmp;
               p=tmp.next;
           }
        }
        //没插入完的
        if(q!=null){
            list.getLast().next=q;
            Node<Integer> tmp=list.getLast();
            while (tmp.next!=null){
                tmp=tmp.next;
            }
            list.setLast(tmp);
        }
        return list;
    }
    public static void main(String[] args) {
        SingleLinkList<Integer> list=new SingleLinkList<>();
        for(int i=0;i<5;i++){
            list.add(i);
        }
        SingleLinkList<Integer> list2=new SingleLinkList<>();
        for (int i=0;i<8;i++){
            list2.add(i);
        }
        SingleLinkList<Integer> list3= list.mergeSingleLinkList(list, list2,true);
    }

}
