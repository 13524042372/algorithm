package org.hot100;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * '('，')'，'{'，'}'，'['，']'
 */
public class IsValid_100 {
    private Map<Character,Character> map = new HashMap(){{
        put(')','(');
        put('}','{');
        put(']','[');
    }};
    public boolean isValid(String s) {

        int n = s.length();
        Deque<Character> deque = new LinkedList();
        for(int i = 0; i < n; i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                char open = map.get(c);
                Character character = deque.pollFirst();
                if(character == null || open != character){
                    return false;
                }
            } else {
                deque.offerFirst(c);
            }
        }
        return deque.isEmpty();

    }
}
