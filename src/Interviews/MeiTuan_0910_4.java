package Interviews;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName MeiTuan_0910_4
 * @Description 当时没做出来，事后看别人的语句，会了。时间复杂度O(10*m)+O(n)
 * @Author cjx
 * @Date 2022/9/10 16:57
 * @Version 1.0
 */
public class MeiTuan_0910_4 {

    public static void main(String[] args) {
        Scanner scan= new Scanner(System.in);
        int n=scan.nextInt();
        int m =scan.nextInt();
        int[] nums=new int[n];
        for (int i = 0; i < n; i++) {
            nums[i]=scan.nextInt();
        }
        int[] models=new int[10];
        models[0]=1;
        for (int  j = 1; j < 10; j++) {
            models[j]=models[j-1]*10;
        }
        int[] dp=new int[m];
        Arrays.fill(dp, m);
        dp[0]=0;
        ArrayDeque<Integer> q=new ArrayDeque<>();
        q.push(0);
        while(!q.isEmpty()){
            int cur=q.poll();
            for (int i = 0; i < 10; i++) {
                //这里有一个规律:对于dp[cur]=k，那么我们知道如果((next+models[i])%m=cur),那么dp[next]=dp[cur]+1;
                //因此反推对于确定的cur和models[i]，可以得到next=((cur-models[i])%m+m)%m
                int next=((cur-models[i])%m+m)%m;
                if(dp[next]==m){
                    dp[next]=dp[cur]+1;
                    q.push(next);
                }
            }
        }
        int[] ans=new int[n];
        for (int i = 0; i < n; i++) {
            ans[i]=dp[nums[i]];
            System.out.print(ans[i]);
            if(i!=n-1) System.out.print(" ");
        }
    }

}
