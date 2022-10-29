package turing.demo.validParentheses;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution2 {
    public static void main(String[] args) {
        long s = System.currentTimeMillis();
        System.out.println(calPoints("{}(){}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{()())"));
        System.out.println(System.currentTimeMillis() - s);
    }

    public static boolean calPoints(String str){

        Stack<Character> parentheses = new Stack<>();
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '(' || str.charAt(i) == '{' || str.charAt(i) == '['){
                parentheses.push(str.charAt(i));
            }else{
                if(parentheses.empty()){
                    return false;
                } else if((parentheses.peek() == '(' && str.charAt(i) == ')') || (parentheses.peek() == '{' && str.charAt(i) == '}') || (parentheses.peek() == '[' && str.charAt(i) == ']')){
                    parentheses.pop();
                }else {
                    return false;
                }
            }

        }
        if(parentheses.empty()){
            return true;
        }else {
            return false;
        }
    }
}
