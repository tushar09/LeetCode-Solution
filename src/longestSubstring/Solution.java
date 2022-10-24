package longestSubstring;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;

public class Solution {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring3("abcabcbb"));
        System.out.println(lengthOfLongestSubstring3("bbbb"));
        System.out.println(lengthOfLongestSubstring3("pwwkew"));
        System.out.println(lengthOfLongestSubstring3(" "));
        System.out.println(lengthOfLongestSubstring3(" b"));
        System.out.println(lengthOfLongestSubstring3("dvdf"));
        System.out.println(lengthOfLongestSubstring3("ohvhjdml"));
        System.out.println(lengthOfLongestSubstring3("qrsvbspk"));
    }

    public static int lengthOfLongestSubstring(String s) {
        int res = 0;
        String temp = "";
        LinkedHashMap<Character, Character> map = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                if (res < temp.length()) {
                    res = temp.length();
                }
                temp = (temp + s.charAt(i)).substring(1);
                while (map.containsKey(s.charAt(i))) {
                    //map.remove();
                }

                //map.clear();
                map.put(s.charAt(i), s.charAt(i));
            } else {
                temp = temp + s.charAt(i);
                if (res < temp.length()) {
                    res = temp.length();
                }
                map.put(s.charAt(i), s.charAt(i));
            }
        }
        return res;
    }

    public static int lengthOfLongestSubstring2(String s) {
        int res = 0;
        ArrayList<String> map = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.contains(s.charAt(i) + "")) {
                if (map.indexOf(s.charAt(i) + "") == 0) {
                    map.remove(0);
                    map.add(s.charAt(i) + "");
                } else if (map.indexOf(s.charAt(i) + "") > 0) {
                    //System.out.println(map.indexOf(s.charAt(i) + ""));
                    int x = map.indexOf(s.charAt(i) + "");
                    for (int j = 0; j <= x; j++) {
                        if (map.size() > 0) {
                            map.remove(0);
                        }

                    }
                    map.add(s.charAt(i) + "");
                    if (res < map.size()) {
                        res = map.size();
                    }
                }
            } else {
                map.add(s.charAt(i) + "");
                if (res < map.size()) {
                    res = map.size();
                }
            }
        }
        return res;
    }

    public static int lengthOfLongestSubstring3(String s) {
        int n = s.length(), longest = 0;
        int[] nextIndex = new int[128];
        for (int l = 0, r = 0; r < n; r++) {

            l = Math.max(nextIndex[s.charAt(r)], l);
            longest = Math.max(r - l + 1, longest);
            nextIndex[s.charAt(r)] = r + 1;

        }

        return longest;
    }

}
