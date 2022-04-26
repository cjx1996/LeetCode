package All_Problems;

import org.junit.Test;

/**
 * @ClassName Max_Area_of_Island_695
 * @Description
 * @Author cjx
 * @Date 2021/8/11 23:37
 * @Version 1.0
 */
public class Max_Area_of_Island_695 {
    @Test
    public void test() {
        int[][] grid = new int[][]{
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
        };
        System.out.println(maxAreaOfIsland(grid));

    }

    public int maxAreaOfIsland(int[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    ans = Math.max(ans, bfs(grid, i, j));
                }
            }
        }
        return ans;
    }

    int bfs(int[][] grid, int i, int j) {
        if (i == -1 || j == -1 || i == grid.length || j == grid[0].length || grid[i][j] == 0) return 0;
        int area = 1;
        grid[i][j] = 0;
        int[] x = new int[]{0, 0, 1, -1};
        int[] y = new int[]{1, -1, 0, 0};
        for (int k = 0; k < 4; k++) {
            area += bfs(grid, i + x[k], j + y[k]);
        }
        return area;
    }
}
