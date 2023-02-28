package Contest;

import org.junit.Test;

import java.util.Arrays;

/**
 * @ClassName SquarFreeSubsets_6364
 * @Description
 * @Author cjx
 * @Date 2023/2/19 18:11
 * @Version 1.0
 */
public class SquareFreeSubsets_6364 {
    @Test
    public void test() {
        int[] nums = new int[]{3, 4, 4, 5};
        System.out.println(squareFreeSubsets(nums));
    }

    public int squareFreeSubsets(int[] nums) {
        int M=1<<10;
        int[] dp=new int[M];
        int[] masks=new int[]{-1,0,1,2,-1,4,3,8,-1,-1,5,16,-1,32,9,6,-1,64,-1,128,-1,10,17,256,-1,-1,33,-1,-1,512,7};
        dp[0]=1;
        int MOD=(int)1e9+7;
        int n =nums.length;
        for (int i = 0; i < n; i++) {
            int num=nums[i];
            int mask=masks[num];
            if(mask<0) continue;
            for(int j=M-1;j>=0;j--){
                if((j|mask)==j){
                    dp[j]+=dp[j^mask];
                    dp[j]%=MOD;
                }
            }
        }
        int ans=0;
        for(int k:dp){
            ans+=k;
            ans%=MOD;
        }
        return (ans-1+MOD)%MOD;
    }
/*
//这里是比较笨的动态规划的写法
    int MOD = (int) 1e9 + 7;
    public int squareFreeSubsets(int[] nums) {
        int[] primes = new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29};
        int m = primes.length;
        int n = nums.length;
        long[][] dp = new long[n + 1][1 << m];
        dp[0][0]=1;
        int[] check = new int[31];
        for (int i = 2; i < 31; i++) {
            int j = 2;
            for (int k = 0; k < m; k++) {
                if(i%primes[k]==0){
                    if(i%(primes[k]*primes[k])==0){
                        check[i]=-1;
                        break;
                    }
                    check[i]|=1<<k;
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            int num = nums[i - 1];
            for (int j = 0; j < 1 << m; j++) {
                dp[i][j] = dp[i - 1][j];
            }
            if (check[num]==-1) continue;
            int mask = check[num];
            for (int j = 0; j < 1 << m; j++) {
                if ((j & mask) == 0) {
                    dp[i][j | mask] = (dp[i][j | mask] + dp[i - 1][j]) % MOD;
                }
            }
        }
        long ans = 0;
        for (int i = 0; i < 1 << m; i++) {
            ans = (ans + dp[n][i]) % MOD;
        }
        ans = (ans - 1 + MOD) % MOD;
        return (int) ans;

    }
*/

}
