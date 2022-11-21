package Interviews;

import org.junit.Test;

import java.util.Scanner;

/**
 * @ClassName XC0928_4
 * @Description
 * @Author cjx
 * @Date 2022/9/28 20:15
 * @Version 1.0
 */
public class XC0928_4 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=Integer.valueOf(sc.nextLine());
        for (int i = 0; i < t; i++) {
            String[] s1=sc.nextLine().split(" ");
            String[] s2=sc.nextLine().split(" ");
            int n= Integer.valueOf(s1[0]);
            int k=Integer.valueOf(s1[1]);
            int x=Integer.valueOf(s1[2]);
            int[] arr=new int[n];
            for (int j = 0; j < n; j++) {
                arr[j]=Integer.valueOf(s2[j]);
            }
            System.out.println(maxOps(n,k,x,arr));
        }
    }

    static int maxOps(int n,int k,int x,int[] arr){
        int[][] cnt=new int[k][2];
        for (int i = 0; i < n; i++) {
            cnt[i%k][0]=Math.max(cnt[i%k][0],arr[i]);
            cnt[i%k][1]++;
        }
        int must=0;
        for (int i = 0; i < n; i++) {
            must+=cnt[i%k][0]-arr[i];
        }
        if(must>x) return -1;
        int max=arr[0];
        int more=x-must;
        for (int i = 0; i < k; i++) {
            max=Math.max(max,cnt[i][0]+more/cnt[i][1]);
        }
        return max;
    }

}
