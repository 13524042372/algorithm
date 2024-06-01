package org.hot100;

import java.util.*;

public class FindAnagrams_438 {

    /**
     * 使用滑动窗口进行比较
     *
     * @param s
     * @param p
     * @return
     */
    public List<Integer> findAnagrams(String s, String p) {
        int pL = p.length();
        List<Integer> ans = new ArrayList<>();
        //通过int【】来记录每个字母出现的次数
        int[] sArray = new int[26];
        int[] pArray = new int[26];
        if (s.length() < p.length()) {
            return ans;
        }
        //对于第一个位置先进行初始化，如果匹配了那么就放入结果队列
        for (int i = 0; i < p.length(); i++) {
            sArray[s.charAt(i) - 'a']++;
            pArray[p.charAt(i) - 'a']++;
        }
        if (Arrays.equals(sArray, pArray)) {
            ans.add(0);
        }
        //对剩下的字符串进行处理，将符合结果的放入队列
        for (int i = 0; i < s.length() - pL; i++) {
            --sArray[s.charAt(i) - 'a'];//窗口移除的字母
            ++sArray[s.charAt(i + pL) - 'a'];//窗口放入的字母，注意下标
            if (Arrays.equals(sArray, pArray)) {
                ans.add(i + 1);
            }
        }
        return ans;
    }

    /**
     * 用一个int【】标记每个字母的差异，同时diff字段统计出现差异的个数。
     * 最后比较diff是不是为0就可以了。
     * @param s
     * @param p
     * @return
     */
    public List<Integer> findAnagrams_2(String s, String p) {
        int sLen = s.length(), pLen = p.length();

        if (sLen < pLen) {
            return new ArrayList<Integer>();
        }

        List<Integer> ans = new ArrayList<Integer>();
        int[] count = new int[26];
        for (int i = 0; i < pLen; ++i) {
            ++count[s.charAt(i) - 'a'];
            --count[p.charAt(i) - 'a'];
        }

        int differ = 0;
        for (int j = 0; j < 26; ++j) {
            if (count[j] != 0) {
                ++differ;
            }
        }

        if (differ == 0) {
            ans.add(0);
        }

        for (int i = 0; i < sLen - pLen; ++i) {
            if (count[s.charAt(i) - 'a'] == 1) {  // 窗口中字母 s[i] 的数量与字符串 p 中的数量从不同变得相同
                --differ;
            } else if (count[s.charAt(i) - 'a'] == 0) {  // 窗口中字母 s[i] 的数量与字符串 p 中的数量从相同变得不同
                ++differ;
            }
            --count[s.charAt(i) - 'a'];

            if (count[s.charAt(i + pLen) - 'a'] == -1) {  // 窗口中字母 s[i+pLen] 的数量与字符串 p 中的数量从不同变得相同
                --differ;
            } else if (count[s.charAt(i + pLen) - 'a'] == 0) {  // 窗口中字母 s[i+pLen] 的数量与字符串 p 中的数量从相同变得不同
                ++differ;
            }
            ++count[s.charAt(i + pLen) - 'a'];

            if (differ == 0) {
                ans.add(i + 1);
            }
        }

        return ans;
    }



}
