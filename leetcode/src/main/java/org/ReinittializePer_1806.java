package org;

import java.util.Arrays;

public class ReinittializePer_1806 {


    public int reinit(int n){
        int[] perm = new int[n];
        int[] target = new int[n];
        for(int i = 0; i < n; i++){
            perm[i] = i;
            target[i] = i;
        }
       // System.out.println(Arrays.toString(perm));
        int num = 0;
        while(true){
            num++;
            int[] arr = new int[n];
            for(int i = 0; i < n; i++){
                if(i % 2 == 0){
                    arr[i] = perm[i / 2];
                } else {
                    arr[i] = perm[n / 2 + (i - 1) / 2];
                }

            }
            System.out.println(Arrays.toString(arr));
            perm = arr;
            if(Arrays.equals(perm,target)){
                return num;
            }

        }
    }

    public static void main(String[] args) {
        ReinittializePer_1806 r = new ReinittializePer_1806();
        System.out.println(r.reinit(6));


    }

}
