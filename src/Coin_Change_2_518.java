import org.junit.Test;

/**
 * @ClassName Coin_Change_2_518
 * @Description
 * @Author cjx
 * @Date 2021/6/10 17:46
 * @Version 1.0
 */
public class Coin_Change_2_518 {
    @Test
    public void test(){
        int[] coins = new int[]{1,2,5};
        System.out.println(change(5, coins));
    }
    public int change(int amount, int[] coins){
        int len = coins.length;


        int[][] dp = new int[len+1][amount+1];
        //初始化dp数组
        dp[0][0] =1;
        for (int i = 1; i < amount+1; i++) {
            dp[0][i] =0;
        }

        //状态转移方程
        for (int i = 1; i < len+1; i++) {
            int coin = coins[i-1];
            for(int j = 0;j<amount+1;j++){
                dp[i][j] = dp[i-1][j];
                if(coin<=j){
                    dp[i][j] += dp[i][j-coin];
                    }
                }
            }

        return dp[len][amount];


    /*    int[] dp = new int[amount+1];
        dp[0] =1;
        for (int coin : coins) {
            for(int j = coin;j<=amount;j++){
                dp[j] +=dp[j-coin];
            }
        }
        return dp[amount];*/



    }

    public int change1(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }


}
