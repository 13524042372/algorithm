package org.hot100;

import java.util.*;

public class QuickSort {

    /**
     * 随机化是为了防止递归树偏斜的操作，此处不展开叙述
     */
    private static final Random RANDOM = new Random();

    public int[] sortArray(int[] nums) {
        int len = nums.length;
        quickSort(nums, 0, len - 1, 0);
        return nums;
    }

    /**
     * 对数组的子区间 nums[left..right] 排序
     *
     * @param nums
     * @param left
     * @param right
     */
    private void quickSort(int[] nums, int left, int right, int recursionLevel) {
        log("拆分子问题", left, right, recursionLevel);
        // 1. 递归终止条件
        if (left >= right) {
            log("递归到底", left, right, recursionLevel);
            return;
        }

        int pIndex = partition(nums, left, right);
        // 2. 拆分，对应「分而治之」算法的「分」
        quickSort(nums, left, pIndex - 1, recursionLevel + 1);
        quickSort(nums, pIndex + 1, right, recursionLevel + 1);
        // 3. 递归完成以后没有「合」的操作，这是由「快速排序」partition 的逻辑决定的
    }


    /**
     * 将数组 nums[left..right] 分区，返回下标 pivot，
     * 且满足 [left + 1..lt) <= pivot，(gt, right] >= pivot
     *
     * @param nums
     * @param left
     * @param right
     * @return
     */
    private int partition(int[] nums, int left, int right) {
        int randomIndex = left + RANDOM.nextInt(right - left + 1);
        swap(nums, randomIndex, left);

        int pivot = nums[left];
        int lt = left + 1;
        int gt = right;

        while (true) {
            while (lt <= right && nums[lt] < pivot) {
                lt++;
            }

            while (gt > left && nums[gt] > pivot) {
                gt--;
            }

            if (lt >= gt) {
                break;
            }

            // 细节：相等的元素通过交换，等概率分到数组的两边
            swap(nums, lt, gt);
            lt++;
            gt--;
        }
        swap(nums, left, gt);
        return gt;
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    private void log(String log, int left, int right, int recursionLevel) {
        StringBuilder stringBuilder = new StringBuilder();
        //stringBuilder.append("  ".repeat(Math.max(0, recursionLevel)));
        stringBuilder.append(log);
        stringBuilder.append(" ");
        stringBuilder.append("=>");
        stringBuilder.append(" ");
        stringBuilder.append("[");
        stringBuilder.append(left);
        stringBuilder.append(", ");
        stringBuilder.append(right);
        stringBuilder.append("]");
        System.out.println(stringBuilder.toString());
    }

    public List<Integer> findAnagrams(String s, String p) {
        Map<Character,Integer> map = new HashMap();
        for(int i = 0; i < p.length(); i++){
            map.put(p.charAt(i),map.getOrDefault(p.charAt(i), 0) + 1);
        }
        int len = p.length();
        List<Integer> ans = new ArrayList();
        Map<Character,Integer> smap = new HashMap();

        for(int i = 0; i < s.length() ; i++){
            smap.put(s.charAt(i), smap.getOrDefault(s.charAt(i), 0 ) + 1);
            if(i < len - 1){
                continue;
            }
            if(i >= len){
                smap.put(s.charAt(i), smap.getOrDefault(s.charAt(i), 0 ) - 1);
            }
            if(check(smap, map)){
                ans.add(i - len + 1);
            }

        }
        return ans;
    }

    private boolean check(Map<Character,Integer> smap, Map<Character,Integer> pmap){
        for(Map.Entry<Character,Integer> en : pmap.entrySet()){
            char key = en.getKey();
            int value = en.getValue();
            int sv = smap.getOrDefault(key,0);
            if(value != sv){
                return false;
            }

        }
        return true;
    }
    public static void main(String[] args) {
        QuickSort solution = new QuickSort();
        int[] nums = new int[]{7, 7, 7, 1, 7, 2, 3, 4, 4, 5, 5, 6, 7, 7, 8, 9};
        int[] res = solution.sortArray(nums);
        System.out.println(Arrays.toString(res));
        Map<String,String> map = new HashMap<>();
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return 0;
            }
        });
        for(Map.Entry<String,String> entry : map.entrySet()){
            entry.getKey();
            entry.getValue();
        }
    }
}
