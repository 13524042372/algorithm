package org.lc.sort;

import java.util.Arrays;

public class SelectionSort {

    public static void selectionSort(int[] arr) {
        int len = arr.length;
        int minIndex = 0;
        for(int i = 0; i < len - 1; i++){
            minIndex = i;
            for(int j = i + 1; j < len; j++){
                if(arr[minIndex] > arr[j]){
                    minIndex = j;
                }
            }
            swap(arr, i,minIndex);
        }
    }
    static void swap(int[] arr, int i , int j){
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        int[] a = new int[]{2,4,3,6,2,7,3,4};
        selectionSort(a);
        System.out.println(Arrays.toString(a));
    }
}
