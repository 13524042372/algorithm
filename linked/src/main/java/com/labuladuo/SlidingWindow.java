package com.labuladuo;

import java.util.HashMap;
import java.util.Map;

public class SlidingWindow {

    void slidingWindow(String s) {
        Map<Character, Integer> windows = new HashMap<>();//窗口数据
        int left = 0, right = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            windows.put(c, windows.getOrDefault(c, 0) + 1);
            right++;


            while (left < right && true){
                char lc = s.charAt(left);
                 windows.remove(lc);
                left++;
            }
        }
    }


}
