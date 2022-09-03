package Interviews;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName MeiTuan_5
 * @Description
 * @Author cjx
 * @Date 2022/8/20 11:33
 * @Version 1.0
 */
public class MeiTuan_5 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int[] needs = new int[n];
        for (int i = 0; i < n; i++) {
            needs[i] = scan.nextInt();
        }
        int[] weights = new int[m];
        for (int i = 0; i < m; i++) {
            weights[i] = scan.nextInt();
        }
        Arrays.sort(needs);
        Arrays.sort(weights);
        int ans = 0;
        int idx = 0;
        for (int i = 0; i < n; i++) {
            int need = needs[i];
            while (idx < m && weights[idx] < need) idx++;
            if (idx == m) {
                System.out.println(-1);
                return;
            }
            ans += weights[idx];
        }
        System.out.println(ans);
    }

}
