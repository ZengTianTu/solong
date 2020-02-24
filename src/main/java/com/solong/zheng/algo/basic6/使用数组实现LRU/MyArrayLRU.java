package com.solong.zheng.algo.basic6.使用数组实现LRU;

import java.util.HashMap;

/**
 * 使用数组实现LRU最近最少使用算法
 * 1. 空间复杂度为O(n)
 * 2. 时间复杂度为O(n)
 * 3. 不支持null的缓存
 *
 * @Author znsong
 * @Date 2019/11/8 22:22
 */
public class MyArrayLRU<T> {

    private static final int DEFAULT_CAPACITY = 1 << 3;
    private int count;
    private int capacity;
    private T[] value;
    private HashMap<T, Integer> holder;

    public MyArrayLRU() {
        this(DEFAULT_CAPACITY);
    }

    public MyArrayLRU(int capacity) {
        this.capacity = capacity;
        value = (T[])new Object[capacity];
        this.count = 0;
        this.holder = new HashMap<T, Integer>(capacity);
    }

    public Integer offer(T object) {
        if (object == null) {
            throw new IllegalArgumentException("该缓存容器不支持null");
        }
        Integer index = holder.get(object);
        if (index == null) {
            if (isFull()) {
                removeAndCache(object);
            } else {
                cache(object, count);
            }
        } else {
            update(index);
        }
        return 1;
    }

    public boolean isFull() {
        return this.capacity == this.count;
    }

    public void rightShift(int end) {
        for (int i = end - 1; i >= 0; i--) {
            value[i + 1] = value[i];
            holder.put(value[i], i + 1);
        }
    }

    private void removeAndCache(T object) {
        T key = value[--count];
        holder.remove(key);
        cache(object, count);
    }

    private void cache(T object, int end) {
        rightShift(end);
        value[0] = object;
        holder.put(object, 0);
        count++;
    }

    private void update(Integer end) {
        T target = value[end];
        rightShift(end);
        value[0] = target;
        holder.put(target, 0);
    }

    public boolean isContain(T object) {
        return holder.containsKey(object);
    }

    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(value[i]);
            sb.append(" ");
        }
        return sb.toString();
    }

    static class TestLRUBasedArray {

        public static void main(String[] args) {
            testDefaultConstructor();
            testSpecifiedConstructor(4);
            testWithException();
        }

        private static void testWithException() {
            MyArrayLRU<Integer> lru = new MyArrayLRU<Integer>();
            lru.offer(null);
        }

        public static void testDefaultConstructor() {
            System.out.println("======无参测试========");
            MyArrayLRU<Integer> lru = new MyArrayLRU<Integer>();
            lru.offer(1);
            lru.offer(2);
            lru.offer(3);
            lru.offer(4);
            lru.offer(5);
            System.out.println(lru);
            lru.offer(6);
            lru.offer(7);
            lru.offer(8);
            lru.offer(9);
            System.out.println(lru);
            lru.offer(3);
            System.out.println(lru);
        }

        public static void testSpecifiedConstructor(int capacity) {
            System.out.println("======有参测试========");
            MyArrayLRU<Integer> lru = new MyArrayLRU<Integer>(capacity);
            lru.offer(1);
            System.out.println(lru);
            lru.offer(2);
            System.out.println(lru);
            lru.offer(3);
            System.out.println(lru);
            lru.offer(4);
            System.out.println(lru);
            lru.offer(2);
            System.out.println(lru);
            lru.offer(4);
            System.out.println(lru);
            lru.offer(7);
            System.out.println(lru);
            lru.offer(1);
            System.out.println(lru);
            lru.offer(2);
            System.out.println(lru);
        }
    }
}
