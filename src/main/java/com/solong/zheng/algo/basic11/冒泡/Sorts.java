package com.solong.zheng.algo.basic11.冒泡;

import java.util.Arrays;

/**
 * 冒泡排序、插入排序、选择排序
 * <p>
 * Author: zeng
 */
public class Sorts {

    /**
     * i从0遍历到数组length-1下标, j每次从0(开头)遍历
     * 解释n-i-1，-i是已经排序好的个数，下面例子中排序好的数字在数组队尾
     * -1是 arr[j]>arr[j+1]中需要对后面一个进行对比，最后的比较永远在(length-1)-1的位置
     * flag如果j循环中没有交换操作，表示已经是顺序的，可以终止排序函数了。
     */

    // 冒泡排序，a是数组，n表示数组大小
    public static void bubbleSort(int[] a, int n) {
        if (n <= 1) return;

        for (int i = 0; i < n; ++i) {
            // 提前退出标志位
            boolean flag = false;
            for (int j = 0; j < n - i - 1; ++j) {
                if (a[j] > a[j + 1]) { // 交换
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                    // 此次冒泡有数据交换
                    flag = true;
                }
            }
            if (!flag) break;  // 没有数据交换，提前退出
        }
    }

    /**
     * 冒泡排序改进:在每一轮排序后记录最后一次元素交换的位置,作为下次比较的边界,
     * 对于边界外的元素在下次循环中无需比较.
     */ 
    public static void bubbleSort2(int[] a, int n) {
        if (n <= 1) return;

        // 最后一次交换的位置
        int lastExchange = 0;
        // 无序数据的边界,每次只需要比较到这里即可退出
        int sortBorder = n - 1;
        for (int i = 0; i < n; i++) {
            // 提前退出标志位
            boolean flag = false;
            for (int j = 0; j < sortBorder; j++) {
                if (a[j] > a[j + 1]) {
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                    // 此次冒泡有数据交换
                    flag = true;
                    // 更新最后一次交换的位置
                    lastExchange = j;
                }
            }
            sortBorder = lastExchange;
            if (!flag) break;    // 没有数据交换，提前退出
        }
    }

    // 插入排序，a表示数组，n表示数组大小
    public static void insertionSort(int[] a, int n) {
        if (n <= 1) return;

        for (int i = 1; i < n; ++i) {
            int value = a[i];
            int j = i - 1;
            // 查找要插入的位置并移动数据
            for (; j >= 0; --j) {
                if (a[j] > value) {
                    a[j + 1] = a[j];
                } else {
                    break;
                }
            }
            a[j + 1] = value;
        }
    }

    // 选择排序，a表示数组，n表示数组大小
    public static void selectionSort(int[] a, int n) {
        if (n <= 1) return;
        // 4,5,6,3,1,2
        for (int i = 0; i < n - 1; ++i) {
            // 查找最小值
            int minIndex = i;
            for (int j = i + 1; j < n; ++j) {
                if (a[j] < a[minIndex]) {
                    minIndex = j;
                }
            }

            // 交换
            int tmp = a[i];
            a[i] = a[minIndex];
            a[minIndex] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{4,5,6,1,3,2};
        bubbleSort2(array, array.length);
        System.out.println(Arrays.toString(array));

          //selectionSort(array,array.length);
       /*
        2019.12.29 练习
        System.err.println("=====");
        int[] arr = {4,5,6,3,2,1};
        for(int i=0; i<arr.length;i++){
            boolean flag = false;
            for(int j=0;j<arr.length-i-1;j++){
                int temp;
                //if(arr[j] > arr[j+1]){
                if(arr[j] < arr[j+1]){
                    temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                    flag = true;
                }
            }
            if(!flag){
                System.out.println("此刻i为："+ i + " 没有进行交换动作，执行break");
                break;
            }
        }

        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }*/

    }


    /*//优化算法
    public static void runBubble() {
        int[] arr = {5, 2, 1, 3};
        for (int i = 0; i < arr.length; i++) {
            boolean flag = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                int temp;
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = true;
                }
            }
            if (!flag) break;
        }
    }
    // 效率低下的垃圾冒泡排序算法
    public void run1() {
        int[] arr = {4, 5, 6, 3, 2, 1};
        boolean flag = false;
        for (int i = 0; i < arr.length; i++) {
            System.out.println(" -- " + arr[i]);
            for (int j = i + 1; j < arr.length; j++) {
                int temp;
                System.out.println(arr[j]);
                if (arr[j] < arr[i]) {
                    temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
    }
*/
   }