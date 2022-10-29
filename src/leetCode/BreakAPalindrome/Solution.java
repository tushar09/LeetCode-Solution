package leetCode.BreakAPalindrome;

class Solution {

    public static void main(String [] args){
        System.out.println(breakPalindrome("abccba"));
        System.out.println(breakPalindrome("aa"));
        System.out.println(breakPalindrome("aba"));
    }

    public static String breakPalindrome(String palindrome) {
        if(palindrome.length() < 2){
            return "";
        }
        char [] b = palindrome.toCharArray();

        for (int i = 0; i < b.length; i++) {
            if(b[i] != 'a'){
                b[i] = 'a';
                break;
            }
        }

        if(new String(b).equals(new StringBuilder(new String(b)).reverse().toString())){
            b[b.length - 1] = 'b';
        }

        if(new String(b).equals(palindrome)){
            return "";
        }
        return new String(b);
    }
}
