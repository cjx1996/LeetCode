import org.junit.Test;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/**
 * @ClassName Super_Ugly_Number_313
 * @Description
 * @Author cjx
 * @Date 2021/8/9 10:52
 * @Version 1.0
 */
public class Super_Ugly_Number_313 {
    @Test
    public void test() {
        int[] primes = new int[]{2,3,7,17,23,31,41,43,47};
        System.out.println(nthSuperUglyNumber(45, primes));
    }

    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] ans = new int[n];
        ans[0] = 1;
        //每个prime当前指针指向的索引
        int[] pointer = new int[primes.length];
        //定义第i小的数
        for (int i = 1; i < n; i++) {
            //定义本轮循环最小的数
            int min = Integer.MAX_VALUE, index = 0;
            //对每个质数轮询，找出质数*当前指针指向的数的积的最小值
            for (int i1 = 0; i1 < primes.length; i1++) {
                //当前质数乘以指向的指针指向的数的积
                int curr = primes[i1] * ans[pointer[i1]];
                //如果当前位不为0，且得到的积等于上一位的值，说明出现重复结果，将当前质数的指针后移并继续循环
                if (curr == min) {
                    pointer[i1]++;
                    continue;
                }
                //如果已知的最小值比当前值小，那么更新最小值，并记录对应质数的索引
                if (curr < min) {
                    min = curr;
                    index = i1;
                }
            }
            ans[i] = min;
            pointer[index]++;
        }
        return ans[n - 1];
    }

    //使用了最小堆，时间复杂度过高，O(mnlogmn)
    public int nthSuperUglyNumber1(int n, int[] primes) {
        Queue<Integer> heap = new PriorityQueue<>((a, b) -> a - b);
        heap.add(1);
        Set<Integer> set = new HashSet<>();
        set.add(1);
        for (int i = 0; i < n - 1; i++) {
            Integer min = heap.poll();
            int len = primes.length;
            for (int j = 0; j < len; j++) {
                if (set.add(min * primes[j])) {
                    heap.add(min * primes[j]);

                }
            }
        }
        return heap.poll();
    }
}
