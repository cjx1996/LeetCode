import org.junit.Test;

import java.util.*;

/**
 * @ClassName test
 * @Description
 * @Author cjx
 * @Date 2021/7/14 17:24
 * @Version 1.0
 */
public class test {
    @Test
    /**
     * 对于数组，对于具体数据的访问与存储可以将其看做对象来考虑
     */
    public void test1() {
        int[] nums1 = new int[]{1, 2, 4};
        int[] nums2 = nums1;
        nums1[0] = 8;
        for (int num : nums2) {
            System.out.println(num);
        }
    }

    @Test
    public void test2() {
        Set<List<Integer>> set = new HashSet<>();
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        List<Integer> list2 = new ArrayList<>();
        list2.add(2);
        list2.add(1);
        set.add(list1);

        set.add(list2);
        System.out.println(set);
    }

    @Test
    public void test3() {
        List<Integer> list = new ArrayList<>();
        System.out.println(list.getClass());
    }

    @Test
    public void test4() {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        list.add(0, 2);
        System.out.println(list);
    }

    @Test
    //java中的%符号表示取余运算，即除法的商向0靠拢
    public void test5(
    ) {
        int a = -7 % 3;
        System.out.println(a);
    }

    @Test
    public void test() {
        int[] piles = new int[]{5, 4, 9};
        int k = 2;
        System.out.println(minStoneSum(piles, k));
    }

    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) ->b-a);
        int n = piles.length;
        for (int i = 0; i < n; i++) {
            queue.offer(piles[i]);
        }
        for (int i = 0; i < k; i++) {

            int sub = queue.peek() >> 1;
            queue.offer(queue.poll() - sub);
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += queue.poll();
        }
        return sum;

    }


}
