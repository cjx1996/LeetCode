package Interviews;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName MeiTuan_0903_4
 * @Description 9.3号面试题，当时a了60+。后来检查发现漏掉了信息，第一天必须从k城市出发也就是说，dp递推过程中需要考虑能不能从该城市出发的问题。在本程序中， 如果dp[i][j]的收益为-1，那么表明不可能在第j天处于第i个城市
 * @Author cjx
 * @Date 2022/9/3 11:22
 * @Version 1.0
 */
public class MeiTuan_0903_4 {
    public static void main(String[] args) {
        Scanner  scan= new Scanner(System.in);
        int n = scan.nextInt(),m= scan.nextInt(),k=scan.nextInt();
        int[] ci=new int[m+1],ai=new int[m+1],bi=new int[m+1];
        for (int i = 0; i < m; i++) {
            ci[i+1]=scan.nextInt();
        }
        for (int i = 0; i < m; i++) {
            ai[i+1]=scan.nextInt();
        }
        for (int i = 0; i < m; i++) {
            bi[i+1]=scan.nextInt();
        }
        int[][] dp= new int[n+1][m+1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i],-1);
        }
        if(k==ci[1]){
            dp[ci[1]][1]=ai[1];
        }else{
            dp[ci[1]][1]=bi[1];
        }
        for(int j =2;j<=m;j++){
            int max=-1;
            for (int i = 1; i <= n; i++) {
                if(i!=ci[j]&&dp[i][j-1]<0) {
                    dp[i][j]=dp[i][j-1];
                    max=Math.max(max,dp[i][j]);
                }
            }
            int cur=ci[j];
            if(dp[cur][j-1]!=-1) dp[cur][j]=Math.max(dp[cur][j-1]+ai[j],dp[cur][j]);
            if(max!=-1) dp[cur][j]=Math.max(dp[cur][j],max+bi[j]);

        }
        int ans=0;
        for (int i = 0; i <= n; i++) {
            ans= Math.max(ans,dp[i][m]);
        }
        System.out.println(ans);
    }
}
