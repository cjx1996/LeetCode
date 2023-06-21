package All_Problems;

import org.junit.Test;

import java.util.ArrayList;

/**
 * @ClassName Greatest_Sum_Divisible_by_Three_1262
 * @Description
 * @Author cjx
 * @Date 2023/6/19 22:06
 * @Version 1.0
 */
public class Greatest_Sum_Divisible_by_Three_1262 {
    @Test
    public void test() {
        int[] nums = new int[]{1,2,3,4,4};
        System.out.println(maxSumDivThree(nums));
    }
    //贪心+排序，效率低
    public int maxSumDivThree(int[] nums) {
        ArrayList<Integer> l1 = new ArrayList<>();
        ArrayList<Integer> l2 = new ArrayList<>();
        int ans = 0;
        for (int num : nums) {
            if (num % 3 == 0) ans += num;
            else if (num % 3 == 1) l1.add(num);
            else l2.add(num);
        }
        l1.sort((a, b) -> b - a);
        l2.sort((a, b) -> b - a);
        int m = l1.size(), n = l2.size();
        for (int i = 0; i < m - 3; i++) {
            ans += l1.get(i);
        }
        for (int i = 0; i < n - 3; i++) {
            ans += l2.get(i);
        }
        int tem = 0;
        int a = 0, b = 0;
        for (int i = m - 2; i <= m; i++) {
            if (i >= 0) {
                if (i > 0) a += l1.get(i - 1);
                for (int j = n - 2; j <= n; j++) {
                    if (j >= 0) {
                        if (j > 0) b += l2.get(j-1);
                        if (i % 3 == j % 3) tem = Math.max(tem, a + b);
                    }
                }
                b = 0;
            }
        }
        return ans + tem;

    }
}
