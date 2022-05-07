package Coding_Interviews;

import org.junit.Test;

import java.util.PriorityQueue;

/**
 * @ClassName Offer41_Median_In_Stream
 * @Description
 * @Author cjx
 * @Date 2022/5/5 15:50
 * @Version 1.0
 */
public class Offer41_Median_In_Stream {
    @Test
    public void test() {
        MedianFinder m=new MedianFinder();
        m.addNum(1);
        m.addNum(2);
        System.out.println(m.findMedian());
    }
    private class MedianFinder {
        PriorityQueue<Integer> left;
        PriorityQueue<Integer> right;

        public MedianFinder() {
            left = new PriorityQueue<>((o1, o2) -> o2 - o1);
            right = new PriorityQueue<>((o1, o2) -> o1 - o2);
        }

        public void addNum(int num) {
            if (left.isEmpty() || num < left.peek()) {
                left.add(num);
                if (left.size() > right.size() + 1) {
                    right.add(left.poll());
                }
            } else {
                right.add(num);
                if (right.size() > left.size()) {
                    left.add(right.poll());
                }
            }
        }

        public double findMedian() {
            if (left.size() > right.size()) return left.peek();
            else return (double)(left.peek() + right.peek()) / 2;
        }
    }

}
