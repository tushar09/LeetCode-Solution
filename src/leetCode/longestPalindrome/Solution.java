package leetCode.longestPalindrome;

class Solution {

    public static void main(String [] args){
        System.out.println(longestPalindrome("abccba"));
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("cbbd"));
        System.out.println(longestPalindrome("aa"));
        System.out.println(longestPalindrome("aba"));
    }

    public static String longestPalindrome(String s) {
        if(s == null || s.length() < 1){
            return "";
        }
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            int lengthOdd = checkMiddle(s, i, i);
            int lengthEven = checkMiddle(s, i, i + 1);
            int length = Math.max(lengthEven, lengthOdd);
            if(length > end - start){
                start = i - ((length - 1) / 2);
                end = i + (length / 2);
            }
        }
        return s.substring(start, end + 1);
    }

    public static int checkMiddle(String s, int left, int right){
        if(s == null || left > right){
            return 0;
        }
        while (left >=0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }

        return right - left - 1;
    }
}
