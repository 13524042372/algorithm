package org.hot100;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

/**
 * 滑动窗口
 *
 */
public class LongthOfLongestSubstring_3 {

    public int longthOf(String s){
        int l = 0, r = 0;
        int ans = 0;
        int n = s.length();
        Set<Character> set = new HashSet<>();
        while(r < n){
            char c = s.charAt(r);
            if(set.add(c)){
                ans = Math.max(ans, r - l + 1);
                r++;
            } else {
                char lc = s.charAt(l);
                set.remove(lc);
                l++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        LongthOfLongestSubstring_3 l = new LongthOfLongestSubstring_3();
        int longth = l.longthOf("ababababab");
        System.out.println(longth);
    }

}
