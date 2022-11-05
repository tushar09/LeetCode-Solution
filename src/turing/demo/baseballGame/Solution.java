package turing.demo.baseballGame;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        //System.out.println(calPoints(new String[]{"5", "2", "C", "D", "+"}));
        System.out.println(calPoints(new String[]{" "}));
        System.out.println(calPoints(new String[]{" "}));
    }

    public static int calPoints(String [] ops){
        if(ops.length == 1){
            return Integer.parseInt(ops[0]);
        }
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < ops.length; i++) {
            if(ops[i].equals("C")){
                numbers.remove(numbers.size() - 1);
            }else if(ops[i].equals("D")){
                numbers.add(numbers.get(numbers.size() - 1) * 2);
            }else if(ops[i].equals("+")){
                numbers.add(numbers.get(numbers.size() - 1) + numbers.get(numbers.size() - 2));
            }else{
                numbers.add(Integer.parseInt(ops[i]));
            }
        }

        int res = 0;
        for (int i = 0; i < numbers.size(); i++) {
            res += numbers.get(i);
        }
        return res;
    }
}
