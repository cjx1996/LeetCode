package All_Problems;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @ClassName Number_of_Closed_Islands_1254
 * @Description
 * @Author cjx
 * @Date 2023/6/18 23:36
 * @Version 1.0
 */
public class Number_of_Closed_Islands_1254 {
    @Test
    public void test() {
        int[][] grid = new int[][]{
                {1, 1, 1, 1, 1, 1, 1, 0},
                {1, 0, 0, 0, 0, 1, 1, 0},
                {1, 0, 1, 0, 1, 1, 1, 0},
                {1, 0, 0, 0, 0, 1, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 0}
        };
        System.out.println(closedIsland(grid));
    }

    int[][] grid;
    int[][] dirs = {
            {0, 1},
            {0, -1},
            {1, 0},
            {-1, 0}
    };
    int m, n;

    public int closedIsland(int[][] _grid) {
        grid = _grid;
        m = grid.length;
        n = grid[0].length;
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    ans += dfs(i, j);
                }
            }
        }
        return ans;
    }

    int dfs(int i, int j) {
        Deque<int[]> q = new ArrayDeque<>();
        int ans = 1;
        q.add(new int[]{i, j});
        grid[i][j] = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int k = 0; k < size; k++) {
                int[] point = q.poll();
                int x = point[0], y = point[1];
                for (int l = 0; l < 4; l++) {
                    int nx = x + dirs[l][0], ny = y + dirs[l][1];
                    if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                        ans = 0;
                    } else if (grid[nx][ny] == 0) {
                        q.add(new int[]{nx, ny});
                        grid[nx][ny] = 1;
                    }
                }
            }
        }
        return ans;
    }
}
