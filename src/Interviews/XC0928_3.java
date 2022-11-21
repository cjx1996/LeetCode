package Interviews;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName XC0928_3
 * @Description 前缀和问题，笔试时候没想出来，后面考虑到了
 * @Author cjx
 * @Date 2022/9/28 19:11
 * @Version 1.0
 */
public class XC0928_3 {
    public static void main(String[] args) {
        Scanner scan= new Scanner(System.in);
        int n=scan.nextInt();
        int k=scan.nextInt();
        int[] arr=new int[n];
        for (int i = 0; i < n; i++) {
            arr[i]=scan.nextInt();
        }
        Arrays.sort(arr);
        if(n==k) {
            System.out.println(0);
            return;
        }else if(k==1) {
            System.out.println(arr[n-1]-arr[0]);
            return;
        }
        int[] sum=new int[n+5];
        for (int i = 1; i <= n; i++) {
            sum[i]=sum[i-1]+arr[i-1];
        }
        double ans=Integer.MAX_VALUE;
        for (int i = 0; i <=k; i++) {
            double min=arr[i],max=arr[i+n-k-1];
            double equal =((double)sum[n]-sum[i+n-k]+sum[i])/k;
            min=Math.min(min,equal);
            max=Math.max(max,equal);
            ans=Math.min(ans,max-min);
        }
        System.out.println(ans);

    }

}
