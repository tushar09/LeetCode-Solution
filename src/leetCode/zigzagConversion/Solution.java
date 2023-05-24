package leetCode.zigzagConversion;

import java.util.ArrayList;

class Solution {

    public static void main(String [] args){
        System.out.println(convert2("PAYPALISHIRING", 3));
        System.out.println(convert2("AB", 1));
        System.out.println(convert2("ABC", 1));
        System.out.println(convert2("ABC", 2));
        System.out.println(convert2("ABC", 4));
    }

    public static String convert(String s, int numRows) {
        if(numRows == 1){
            return s;
        }
        StringBuilder [] builders = new StringBuilder[numRows];
        for (int i = 0; i < builders.length; i++) {
            builders[i] = new StringBuilder();
        }

        int j = 0;
        boolean goUp = false;
        for (int i = 0; i < s.length(); i++) {
            builders[j] = builders[j].append(s.charAt(i));
            if(goUp){
                j--;
            }else {
                j++;
            }
            if(j >= numRows - 1){
                goUp = true;
            }else if(j == 0){
                goUp = false;
            }
        }

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < builders.length; i++) {
            res.append(builders[i]);
        }
        return res.toString();
    }

    public static String convert2(String s, int numRows) {
        if(s.length() <= 2 || numRows < 2 || s.length() <= numRows - 1) return s;
        StringBuilder [] builders = new StringBuilder[numRows];
        for (int i = 0; i < builders.length; i++) {
            builders[i] = new StringBuilder();
        }

        int index = 0;
        while (index < s.length()){
            for (int i = 0; i < numRows && index < s.length(); i++) {
                builders[i] = builders[i].append(s.charAt(index++));
            }

            for (int i = numRows - 2; i > 0 && index < s.length(); i--) {
                builders[i] = builders[i].append(s.charAt(index++));
            }
        }

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < builders.length; i++) {
            res.append(builders[i]);
        }
        return res.toString();
    }
}
