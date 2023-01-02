package All_Problems;

import org.junit.Test;

/**
 * @ClassName Largest_Sum_of_Averages_813
 * @Description
 * @Author cjx
 * @Date 2022/11/28 18:26
 * @Version 1.0
 */
public class Largest_Sum_of_Averages_813 {
    @Test
    public void test(){

    }
    public double largestSumOfAverages(int[] nums,int k){

        int n = nums.length;
        double[] prefix=new double[n+1];
        for (int i = 0; i < n ; i++) {
            prefix[i+1]=nums[i]+prefix[i];
        }
        double[][] dp=new double[n+1][k+1];
        for (int i = 1; i < n + 1; i++) {
            dp[i][1]=prefix[i]/i;
        }
        for(int j=2;j<=k;j++){
            for (int i = j; i <= n; i++) {
                for(int x=j-1;x<i;x++){
                    dp[i][j]=Math.max(dp[i][j],dp[x][j-1]+(prefix[i]-prefix[x])/(i-x));
                }
            }
        }
        return dp[n][k];
    }
/*

    public double largestSumOfAverages(int[] nums,int k){
        int n = nums.length;
        double[] prefix=new double[n+1];
        for (int i = 0; i < n ; i++) {
            prefix[i+1]=nums[i]+prefix[i];
        }
        double[][] dp=new double[n+1][k+1];
        for (int i = 1; i < n + 1; i++) {
            dp[i][1]=prefix[i]/i;
        }
        for(int j=2;j<=k;j++){
            for (int i = j; i <= n; i++) {
                for(int x=j-1;x<i;x++){
                    dp[i][j]=Math.max(dp[i][j],dp[x][j-1]+(prefix[i]-prefix[x])/(i-x));
                }
            }
        }
        return dp[n][k];
    }

*/
}
