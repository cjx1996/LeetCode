package All_Problems;

/**
 * @ClassName Path_with_Maximum_Gold_1219
 * @Description
 * @Author cjx
 * @Date 2022/2/5 10:33
 * @Version 1.0
 */
public class Path_with_Maximum_Gold_1219 {
    int max = 0;
    int[][] grid;
    int[][] dirs = new int[][]{
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
    };
    int m = 0, n = 0;

    public int getMaximumGold(int[][] _grid) {
        grid = _grid;
        m = grid.length;
        n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > 0)
                    backtrack(i, j, 0);
            }
        }
        return max;
    }

    private void backtrack(int i, int j, int sum) {
        int cur = grid[i][j];
        grid[i][j] = 0;
        max = Math.max(max, sum + cur);
        for (int[] dir : dirs) {
            int x = dir[0], y = dir[1];
            int nx = x + i, ny = y + j;
            if (nx < 0 || nx >= m || ny < 0 || ny >= n || grid[nx][ny] == 0) continue;
            backtrack(nx, ny, sum + cur);
        }
        grid[i][j] = cur;
    }
}
