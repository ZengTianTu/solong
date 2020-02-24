package com.solong.zheng.algo.basic11.插入;

/**
 * @Author znsong
 * @Date 2019/11/17 13:23
 */
public class InsertSort {

    public static void main(String[] args) {
        InsertSort i = new InsertSort();

        int arr[] = {4, 5, 6, 1, 3, 2};
        int n = 6;

        //i.insertSort();
    }

    public void insertSort() {
        int arr[] = {4, 5, 6, 1, 3, 2};
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int value = arr[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (arr[j] > value) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + 1] = value;
        }

        for (int i : arr) {
            System.out.println(i);
        }

    }


    // 插入排序，a表示数组，n表示数组大小
    public void insertionSort(int[] a, int n) {
        if (n <= 1) return;

        for (int i = 1; i < n; ++i) {
            int value = a[i];
            int j = i - 1;
            // 查找插入的位置
            for (; j >= 0; --j) {
                if (a[j] > value) {
                    a[j + 1] = a[j];  // 数据移动
                } else {
                    break;
                }
            }
            a[j + 1] = value; // 插入数据
        }
    }

}
