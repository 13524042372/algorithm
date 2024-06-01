package org.hot100;

import java.util.ArrayList;
import java.util.List;

public class Permute {
    /**
     * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> t = new ArrayList<>();
        boolean[] a = new boolean[nums.length];
        permute(nums, a,t, ans);
        return ans;
    }

    private void permute(int[] nums, boolean[] a,List<Integer> t , List<List<Integer>> ans){
        int n = nums.length;
        if (t.size() == n){
            ans.add(new ArrayList<>(t));
            return;
        }
        for(int i = 0; i < n; i++){
            if(a[i]){
                continue;
            }
            a[i] = true;
            t.add(nums[i]);
            permute(nums,a,t,ans);
            t.remove(t.size() - 1);
            a[i] = false;
        }
    }
}
