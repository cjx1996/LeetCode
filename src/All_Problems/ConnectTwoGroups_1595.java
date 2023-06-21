package All_Problems;

import java.util.Arrays;
import java.util.List;

/**
 * @ClassName ConnectTwoGroups_1595
 * @Description
 * @Author cjx
 * @Date 2023/6/20 23:27
 * @Version 1.0
 */
public class ConnectTwoGroups_1595 {
    public int connectTwoGroups(List<List<Integer>> cost){
        int m=cost.size(),n=cost.get(0).size();
        int[][] dp=new int[m+1][1<<n];
        for (int i = 0; i <= m; i++) {
            Arrays.fill(dp[i],Integer.MAX_VALUE/2);
        }
        dp[0][0]=0;
        for (int i = 1; i <= m; i++) {
            for (int j = 0; j < (1 << n); j++) {
                for (int k = 0; k < n; k++) {
                   if((j&1<<k)==0)  continue;
                   dp[i][j]=Math.min(dp[i][j],dp[i-1][j]+cost.get(i-1).get(k));
                   dp[i][j]=Math.min(dp[i][j],dp[i][j^(1<<k)]+cost.get(i-1).get(k));
                   dp[i][j]=Math.min(dp[i][j],dp[i-1][j^(1<<k)]+cost.get(i-1).get(k));
                }
            }
        }
        return dp[m][(1<<n)-1];
    }

}
