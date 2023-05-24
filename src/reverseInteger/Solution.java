package reverseInteger;

import java.util.ArrayList;

class Solution {

    public static void main(String[] args) {
        //System.out.println(reverse2(43));
        //System.out.println(reverse2(-43));
        //System.out.println(reverse2(Integer.MAX_VALUE));
        System.out.println(reverse2(1463847412));
        System.out.println(reverse2(1534236469));
        //System.out.println(43 / 10);
        //System.out.println(43 % 10);
    }

    public static int reverse2(int x) {
        int res = 0;
        while (x != 0) {
            if (res > Integer.MAX_VALUE / 10 || res < Integer.MIN_VALUE / 10) {
                return 0;
            }
            res = (res * 10) + x % 10;
            x /= 10;
        }
        return res;

    }

    public static int reverse(int x) {
        String s = x + "";
        if (x < 0) {
            s = s.replace("-", "");
        }

        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        s = sb.toString();

        if (s.length() > 10) {
            return 0;
        }

        if (Long.parseLong(s) > 2147483647L) {
            return 0;
        }

        if (x < 0) {
            return 0 - Integer.parseInt(s);
        } else {
            return Integer.parseInt(s);
        }


    }
}
