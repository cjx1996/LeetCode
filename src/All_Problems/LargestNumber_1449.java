package All_Problems;

/**
 * @ClassName LargestNumber_1449
 * @Description TODO 未解决
 * @Author cjx
 * @Date 2021/6/12 23:55
 * @Version 1.0
 */
public class LargestNumber_1449 {
    public String largestNumber(int[] cost, int target) {
        int len = cost.length;
        int[] nums = new int[len + 1];
        for (int i = 0; i < len; i++) {
            nums[i + 1] = cost[i];
        }
        len++;
        String[][] dp = new String[len + 1][target + 1];
        for (int i = 0; i < target + 1; i++) {
            int num = i;
            if (num % nums[1] == 0) {
                num = num / nums[1];
                while (num > 0) {
                    dp[1][i] += nums[1];
                    num--;
                }
            }
        }
        return null;

    }
}
