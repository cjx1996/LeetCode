package nowcoderProblems;

import java.util.Arrays;
import java.util.Scanner;

/**
 * HJ16 购物单
 *
 * @Description 动态规划类问题
 */
public class ShoppingList {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = 0, m = 0;

        N = in.nextInt();//数值最大值
        m = in.nextInt();//物品总件数

        Good[] gs = new Good[m + 1];
        for(int i=0;i<=m;i++) gs[i]=new Good();
        for (int i = 1; i < m + 1; i++) {
            int v = in.nextInt();//商品价格
            int p = in.nextInt();//商品重要度
            int q = in.nextInt();//商品是否是附件。=0表示为主件，大于0 表示为副件
            gs[i].update(v, p * v, q);
            if (q > 0) {
                gs[q].set(i);
            }
        }
        int[][] dp = new int[m + 1][N + 1];
        for (int i = 1; i < m + 1; i++) {
            if (gs[i].q > 0) {
                dp[i] = dp[i - 1];
                continue;
            }
            Good g = gs[i];
            for (int j = 1; j < N + 1; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= g.v) dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - g.v] + g.p);
                if (g.a1 >= 0 && j >= g.v + gs[g.a1].v)
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - g.v - gs[g.a1].v] + g.p + gs[g.a1].p);
                if (g.a2 >= 0 && j >= g.v + gs[g.a2].v)
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - g.v - gs[g.a2].v] + g.p + gs[g.a2].p);
                if (g.a1 >= 0 && g.a2 >= 0 && j >= g.v + gs[g.a1].v + gs[g.a2].v)
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - g.v - gs[g.a1].v - gs[g.a2].v] + g.p + gs[g.a1].p + gs[g.a2].p);
            }
        }
        int res = 0;
        for (int i = 0; i <= m; i++)
            res = Math.max(res, dp[i][N]);
        System.out.println(res);
    }


}

class Good {
    int v;
    int p;
    int q;

    int a1 = -1;
    int a2 = -1;


    void update(int v, int p, int q) {
        this.v = v;
        this.p = p;
        this.q = q;
    }

    void set(int a) {
        if (a1 < 0) a1 = a;
        else a2 = a;
    }
}
