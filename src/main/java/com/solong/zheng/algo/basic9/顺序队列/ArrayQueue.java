package com.solong.zheng.algo.basic9.顺序队列;

import java.util.Arrays;

/**
 * @Author znsong
 * @Date 2019/11/13 18:42
 */
public class ArrayQueue {

    public static void main(String[] args) {
        Queue queue = new Queue(3);

        queue.enqueue("0");
        queue.enqueue("1");
        queue.enqueue("2");
        Arrays.asList(queue.items).forEach(System.out::println);
        System.out.println(queue.dequeue());
        /*System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());*/
        //queue.enqueue("0");
        queue.enqueue("0");
    }

    public static class Queue {
        private String[] items;
        private int n = 0;
        private int head = 0;
        private int tail = 0;

        public Queue(int capacity) {
            this.n = capacity;
            this.items = new String[capacity];
        }


        /**
         * 只需要在入队时把head后面的数据，统一往前面移动
         *
         * @param item
         * @return
         */
        public boolean enqueue(String item) {
            if (n == tail) {
                //队列占满
                if (head == 0) return false;
                for (int i = head; i < tail; i++) {
                    items[i - head] = items[i];
                }
                tail -= head;
                head = 0;
            }

            items[tail] = item;
            ++tail;
            return true;
        }

        /**
         * 如果出队不搬移数据，就要手动重置head和tail为0
         *
         * @return
         */
        /* public boolean enqueue(String item) {
            if (n == tail) {
                if(head == tail){
                    head=0;
                    tail=0;
                }else{
                    return false;
                }
            }

            items[tail] = item;
            ++tail;
            return true;
        }*/

        // 删除了数据，只需要把队列头的元素取出，不需要重新整理置空的位置。
        public String dequeue() {
            if (head == tail) return null;

            String item = items[head];
            items[head] = null;
            ++head;
            return item;
        }
    }

}
