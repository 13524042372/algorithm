package com.wangkun;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Permute_46 {
    List<List<Integer>> permute(int[] nums) {
        List<Integer> temp = new ArrayList<>();//跟踪树的节点
        boolean[] used = new boolean[nums.length];
        List<List<Integer>> res = new ArrayList<>();
        trackBack(nums,temp,used,res);
        return res;
    }
    private void trackBack(int[] nums, List<Integer> temp, boolean[] used,List<List<Integer>> res){
        res.add(new ArrayList<>(temp));

        /*if(temp.size() == nums.length){
            res.add(new ArrayList<>(temp));
            return;
        }*/
        for(int i = 0; i < nums.length; i++){
            if(used[i]){
                continue;
            }
            temp.add(nums[i]);
            used[i] = true;
            trackBack(nums,temp,used,res);
            temp.remove(temp.size() - 1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        Permute_46 p = new Permute_46();
        int[] t = new int[]{1,2,3};
        List<List<Integer>> permute = p.permute(t);
        System.out.println(permute);
    }
}
