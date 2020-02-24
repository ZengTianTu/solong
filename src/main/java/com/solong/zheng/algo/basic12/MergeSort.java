package com.solong.zheng.algo.basic12;

/**
 * @Author znsong
 * @Date 2019/12/29 21:12
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {11,8,3,9,7,1};
        int n = arr.length;

        mergeSort(arr,0,n-1);
    }

    public static void mergeSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int q = (left + right) / 2;
        mergeSort(arr, left, q);
        mergeSort(arr, q + 1, right);
        merge(arr, left, q, right);
    }

    private static void merge(int[] arr, int left, int q, int right) {
        int i = left;
        int j = q + 1;
        int k = 0;
        int[] tmp = new int[right - left + 1];
        while (i <= q && j <= right) {
            if (arr[i] <= arr[j]) {
                tmp[k++] = arr[i++];
            } else {
                tmp[k++] = arr[j++];
            }
        }
        int start = i;
        int end = q;//;;
        if (j <= right) {
            start = j;
            end = right;
        }
        while (start <= end) {
            tmp[k++] = arr[start++];
        }
        for (int l = 0; l <= right - left; l++) {
            arr[l + left] = tmp[l];
        }

        for(int c=0;c<arr.length;c++){
            System.err.print(arr[c]);
        }
        System.err.println(".");

    }

}
