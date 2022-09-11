package Interviews;

import java.util.Scanner;

/**
 * @ClassName MeiTuan_0910_2
 * @Description
 * @Author cjx
 * @Date 2022/9/10 16:30
 * @Version 1.0
 */
public class MeiTuan_0910_2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int ans = 0;
        int n = scan.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scan.nextInt();
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (nums[i] == 0) {
                ans++;
                sum++;
            }
        }
        if(sum==0) ans++;
        System.out.println(ans);
    }

}
