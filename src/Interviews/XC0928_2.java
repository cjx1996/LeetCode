package Interviews;


import java.util.Scanner;

/**
 * @ClassName XC0928_2
 * @Description
 * @Author cjx
 * @Date 2022/9/28 19:47
 * @Version 1.0
 */
public class XC0928_2 {
    public static void main(String[] args) {
        Scanner scan= new Scanner(System.in);
        int n = scan.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println(can(scan.nextLong()));
        }
    }


    static int can(long num){
        if(num%233!=0) return -1;
        long div=num/233;
        int cnt=0;
        while(div!=0){
            cnt+=div%10;
            div/=10;
        }
        return cnt;
    }

}
