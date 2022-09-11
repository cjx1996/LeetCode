package Interviews;

import org.junit.Test;

import java.util.*;

/**
 * @ClassName MinFee
 * @Description TODO 看完下面链接的讲解
 * https://leetcode.cn/problems/cheapest-flights-within-k-stops/solution/gong-shui-san-xie-xiang-jie-bellman-ford-dc94/
 * @Author cjx
 * @Date 2022/9/4 16:33
 * @Version 1.0
 */
public class MinFee {


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt(), m = scan.nextInt(), k = scan.nextInt();
        int[] p1 = new int[m];
        int[] p2 = new int[m];
        int[] fee = new int[m];
        for (int i = 0; i < m; i++) {
            p1[i] = scan.nextInt();
        }
        for (int i = 0; i < m; i++) {
            p2[i] = scan.nextInt();
        }
        for (int i = 0; i < m; i++) {
            fee[i] = scan.nextInt();
        }
        int[] dis = new int[n + 1];
        Arrays.fill(dis, -1);
        dis[1] = 0;
        for (int limit = 0; limit < k; limit++) {
            int[] clone = dis.clone();
            for (int i = 0; i < m; i++) {
                int x = p1[i], y = p2[i], w = fee[i];
                for (int j = 0; j < 2; j++) {
                    if (j == 1) {
                        x ^= y;
                        y ^= x;
                        x ^= y;
                    }
                    if (clone[y] != -1) {
                        if (dis[x] != -1) dis[x] = Math.min(dis[x], Math.max(clone[y], w));
                        else dis[x] = Math.max(clone[y], w);
                    }
                }
            }
        }
        System.out.println(dis[n]);

    }


}
