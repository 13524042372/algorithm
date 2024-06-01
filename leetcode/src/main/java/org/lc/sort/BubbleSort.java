package org.lc.sort;

import com.sun.scenario.effect.impl.sw.java.JSWColorAdjustPeer;

import java.util.Arrays;

/**
 *冒泡排序
 */
public class BubbleSort {

    public static void bubbleSort(int[] arr) {
       int len = arr.length;
       for(int i = 0; i < len - 1; i++){
           for(int j = 0; j < len - 1 - i;j++){
               if(arr[j] > arr[j + 1]){
                   swap(arr, j, j + 1);
               }
           }
       }
    }
    // 交换元素
   static void swap(int[] arr, int i , int j){
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
   }


    public static void main(String[] args) {
        int[] a = new int[]{2,4,6,3,6,9};
        bubbleSort(a);
        System.out.println(Arrays.toString(a));
    }
}
