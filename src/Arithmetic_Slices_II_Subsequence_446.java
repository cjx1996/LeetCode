import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName Arithmetic_Slices_II_Subsequence_446
 * @Description 对每一个有用解都要理解为是在弱等差数列的基础上添加新的尾项后形成的，而对于每一个(nums[i],nums[j])都理解为是弱等差数列的最后两项，因此存在f[i][d]+=f[j][d]+1，这就是动态规划的状态转移方程
 * 对于本题使用动态规划而言，如何写出状态转移方程是重点。在这里通过变量d=nums[i]-nums[j]，这一维度将前后联系起来，得到状态转移方程
 * @Author cjx
 * @Date 2021/8/11 10:40
 * @Version 1.0
 */
public class Arithmetic_Slices_II_Subsequence_446 {
    @Test
    public void test() {
        int[] nums = new int[]{1, 1, 1, 1, 1};
        System.out.println(numberOfArithmeticSlices(nums));
    }

    public int numberOfArithmeticSlices(int[] nums) {
        //记录每个数值出现的索引列表
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.putIfAbsent(nums[i], new ArrayList<>());
            ArrayList<Integer> list = map.get(nums[i]);
            list.add(i);
        }

        //创建dp数组，dp[j][i]表示以nums[j]、nums[i]结尾的子序列数量
        int len = nums.length;
        int[][] dp = new int[len][len];
        int ans = 0;
        //对每个i依次遍历所有j<i，搜索是否存在符合的k,满足nums[k]、nums[j]、nums[i]等差并且k<j
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                int num1 = nums[j];
                int num2 = nums[i];
                //求出符合条件的nums[k]的数值
                long num3 = 2L * num1 - num2;
                if (num3 > Integer.MAX_VALUE || num3 < Integer.MIN_VALUE) continue;
                if (map.containsKey((int)num3)) {
                    ArrayList<Integer> index = map.get((int)num3);
                    for (int k : index) {
                        if (k < j) {
                            //在数组上从前往后搜索；在dp数组上按列从前往后求取
                            dp[j][i] += dp[k][j] + 1;
                        }
                    }
                }

                //累加获得ans
                ans += dp[j][i];
            }
        }
        return ans;


    }

    public int numberOfArithmeticSlices1(int[] nums) {
        int n = nums.length;
        //等价于dp[i][j],i维度是数的数目，j的维度是当前数和前面的数的差d,每个dp[i][j]得到的是下标不超过i的数，在差值为d时能够形成的长度>=2的子序列数量
        Map<Long, Integer>[] map = new Map[n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            map[i] = new HashMap<>();
            //对每个数nums[i]，依次遍历前面的数nums[j]，形成数对(nums[j],nums[i])，j<i
            for (int j = 0; j < i; j++) {
                //计算差值d，作为哈希的key
                Long d = 1L * nums[i] - nums[j];
                //得到在数nums[j]处的状态值
                int cnt = map[j].getOrDefault(d, 0);
                //此处计算所有ans，也可以计算完dp后，求和-长度为2的序列的数量
                ans += cnt;
                //状态转移方程 dp[i][d]+=dp[j][d]+1;
                map[i].put(d, map[i].getOrDefault(d, 0) + cnt + 1);
            }
        }
        return ans;
    }
}
