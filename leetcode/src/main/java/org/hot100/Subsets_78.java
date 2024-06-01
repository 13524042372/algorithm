package org.hot100;

import java.util.ArrayList;
import java.util.List;

public class Subsets_78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList();
        List<Integer> t = new ArrayList();
        int step = 0;
        subsets(nums,step,t, ans);
        return ans;

    }

    private void subsets(int[] nums, int step,List<Integer> t, List<List<Integer>> ans){
        int n = nums.length;
        if(step == n){
             ans.add(new ArrayList<Integer>(t));
        }

        t.add(nums[step]);
        subsets(nums,step + 1, t, ans);

        t.remove(t.size() - 1);

        subsets(nums,step + 1,t,ans);

    }
}
