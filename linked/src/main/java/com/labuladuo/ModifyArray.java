package com.labuladuo;

public class ModifyArray {

    int[] getModifiedArray(int length, int[][] updates) {
        int[] p = new int[length];
        for (int m = 0; m < updates.length; m++){
           int l = updates[m][0];
           int r = updates[m][1];
           int val = updates[m][2];
           p[l] += val;
           p[r + 1] -= val;
        }

        int[] res = new int[length];
        res[0] = p[0];
        for ( int i = 1; i < length; i++){
            res[i] = res[i - 1] + p[i];
        }
        return res;
    }

}
