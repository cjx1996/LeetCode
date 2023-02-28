package All_Problems;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName MinimumTotal_120
 * @Description
 * @Author cjx
 * @Date 2023/1/14 16:46
 * @Version 1.0
 */
public class MinimumTotal_120 {
    @Test
    public void test() {
        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> row = new ArrayList<>();
        row.add(2);
        triangle.add(row);
        row=new ArrayList<>();
        row.add(3);
        row.add(4);
        triangle.add(row);
        row=new ArrayList<>();
        row.add(6);
        row.add(5);
        row.add(7);
        triangle.add(row);
        row=new ArrayList<>();
        row.add(4);
        row.add(1);
        row.add(8);
        row.add(3);
        triangle.add(row);
        System.out.println(minimumTotal(triangle));
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }
        dp[0][0]=triangle.get(0).get(0);
        for (int i = 0; i <n-1; i++) {
            List<Integer> row = triangle.get(i+1);
            for (int j = 0; j <= i; j++) {
                dp[i+1][j]=Math.min(dp[i+1][j],dp[i][j]+row.get(j));
                dp[i+1][j+1]=Math.min(dp[i+1][j+1],dp[i][j]+row.get(j+1));
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            ans = Math.min(ans, dp[n-1][i]);
        }
        return ans;
    }

}
