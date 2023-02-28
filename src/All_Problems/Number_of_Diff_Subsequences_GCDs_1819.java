package All_Problems;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @ClassName Number_of_Diff_Subsequences_GCDs_1819
 * @Description
 * @Author cjx
 * @Date 2023/1/14 11:57
 * @Version 1.0
 */
public class Number_of_Diff_Subsequences_GCDs_1819 {
    @Test
    public void test() {
        int[] nums = new int[]{1, 9, 14, 15, 20};
        System.out.println(countDifferentSubsequenceGCDs(nums));
    }

    public int countDifferentSubsequenceGCDs(int[] nums) {
        int ans = 0;
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        boolean[] occur=new boolean[max+1];
        for(int num:nums){
            occur[num]=true;
        }
        for (int i = 1; i <= max; i++) {
            int cur = 0;
            for (int j = 1; j * i <= max; j++) {
                if (occur[i*j]) {
                    cur = gcd(cur, i * j);
                    if (cur == i) {
                        ans++;
                        break;
                    }
                }
            }
        }
        return ans;
    }

    int gcd(int a, int b) {
        if (a < b) return gcd(b, a);
        if (b == 0) return a;
        return gcd(b, a % b);
    }


}
