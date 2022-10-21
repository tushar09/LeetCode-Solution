package toptal;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        int[] arr2 = new int[]{1, 3, 6, 4, 1, 2};

        System.out.println(solution(arr2));

    }

    public static int solution(int[] A) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < A.length; i++) {
            map.put(A[i], A[i]);
        }
        int x = 1;
        while (true){
            if(!map.containsKey(x)){
                return x;
            }else {
                x++;
            }
        }
    }

}
