package com.solong.zheng.algo.basic6.使用单链表实现LRU;

/**
 * @Author znsong
 * @Date 2019/11/9 16:07
 */
public class SNodeLRU<T> {

    private static final int DETAULT_CAPACITY = 10;

    private int capacity;

    private int length;

    private SNode<T> head;

    public SNodeLRU(int capacity) {
        this.capacity = capacity;
        this.length = 0;
        head = new SNode();
    }

    public SNodeLRU() {
        this.capacity = DETAULT_CAPACITY;
        this.length = 0;
        head = new SNode();
    }

    public void deleteNode(SNode node) {
        SNode nextNode = node.getNext().getNext();
        node.setNext(nextNode);
        --length;
    }

    public SNode findNode(T t) {
        if (t == null) {
            throw new IllegalArgumentException("参数不能为Null");
        }
        SNode node = head;
        while (node.getNext() != null) {
            if (node.getNext().getElement().equals(t)) {
                return node;
            }
            node = node.getNext();
        }
        return null;
    }

    public SNode add(T t) {
        SNode preNode = findNode(t);
        if (preNode != null) {
            deleteNode(preNode);
            insertNode(t);
        }else{
            if (isFull()) {
                removeLast();
            }
            insertNode(t);
        }
        return null;
    }

    public void removeLast() {
        SNode next = head.getNext();
        SNode preNode = head;
        while (next.getNext() != null) {
            preNode = next;
            next = next.getNext();
        }
        preNode.setNext(null);
        --length;
    }

    public SNode insertNode(T element) {
        SNode<T> newNode = new SNode<>(element);
        SNode headNext = head.getNext();
        newNode.setNext(headNext);
        head.setNext(newNode);
        ++length;
        return newNode;
    }


    public boolean isFull() {
        return this.length >= this.capacity;
    }

    /**
     * SNode
     *
     * @param <T>
     */
    public class SNode<T> {
        private T element;
        private SNode next;

        public SNode() {
            this.next = null;
        }

        public SNode(T element) {
            this.element = element;
        }

        public SNode(T element, SNode next) {
            this.element = element;
            this.next = next;
        }

        public T getElement() {
            return element;
        }

        public void setElement(T element) {
            this.element = element;
        }

        public SNode getNext() {
            return next;
        }

        public void setNext(SNode next) {
            this.next = next;
        }

    }

    public static void main(String[] args) {
        SNodeLRU obj = new SNodeLRU(10);
        obj.add(1);
        obj.add(2);
        obj.add(3);
        obj.add(1);
        System.out.println(obj.toString());

    }

}
