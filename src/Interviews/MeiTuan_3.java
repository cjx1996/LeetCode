package Interviews;

import java.text.DecimalFormat;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @ClassName MeiTuan_3
 * @Description
 * @Author cjx
 * @Date 2022/8/20 10:26
 * @Version 1.0
 */
public class MeiTuan_3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int[] poss = new int[n];
        for (int i = 0; i < n; i++) {
            poss[i] = scan.nextInt();
        }
        int[] points = new int[n];
        for (int i = 0; i < n; i++) {
            points[i] = scan.nextInt();
        }
        PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                double p1 = (double) (100 - o1[0]) * o1[1] / 100;
                double p2 = (double) (100 - o2[0]) * o2[1] / 100;
                return p2 > p1 ? 1 : -1;
            }
        });
        for (int i = 0; i < n; i++) {
            q.add(new int[]{poss[i], points[i]});
        }
        for (int i = 0; i < m; i++) {
            int[] cur = q.poll();
            cur[0] = 100;
            q.add(cur);
        }
        double ans = 0;
        for (int i = 0; i < n; i++) {
            int[] cur = q.poll();
            ans += (double) cur[0] * cur[1] / 100;
        }
        DecimalFormat df = new DecimalFormat("0.00");
        System.out.println(df.format(ans));
    }

}
