package leetCode.findMedianfromDataStream;

import java.util.ArrayList;

public class MedianFinder {

    private ArrayList<Integer> nums = new ArrayList();

    public static void main(String[] args) {
        MedianFinder mf = new MedianFinder();
        mf.addNum(6);
        mf.addNum(10);
        mf.addNum(2);
        mf.addNum(6);
        mf.addNum(5);
        mf.addNum(0);
        mf.addNum(6);
        mf.addNum(3);
        mf.addNum(1);
        mf.addNum(0);
        mf.addNum(0);
        System.out.println(mf.findMedian());
        //mf.addNum(3);
        //System.out.println(mf.findMedian());


        //System.out.println(4/2);
    }

    public MedianFinder() {

    }

    public void addNum(int num) {
        int start = 0;
        int end = nums.size() - 1;
        while (start <= end){
            int mid = (start + end) / 2;
            if(nums.get(mid) == num){
                nums.add(mid, num);
                return;
            }else if(nums.get(mid) < num){
                start = mid + 1;
            }else {
                end = mid - 1;
            }
        }
        nums.add(end + 1, num);
    }

    public double findMedian() {
        if(nums.size() % 2 == 0){
            return ((double) (nums.get(nums.size() / 2) + (nums.get((nums.size() / 2) - 1))) / 2);
        }else{
            return (double)nums.get(nums.size() / 2);
        }
    }


}
