package Interviews;

import java.util.Scanner;

/**
 * @ClassName MeiTuan_0910_1
 * @Description
 * @Author cjx
 * @Date 2022/9/10 16:26
 * @Version 1.0
 */
public class MeiTuan_0910_1 {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int T=scan.nextInt();
        int[][] nums=new int[T][4];
        for (int i = 0; i < T; i++) {
            for (int j = 0; j < 4; j++) {
                nums[i][j]= scan.nextInt();
            }
        }
        String[] res=new String[T];
        for (int i = 0; i < T; i++) {
            int n =nums[i][0];
            int x=nums[i][1];
            int y=nums[i][2];
            int k=nums[i][3];
            if(((long)k*y)<((long)x*(n-k+1))){
                res[i]="Win";
            }else if(((long)k*y)>((long)x*(n-k+1))) {
                res[i]="Lose";
            }else {
                res[i]="Tie";
            }
            System.out.println(res[i]);
        }
    }

}
