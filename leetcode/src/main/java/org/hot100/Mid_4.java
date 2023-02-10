package org.hot100;

public class Mid_4 {

    /**
     * 在两个区间中找到第k小的数
     * @param start1 第一个数组开始坐标
     * @param end1 第一个数组的结束坐标
     * @param nums1 第一个数组
     * @param start2 第二个数组的开始坐标
     * @param end2 第二个数组的结束坐标
     * @param nums2 第二个数组
     * @param k  第k个元素
     * @return
     */
    private static int kMinNum(int start1, int end1, int[] nums1, int start2, int end2, int[] nums2, int k) {
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;
        if (len1 > len2) return kMinNum(start2, end2, nums2, start1, end1, nums1, k);
        if (len1 == 0) return nums2[start2 + k - 1];
        if (k == 1) return Math.min(nums1[start1], nums2[start2]);
        int i = start1 + Math.min(len1, k / 2) - 1;
        int j = start2 + Math.min(len2, k / 2) - 1;

        if (nums1[i] > nums2[j]) {
            return kMinNum(start1, end1, nums1, j + 1, end2, nums2, k - (j - start2 + 1));
        } else {
            return kMinNum(i + 1, end1, nums1, start2, end2, nums2, k - (i - start1 + 1));
        }
    }


    public static double Test4S1(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int left = (n + m + 1) / 2;//计算出第一个元素
        int right = (n + m + 2) / 2;//计算出第二个元素
        return (kMinNum(0, n - 1, nums1, 0, m - 1, nums2, left) //找到第left个元素
                + kMinNum(0, n - 1, nums1, 0, m - 1, nums2, right)//找到第right个元素
        ) * 0.5;
    }


}
