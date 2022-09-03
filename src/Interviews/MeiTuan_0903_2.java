package Interviews;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName MeiTuan_0903_2
 * @Description
 * @Author cjx
 * @Date 2022/9/3 10:09
 * @Version 1.0
 */
public class MeiTuan_0903_2 {
    public static void main(String[] args) {
        Scanner scan= new Scanner(System.in);
        int n = scan.nextInt();
        int[] nums=new int[n];
        for (int i = 0; i < n; i++) {
            nums[i]=scan.nextInt();
        }
        int[] sorted= Arrays.copyOf(nums,n);
        Arrays.sort(sorted);
        int cur=n;
        for (int i = 0; i < n; i++) {
            if(sorted[i]!=i) {
                cur=i;
                break;
            }
        }
        for (int i = 0; i < n; i++) {
            int num =nums[i];
            if(num<cur){
                System.out.print(num+" ");
            }else
                System.out.print(cur+" ");
        }

    }

}
