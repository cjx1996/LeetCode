package All_Problems;

import java.util.Arrays;

/**
 * @ClassName Edit_Distance_72
 * @Description
 * @Author cjx
 * @Date 2022/11/24 19:15
 * @Version 1.0
 */
public class Edit_Distance_72 {
    public int minDistance(String word1,String word2){
        int m = word1.length(),n=word2.length();
        if(m==0||n==0) return Math.max(m,n);
        int[][] dp=new int[m+1][n+1];
        for (int i = 0; i <=m; i++) {
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }
        for (int i = 0; i <= m; i++) {
            dp[i][0]=i;
        }
        for (int i = 0; i <= n; i++) {
            dp[0][i]=i;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char c1=word1.charAt(i-1),c2=word2.charAt(j-1);
                if(i>0&&j>0) {
                    if(c1!=c2)dp[i][j]=Math.min(dp[i][j],dp[i-1][j-1]+1);
                    else dp[i][j]=Math.min(dp[i][j],dp[i-1][j-1]);
                }
                if(i>0) dp[i][j]=Math.min(dp[i][j],dp[i-1][j]+1);
                if(j>0) dp[i][j]=Math.min(dp[i][j],dp[i][j-1]+1);
            }
        }
        return dp[m-1][n-1];
    }

}
