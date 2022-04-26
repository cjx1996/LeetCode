package All_Problems;

import java.util.ArrayDeque;

/**
 * @ClassName Number_of_Enclaves_1020
 * @Description
 * @Author cjx
 * @Date 2022/2/12 11:06
 * @Version 1.0
 */
public class Number_of_Enclaves_1020 {
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if(m<=2||n<=2) return 0;
        ArrayDeque<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            if (grid[i][0] != 0) {
                grid[i][0] = 0;
                q.add(new int[]{i, 0});
            }
            if (grid[i][n - 1] != 0) {
                grid[i][n - 1] = 0;
                q.add(new int[]{i, n - 1});
            }

        }
        for (int i = 0; i < n; i++) {
            if (grid[0][i] != 0) {
                grid[0][i] = 0;
                q.add(new int[]{0, i});
            }
            if (grid[m - 1][i] != 0) {
                grid[m - 1][i] = 0;
                q.add(new int[]{m - 1, i});
            }
        }
        int[][] dirs = new int[][]{
                {1, 0},
                {-1, 0},
                {0, 1},
                {0, -1}
        };
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] point = q.poll();
                int x = point[0], y = point[1];
                for (int[] dir : dirs) {
                    int nx = x + dir[0], ny = y + dir[1];
                    if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                    if (grid[nx][ny] != 0) {
                        grid[nx][ny] = 0;
                        q.add(new int[]{nx, ny});
                    }
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0) ans++;
            }
        }
        return ans;
    }
}
