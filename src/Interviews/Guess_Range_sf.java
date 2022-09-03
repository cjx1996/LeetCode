package Interviews;

import org.junit.Test;

import java.util.Scanner;

/**
 * @ClassName Guess_Range_df
 * @Description
 * 给定一个范围在1~n的排列，每次询问可以询问某个位置的数是大了还是小了还是正确，问最坏要问多少次才能得到n次都是正确
 * @Author cjx
 * @Date 2022/8/31 16:52
 * @Version 1.0
 */
public class Guess_Range_sf {

    public static void main(String[] args) {
        Scanner scan =new Scanner(System.in);
        int n =scan.nextInt();
        int ans=0;
        int num =1;
        int pow=0;
        for (int i = 1; i <=n; i++) {
            if(i==num){
                num*=2;
                pow++;
            }
            ans+=pow;
        }
        System.out.println(ans);
    }
}
