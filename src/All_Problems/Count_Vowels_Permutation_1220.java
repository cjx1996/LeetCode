package All_Problems;

/**
 * @ClassName Count_Vowels_Permutation_1220
 * @Description
 * @Author cjx
 * @Date 2022/1/17 22:03
 * @Version 1.0
 */
public class Count_Vowels_Permutation_1220 {

    public int countVowelPermutation(int n) {
        int MOD = (int) 1e9 + 7;
        //第二维度上依次表示'a'/'e'/'i'/'o'/'u'
        int[][] dp = new int[n][5];
        for (int i = 0; i < 5; i++) {
            dp[n - 1][i] = 1;
        }
        for (int i = n - 2; i >= 0; i--) {
            dp[i][0] = dp[i + 1][1];
            dp[i][1] = (dp[i + 1][0] + dp[i + 1][2]) % MOD;
            dp[i][2] = ((dp[i + 1][0] + dp[i + 1][1]) % MOD + (dp[i + 1][3] + dp[i + 1][4]) % MOD) % MOD;
            dp[i][3] = (dp[i + 1][2] + dp[i + 1][4]) % MOD;
            dp[i][4] = dp[i + 1][0];
        }
        return (((dp[0][0] + dp[0][1]) % MOD + (dp[0][2] + dp[0][3]) % MOD) % MOD + dp[0][4]) % MOD;
    }
}
