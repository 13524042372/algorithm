package org.hot100;

import java.sql.SQLOutput;
import java.util.Arrays;

public class MyTest {
    public static void main(String[] args) {
        int[] t = new int[]{1,2,4,3,6};
        quictSort(t,0,t.length - 1);
        System.out.println(Arrays.toString(t));
    }

    static  int[] quictSort(int[] nums ,int a,int b){
        if(a == b || a > b){
            return nums;
        }
        int x = nums[a];
        int  l = a;
        int  r = b ;
        while(l < r){

           if(nums[l] >= x){
               swap(nums,l,r);
               r--;
           }else if(nums[l] < x){
               l++;
           }

           /* do{
                l++;
            }while(l < nums.length - 1 && nums[l] < x);
            do{
                r--;
            }while(r > 1 && nums[r] > x);
            swap(nums,l,r);*/
            System.out.println(Arrays.toString(nums));
        }
       // nums[l ] = x;
        quictSort(nums,a,l - 1);
        quictSort(nums,l + 1,b);
        return nums;
    }
    static  void swap(int[] nums, int a, int b){

        int t = nums[a];
        nums[a] = nums[b];
        nums[b] = t;
    }
}
