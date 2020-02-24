package com.solong.zheng.algo.basic12;

/**
 * @Author znsong
 * @Date 2019/12/30 7:44
 */
public class Demo {

    public static void main(String[] args) {
        int[] arr = {6,8,5,4,2,1,3};
        int n = arr.length;

        quickSort(arr,0,n-1);

        for(int i=0;i<arr.length;i++)
            System.out.println(arr[i]);

    }

    public static void quickSort(int[] arr,int p,int r){
        if(p>=r)
            return;
        // index
        int q = partition(arr,p,r);
        quickSort(arr,p,q-1);
        quickSort(arr,q+1,r);
    }

    private static int partition(int[] arr, int p, int r) {
        int i = p;
        int pivot = arr[r];
        for(int j=p;j<r;j++){
            if(arr[j] < pivot){
                if(i==j){
                    ++i;
                }else{
                    int tmp = arr[j];
                    arr[j] = arr[i];
                    arr[i++] = tmp;
                }
            }
        }

        int tmp = arr[i];
        arr[i] = pivot;
        arr[r] = tmp;
        return i;
    }


}
