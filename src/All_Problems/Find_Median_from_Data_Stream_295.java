package All_Problems;

import org.junit.Test;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @ClassName Find_Median_from_Data_Stream_295
 * @Description
 * @Author cjx
 * @Date 2021/8/27 22:57
 * @Version 1.0
 */
public class Find_Median_from_Data_Stream_295 {
    @Test
    public void test() {
        System.out.println((double) (1 + 2) / 2);
    }

}

class MedianFinder {
    /**
     * initialize your data structure here.
     */
    PriorityQueue<Integer> max;
    PriorityQueue<Integer> min;

    public MedianFinder() {

        max = new PriorityQueue<Integer>((a, b) -> (a - b));
        min = new PriorityQueue<Integer>((a, b) -> (b - a));
    }

    public void addNum(int num) {
        if (min.isEmpty() || num <= min.peek()) {
            min.offer(num);
            if (max.size() + 1 < min.size()) {
                max.offer(min.poll());
            }
        } else {
            max.offer(num);
            if (max.size() > min.size()) {
                min.offer(max.poll());
            }
        }
    }

    public double findMedian() {
        if (min.size() > max.size()) {
            return min.peek();
        } else {
            return (min.peek() + max.peek()) / 2.0;
        }
    }
/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
}
