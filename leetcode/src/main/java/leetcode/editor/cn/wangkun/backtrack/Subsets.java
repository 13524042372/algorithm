package leetcode.editor.cn.wangkun.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Subsets {
    List<List<Integer>> subsets(int[] nums){
        List<List<Integer>> res = new LinkedList<>();
        LinkedList<Integer> temp = new LinkedList<>();
        subset(nums, 0, res, temp);
        return res;
    }

    private void subset(int[] nums, int step, List<List<Integer>> res, LinkedList<Integer> temp ){
        //1 将结果保存
        res.add(new LinkedList<>(temp));
        //2 遍历开始下一层
        for (int i = step; i < nums.length; i++){
            //将当前位置放入
            temp.addLast(nums[i]);
            //进入下层
            subset(nums, i + 1, res, temp);
            //将下层回退
            temp.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] t = new int[]{1,2,3};
        Subsets subsets = new Subsets();
        List<List<Integer>> subsets1 = subsets.subsets(t);
        System.out.println(subsets1);

    }

}
