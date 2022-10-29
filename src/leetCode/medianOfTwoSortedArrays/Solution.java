package leetCode.medianOfTwoSortedArrays;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2};
        int[] arr2 = new int[]{1, 6, 7};

        System.out.println(findMedianSortedArrays(arr, arr2));
        System.out.println(findMedianSortedArrays2(arr, arr2));

    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int fal = nums1.length;
        int sal = nums2.length;
        int[] result = new int[fal + sal];
        System.arraycopy(nums1, 0, result, 0, fal);
        System.arraycopy(nums2, 0, result, fal, sal);
        Arrays.sort(result);
        System.out.println(Arrays.toString(result));
        if (result.length % 2 == 0) {
            return (double) (result[result.length / 2] + result[result.length / 2 - 1]) / 2;
        } else {
            return result[result.length / 2];
        }
        //return 0.0;
    }

    public static double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int index1 = 0;
        int index2 = 0;
        int med1 = 0;
        int med2 = 0;
        for (int i = 0; i <= (nums1.length + nums2.length) / 2; i++) {
            med1 = med2;

            if (index1 == nums1.length) {
                med2 = nums2[index2];
                index2++;
            } else if (index2 == nums2.length) {
                med2 = nums1[index1];
                index1++;
            } else if (nums1[index1] < nums2[index2]) {
                med2 = nums1[index1];
                index1++;
            } else {
                med2 = nums2[index2];
                index2++;
            }
        }

        if ((nums1.length + nums2.length) % 2 == 0) {
            return (float) (med1 + med2) / 2;
        }
        return med2;
    }

}
