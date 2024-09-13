package org.hot100.exe;

import java.util.Arrays;

public class QuickSort {

    public  void quickSort(int[] arr){
        quickSort(arr, 0, arr.length - 1);
    }
    public  void quickSort(int[] arr, int start, int end) {
        if(start >= end){
            return;
        }
        int mid = partition(arr,start,end);
        quickSort(arr,start,mid - 1);
        quickSort(arr,mid + 1, end);

    }
    public int partition(int[] arr, int start,int end){
        int p = arr[start];
        int left = start + 1;
        int right = end;
        while(left < right){
            while(left < right && arr[left] <= p) left++;
            while(left < right && arr[right] >= p) right--;
            if(left < right){
                swap(arr,left, right);
                left++;
                right--;
            }
        }
        if(left == right && arr[right] >= p) right--;
        swap(arr,start,right);
        return  right;
    }
    public void swap(int[] arr, int left, int right){
        int t = arr[left];
        arr[left] = arr[right];
        arr[right] = t;
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] a = new int[]{1,3,6,2,4,8,5};
        quickSort.quickSort(a);
        System.out.println(Arrays.toString(a));
    }
}
