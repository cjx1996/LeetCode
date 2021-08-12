import org.junit.Test;

import java.util.concurrent.ForkJoinPool;

/**
 * @ClassName Longest_Common_Subsequence_1143
 * @Description
 * @Author cjx
 * @Date 2021/7/26 17:38
 * @Version 1.0
 */
public class Longest_Common_Subsequence_1143 {
    @Test
    public void test(){
        String text1 = "47623861";
        String text2 = "648132";
        System.out.println(longestCommonSubsequence(text1,text2));
    }
    public int longestCommonSubsequence(String text1,String text2){
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m+1][n+1];
        for (int i = 0; i <=m; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i <= n; i++) {
            dp[0][i]=0;
        }
        for (int i = 1; i <= m; i++){
            for (int j = 1; j <= n; j++) {
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[i][j] = 1+dp[i-1][j-1];
                }else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }
}
