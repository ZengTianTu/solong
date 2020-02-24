package com.solong.zheng.algo.basic8.使用数组实现一个栈结构;

/**
 * @Author znsong
 * @Date 2019/11/11 16:20
 */
public class MyFirstStack {

    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(3);
        //System.out.println(stack.popStack());
        stack.pushStack(1);
        stack.pushStack(2);
        stack.pushStack(3);
        //stack.pushStack(3);
        System.out.println(stack.popStack());
        System.out.println(stack.popStack());
        System.out.println(stack.popStack());
    }

    public static ArrayStack createStack(){
       return new ArrayStack();
    }

    public static ArrayStack createStack(int capacity){
        return new ArrayStack(capacity);
    }

    public static class ArrayStack<T> {
        private static final int DEFAULT_CAPACITY = 1 << 8;
        private T[] array;
        private int count;
        private int capacity;

        public ArrayStack() {
            this.capacity = DEFAULT_CAPACITY;
            this.count = 0;
            this.array = (T[]) new Object[capacity];
        }

        public ArrayStack(int capacity) {
            this.capacity = capacity;
            this.count = 0;
            this.array = (T[]) new Object[capacity];
        }

        public boolean pushStack(T t) {
            if (isFull()) {
                throw new IllegalArgumentException("栈已满");
            }
            array[count] = t;
            ++count;
            return true;
        }

        public T popStack() {
            if (isNotFull()) {
                throw new IllegalArgumentException("栈已空");
            }
            T t = array[--count];
            return t;
        }

        private boolean isFull() {
            return this.count == this.capacity;
        }

        private boolean isNotFull() {
            return this.count == 0;
        }

    }

}
