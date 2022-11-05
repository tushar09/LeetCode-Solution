package leetCode.palindromeBreaker;

public class PalindromeBreaker {
    public static void main(String args []){
        //System.out.println(breakPalindrome("abccba"));
        //System.out.println(breakPalindrome("bbb"));
        System.out.println(breakPalindrome("aaa"));
        //System.out.println(breakPalindrome("aba"));
        System.out.println(breakPalindrome("bbb"));
        //System.out.println(breakPalindrome("cbc"));
    }

    public static String breakPalindrome(String palindrome) {

//        if(palindrome.length() == 1){
//            return "";
//        }else{
//            String output = "";
//            for (int i = 0; i < palindrome.length(); i++) {
//                if(palindrome.charAt(i) != 'a'){
//                    StringBuilder str = new StringBuilder(palindrome.substring(0, i) + 'a' + palindrome.substring(i + 1));
//                    if(!str.reverse().equals(palindrome)){
//                        output = str.reverse().toString();
//                        break;
//                    }
//                }
//            }
//            if(output.equals("")){
//                return palindrome.substring(0, palindrome.length() - 1) + 'b';
//            }
//
//            boolean isAllSame2 = true;
//            for (int i = 1; i < output.length(); i++) {
//                if(output.charAt(i) != output.charAt(0)){
//                    isAllSame2 = false;
//                    break;
//                }
//            }
//
//            if(isAllSame2){
//                if(palindrome.charAt(palindrome.length() - 1) == 'b'){
//                    return palindrome.substring(0, palindrome.length() - 1) + 'a';
//                }else{
//                    return palindrome.substring(0, palindrome.length() - 1) + 'b';
//                }
//
//            }
//            return output;
//        }
        if(palindrome.length() == 1){
            return "";
        }else {
            char [] arr = palindrome.toCharArray();
            for (int i = 0; i < arr.length / 2; i++) {
                if(arr[i] != 'a'){
                    arr[i] = 'a';
                    return new String(arr);
                }
            }
            arr[arr.length - 1] = 'b';
            return new String(arr);
        }
    }
}
