package com.solong.zheng.algo.basic9.链式队列;

/**
 * @Author znsong
 * @Date 2019/11/13 19:25
 */
public class LinkedQueue {

    public static void main(String[] args) {

        Queue queue = new Queue();
        queue.enqueue(0);
        queue.enqueue(1);
        queue.enqueue(2);

        queue.printAll();

        queue.dequeue();
        queue.dequeue();
        queue.dequeue();

        queue.printAll();
    }

    public static class Queue<T> {

        private LinkedQueueLinkedNode head;
        private LinkedQueueLinkedNode tail;
        // 如果实现链式队列需要限制容量大小，可以添加这个作为限制。
        // private int capacity;

        public void enqueue(T t) {
            LinkedQueueLinkedNode en = new LinkedQueueLinkedNode(t, null);
            if (tail == null) {
                tail = en;
                head = en;
            } else {
                tail.next = en;
                tail = en;
            }
        }

        public LinkedQueueLinkedNode dequeue() {
            if (head == null) return null;
            LinkedQueueLinkedNode pre = head;
            head = head.next;
            pre.next = null;
            if (head == null) tail = null;
            return pre;
        }

        public void printAll() {
            LinkedQueueLinkedNode p = head;
            while (p != null) {
                System.out.print(p.element + " ");
                p = p.next;
            }
            System.out.println();
        }

        /**
         * s
         * LinkedList
         *
         * @param <T>
         */
        static class LinkedQueueLinkedNode<T> {
            private T element;
            private LinkedQueueLinkedNode next;

            public LinkedQueueLinkedNode(T t, LinkedQueueLinkedNode next) {
                this.element = t;
                this.next = next;
            }

            public LinkedQueueLinkedNode() {
            }
        }

    }


}
