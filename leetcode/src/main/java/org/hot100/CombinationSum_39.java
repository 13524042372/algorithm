package org.hot100;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum_39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> t = new ArrayList<>();
        int sum = 0;

        combinationSum(candidates,target, 0,sum,t,ans );
        return ans;

    }
    private void combinationSum(int[] candidates, int target,int index, int sum, List<Integer> t, List<List<Integer>> ans ){

        if(index > candidates.length){
            return;
        }
        if(sum == target){
            ans.add(new ArrayList<>(t));
            return;
        }
        if(sum > target){
            return;
        }

        for(int i = index; i < candidates.length;i++){
            t.add(candidates[i]);
            sum += candidates[i];
            combinationSum(candidates, target,i,sum,t,ans);
            t.remove(t.size() - 1);
            sum -= candidates[i];
        }
    }

    public static void main(String[] args) {
        int[] i = new int[]{2,3,6,7};
        CombinationSum_39 combinationSum39 = new CombinationSum_39();
        List<List<Integer>> lists = combinationSum39.combinationSum(i, 7);
        System.out.println(lists);
    }
}
