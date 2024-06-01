package org.hot100;

import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap();
        List<List<String>>  ans = new ArrayList<>();
        Arrays.sort(strs, (o1, o2) -> 0);
        for(String s: strs){
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String string = new String(chars);
            List<String> list=  map.get(string);
            if(list == null){
                List<String> t = new ArrayList<>();
                map.put(string ,t);
                ans.add(t);
            }
            list.add(s);

        }
        return ans;
    }

}
