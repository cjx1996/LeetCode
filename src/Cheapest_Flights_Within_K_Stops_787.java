import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * @ClassName Cheapest_Flights_Within_K_Stops_787
 * @Description
 * @Author cjx
 * @Date 2021/8/24 10:17
 * @Version 1.0
 */
public class Cheapest_Flights_Within_K_Stops_787 {
    @Test
    public void test() {

    }


    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int INF = 10000 * 101 + 1;
        int[][] dp = new int[k + 2][n];
        for (int i = 0; i < k + 2; i++) {
            Arrays.fill(dp[i], INF);
        }
        dp[0][src] =0;
        for (int i = 0; i < k + 1; i++) {
            for (int[] flight : flights) {
                int s = flight[0],d=flight[1],price =flight[2];
                dp[i+1][d]=Math.min(dp[i+1][d],dp[i][s]+price);
            }
        }
        int ans = INF;
        for (int i = 0; i < k+2; i++) {
            ans=Math.min(ans,dp[i][dst]);
        }
        return ans==INF?-1:ans;
    }


}
