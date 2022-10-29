package turing.demo.validParentheses;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        long s = System.currentTimeMillis();
        System.out.println(calPoints("{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}"));
        System.out.println(System.currentTimeMillis() - s);
    }

    public static boolean calPoints(String str){
        Map<Character, Character> parenthesesMapping = new HashMap<>();
        parenthesesMapping.put('(', ')');
        parenthesesMapping.put('{', '}');
        parenthesesMapping.put('[', ']');

        Stack<Character> parentheses = new Stack<>();
        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(parenthesesMapping.containsKey(c)) {
                parentheses.push(c);
            } else {
                if(parentheses.isEmpty()) {
                    return false;
                }
                char target = parentheses.pop();
                if(!parenthesesMapping.containsKey(target) || parenthesesMapping.get(target) != c) {
                    return false;
                }
            }
        }
        if(!parentheses.isEmpty()) {
            return false;
        }
        return true;
    }
}
