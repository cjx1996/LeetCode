package All_Problems;

import org.junit.Test;

import java.util.Arrays;

/**
 * @ClassName Where_Will_the_Ball_Fall_1706
 * @Description
 * @Author cjx
 * @Date 2022/2/24 14:59
 * @Version 1.0
 */
public class Where_Will_the_Ball_Fall_1706 {
    @Test
    public void test() {
        int[][] grid = new int[][]{
                {1, 1, 1, -1, -1},
                {1, 1, 1, -1, -1},
                {-1, -1, -1, 1, 1},
                {1, 1, 1, 1, -1},
                {-1, -1, -1, -1, -1}
        };
        int[] ans = findBall(grid);
        for (int an : ans) {
            System.out.print(an);
        }
    }


    int m, n;

    public int[] findBall(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = dfs(grid, 0, i);
        }
        return ans;
    }

    /*    int dfs(int[][] grid,  int x) {
          int d = 0,r=x;
            while (d < m) {
                int nr=r+grid[d][r];
                if(nr<0||nr>=n) return -1;
                if(grid[d][r]!=grid[d][nr]) return -1;
                d++;r=nr;
            }
            return r;
        }*/
    int dfs(int[][] grid, int x, int y) {
        if (x == m) return y;
        int ny = y + grid[x][y];
        if (ny < 0 || ny >= n) return -1;
        if (grid[x][y] != grid[x][ny]) return -1;
        return dfs(grid, x + 1, ny);
    }
/*
    public int[] findBall(int[][] grid) {
        dp = new int[grid.length][grid[0].length];
        m = dp.length;
        n = dp[0].length;
        for(int i = 0;i<m;i++){
            Arrays.fill(dp[i], -2);
        }

        int[] ans  = new int[n];
        for (int i = 0; i < n; i++) {
            dfs(grid,0,i);
            ans[i]=dp[0][i];
        }
        return ans;
    }

    void dfs(int[][] grid, int x, int y) {
        if (dp[x][y] != -2) return;
        if (y > 0 && grid[x][y] == -1 && grid[x][y - 1] == -1) {
            if (x == m - 1) {
                dp[x][y] = y - 1;
                return;
            }
            dfs(grid, x + 1, y - 1);
            dp[x][y] = dp[x + 1][y - 1];
            return;
        }
        if (y < n-1 && grid[x][y] == 1 && grid[x][y + 1] == 1) {
            if (x == m - 1) {
                dp[x][y] = y + 1;
                return;
            }
            dfs(grid, x + 1, y + 1);
            dp[x][y] = dp[x + 1][y + 1];
            return;
        }
        dp[x][y] = -1;
        return;
    }
*/
}
