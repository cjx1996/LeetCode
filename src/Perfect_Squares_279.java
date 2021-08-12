import org.junit.Test;

/**
 * @ClassName Perfect_Squares_279
 * @Description
 * @Author cjx
 * @Date 2021/6/11 18:45
 * @Version 1.0
 */
public class Perfect_Squares_279 {
    @Test
    public void test(){
        System.out.println(numSquares(13));
    }
    public int numSquares(int n ){
        int sqrt = (int)Math.sqrt(n);

        /*
        int[][] dp = new int[sqrt+1][n+1];
        for (int i = 0; i < n + 1; i++) {
            dp[1][i] = i;
        }
        for (int i = 2; i <=sqrt; i++) {
            int currNum = (i)*(i);
            for(int j = 0;j<=n;j++){
                dp[i][j] = dp[i-1][j];
                if(currNum<=j){
                    dp[i][j] = Math.min(dp[i-1][j],dp[i][j-currNum]+1);
                }
            }

        }
          return dp[sqrt][n];
        */

        int[] dp = new int[n+1];

        for (int i = 0; i < n + 1; i++) {
            dp[i] = i;
        }

        for (int i = 2; i <=sqrt ; i++) {
            int currNum = i*i;
            for(int j =0;j<=n;j++){
                if(currNum<=j){
                    dp[j] = Math.min(dp[j],dp[j-currNum]+1);
                }
            }

        }
        return dp[n];


    }
}
