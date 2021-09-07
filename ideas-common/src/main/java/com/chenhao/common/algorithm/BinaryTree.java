package com.chenhao.common.algorithm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * @description:二叉树
 * @author: chenhao
 * @date: 2021-8-5 13:54
 */
public class BinaryTree<T> {
    /**
     * 根节点
     */
    private Node<T> head;

    /**
     * 定义叶子节点
     *
     * @param <T>
     */
    static class Node<T> {
        Node<T> left;
        Node<T> right;
        T data;

        public Node(Node<T> left, Node<T> right, T data) {
            this.left = left;
            this.right = right;
            this.data = data;
        }

        public Node(T data) {
            this.data = data;
        }
        public Node(){

        }

        public Node<T> getLeft() {
            return left;
        }

        public void setLeft(Node<T> left) {
            this.left = left;
        }

        public Node<T> getRight() {
            return right;
        }

        public void setRight(Node<T> right) {
            this.right = right;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }
    }

    /**
     * 创建二叉树
     *
     * @param dataList
     * @return
     */
    private Node<T> createBinaryTree(List<T> dataList, int index) {
        if (dataList.isEmpty()) {
            return null;
        }
        Node<T> root = null;
        if (index < dataList.size()) {
            root = new Node<>(dataList.get(index));
            root.left = createBinaryTree(dataList, 2 * index + 1);
            root.right = createBinaryTree(dataList, 2 * index + 2);
        }
        return root;
    }

    /**
     * 先根遍历
     *
     * @param node
     */
    public void preOrder(Node<T> node) {
        if (node != null) {
            System.out.print(node.data);
            preOrder(node.left);
            preOrder(node.right);
        }

    }

    public void midOrder(Node<T> node) {
        if (node != null) {
            midOrder(node.left);
            System.out.print(node.data);
            midOrder(node.right);
        }
    }

    public void afterOrder(Node<T> node) {
        if (node != null) {
            afterOrder(node.left);
            afterOrder(node.right);
            System.out.print(node.data);
        }
    }

    /**
     * 不用递归的先序遍历
     *
     * @param node
     */
    public void preOrderWithStack(Node<T> node) {
        Stack<Node<T>> stack = new Stack<>();
        if (node != null) {
            stack.push(node);
            while (!stack.isEmpty()) {
                Node<T> pop = stack.pop();
                System.out.print(pop.data);
                if (pop.right != null) {
                    stack.push(pop.right);
                }
                if (pop.left != null) {
                    stack.push(pop.left);
                }
            }
        }

    }

    /**
     * 不用递归方式的中序遍历
     *
     * @param node
     */
    public void midOrderWithStack(Node<T> node) {
        Stack<Node<T>> stack=new Stack<>();
        Node<T> temp=node;
        while (temp!=null||stack.size()>0){
            while (temp!=null){
                stack.push(temp);
                temp=temp.left;
            }
            if(stack.size()>0){
                Node<T> pop = stack.pop();
                System.out.print(pop.data);
                temp=pop.right;
            }
        }

    }

    /**
     * 返回二叉树的高度
     *
     * @param root
     * @return
     */
    public int heightOfTheTree(Node<T> root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = heightOfTheTree(root.left);
        int rightHeight = heightOfTheTree(root.right);
        //达到终结条件的时候左右树都是0，只是要层层累加
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {
        List<Integer> datas = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            datas.add(i);
        }
        BinaryTree<Integer> binaryTree = new BinaryTree<>();
        binaryTree.head = binaryTree.createBinaryTree(datas, 0);
        System.out.println("先序遍历");
        binaryTree.preOrder(binaryTree.head);
        System.out.println();
        System.out.println("中序遍历");
        binaryTree.midOrderWithStack(binaryTree.head);
        System.out.println();
        System.out.println("后序遍历");
        binaryTree.afterOrder(binaryTree.head);
        System.out.println();
        System.out.println("树的高度");
        System.out.println(binaryTree.heightOfTheTree(binaryTree.head));
    }
}
