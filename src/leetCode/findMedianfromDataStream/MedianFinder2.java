package leetCode.findMedianfromDataStream;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class MedianFinder2 {

    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    public static void main(String[] args) {
        MedianFinder2 mf = new MedianFinder2();
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
    }

    public MedianFinder2() {

    }

    public void addNum(int num) {
        if (size() == 0 || num >= minHeap.peek()) {
            minHeap.add(num);
        } else {
            maxHeap.add(-num);
        }

        if (maxHeap.size() == minHeap.size() + 2) {
            minHeap.add(-maxHeap.remove());
        } else if (maxHeap.size() + 2 == minHeap.size()) {
            maxHeap.add(-minHeap.remove());
        }
    }

    public double findMedian() {
        if (maxHeap.size() == minHeap.size()) {
            return ((double) minHeap.peek() - (double) maxHeap.peek()) / 2;
        } else {
            if (maxHeap.size() > minHeap.size()) {
                return -maxHeap.peek();
            } else {
                return minHeap.peek();
            }
        }
    }

    private int size() {
        return maxHeap.size() + minHeap.size();
    }


}
