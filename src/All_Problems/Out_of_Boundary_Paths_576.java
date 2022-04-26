package All_Problems;

import org.junit.Test;

/**
 * @ClassName Out_of_Boundary_Paths_576
 * @Description
 * @Author cjx
 * @Date 2021/8/15 17:49
 * @Version 1.0
 */
public class Out_of_Boundary_Paths_576 {
    @Test
    public void test() {
        System.out.println(findPaths(8,50,23,5,26));
    }

    void add(int[][][] dp, int x, int y, int maxMove) {
        for (int i = 1; i < maxMove + 1; i++) {
            dp[x][y][i]++;
        }
    }

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        //dp数组，dp[i][j]表示从i=x*m+y表示的(x,y)出发，经过最多j步的出界路径数
        int[][][] dp = new int[m][n][maxMove + 1];
        for (int i = 0; i < m * n; i++) {
            int x = i / n, y = i % n;
            if (x == 0) add(dp, x, y, maxMove);
            if (y == 0) add(dp, x, y, maxMove);
            if (x == m - 1) add(dp, x, y, maxMove);
            if (y == n - 1) add(dp, x, y, maxMove);
        }
        //必须先计算k，因为计算dp[i][j][k]依赖与dp[][][k]
        for (int k = 2; k < maxMove + 1; k++) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    int[] x = new int[]{1, -1, 0, 0};
                    int[] y = new int[]{0, 0, 1, -1};
                    for (int l = 0; l < 4; l++) {
                        if (i + x[l] == -1 || i + x[l] == m || j + y[l] == -1 || j + y[l] == n) continue;
                        dp[i][j][k] += dp[i + x[l]][j + y[l]][k - 1];
                        //必须每计算出一个就取余，因为临界时可能就差1就临界了
                        dp[i][j][k] %= 1e9+7;
                    }
                }

            }
        }
        return dp[startRow][startColumn][maxMove];
    }
}
