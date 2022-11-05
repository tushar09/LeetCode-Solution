package leetCode.twoSum;

import java.util.Arrays;
import java.util.HashMap;

public class Solution {
    public static void main(String [] args){
        System.out.println(Arrays.toString(twoSum(new int[]{2,7,11,15}, 9)));
        System.out.println(Arrays.toString(twoSum(new int[]{2,7,11,15}, 18)));
        System.out.println(Arrays.toString(twoSum(new int[]{2,7,11,15}, 17)));
        System.out.println(Arrays.toString(twoSum(new int[]{2,7,11,15}, 13)));
        System.out.println(Arrays.toString(twoSum(new int[]{2,7,11,15}, 22)));
    }

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])){
                return new int[]{map.get(nums[i]), i};
            }else {
                map.put(target - nums[i], i);
            }
        }
        return null;

    }
}
