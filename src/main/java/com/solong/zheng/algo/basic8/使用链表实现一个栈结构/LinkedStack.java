package com.solong.zheng.algo.basic8.使用链表实现一个栈结构;

import lombok.ToString;

/**
 * @Author znsong
 * @Date 2019/11/11 16:50
 */
public class LinkedStack {

    private Node head = null;

    public static void main(String[] args) {
       /* Node node1 = new Node(1,null);
        Node node2 = new Node(2,null);
        Node node3 = new Node(3,null);
        node2.next = node1;
        node3.next = node2;*/

        LinkedStack stack = new LinkedStack();
        stack.pushStack(1);
        stack.pushStack(2);
        Node node = stack.pushStack(3);
        System.out.println(node.getData()+ " " +node.getNext().getData()+" " + node.getNext().getNext().getData());

        Node node1 = (Node) stack.popStack();
        System.out.println(node1.getData());
        Node node2 = (Node) stack.popStack();
        Node node3 = (Node) stack.popStack();
        System.out.println(node2.getData());
        System.out.println(node3.getData());

        stack.popStack();
    }

    public Node pushStack(int data) {
        Node node = new Node(data, null);
        if (head == null) {
            head = node;
            return head;
        }
        node.next = head;
        head = node;
        return head;
    }

    public Object popStack() {
        if (head == null) {
            return -1;
        }
        Node pre = head;
        head = head.next;
        pre.next = null;
        return pre;
    }

    @ToString
    public static class Node<T> {

        private T data;
        private Node next;

        public Node(T t, Node next) {
            this.next = next;
            this.data = t;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

}
