package Interviews;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName MeiTuan_0910_5
 * @Description
 * 题目描述：
 * 小美有一串项链，项链共由n颗宝石组成，每个宝石上都有一个数字。
 * 但是有一天项链不小心被弄断了，变成了一长串，此时可以看成一个只包含数字的字符串，
 * 于是她准备将项链从某些地方切开后再重新分成多段（每段都是原来字符串的连续子串，
 * 且不能再重新组合），因为小美特别喜欢7这个数字，所以她希望切开后每段的数字和都尽可能被7整除。
 * 例如，假设项链表示为12457，可以切分为124|5|7，第一段和第三段的和能被7整除。
 * 她想请你帮她算一算 ，切开后最多能有多少段的数字和能被7整除。
 * @Author cjx
 * @Date 2022/9/10 17:51
 * @Version 1.0
 */
public class MeiTuan_0910_5 {
    public static void main(String[] args) {
        Scanner scan= new Scanner(System.in);
        String str=scan.nextLine();
        char[] cs=str.toCharArray();
        int n=cs.length;
        int l =0,r=0;
        int[] cnt=new int[7];
        int ans=0;
        int sum=0;
        cnt[0]=1;
        while(r<n){
            sum+=cs[r]-'0';
            int model= sum%7;
            if(cnt[model]==1){
                ans++;
                cnt[model]=0;
                l=r+1;
                for (int i = 1; i < 7; i++) {
                    cnt[i]=0;
                }
                sum=0;
            }else{
                cnt[model]=1;
            }
            r++;
        }
        System.out.println(ans);
    }

}
