package All_Problems;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @ClassName Rotting_Oranges_994
 * @Description
 * @Author cjx
 * @Date 2021/8/17 11:50
 * @Version 1.0
 */
public class Rotting_Oranges_994 {
    @Test
    public void test() {
        int[][] grid = new int[][]{
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        };
        System.out.println(orangesRotting(grid));

    }

    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int time = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            time++;
            for (int i = 0; i < size; i++) {
                int[] point = queue.poll();
                int x = point[0], y = point[1];
                for (int[] direction : directions) {
                    int nx = x + direction[0], ny = y + direction[1];
                    if (nx > -1 && nx < m && ny > -1 && ny < n && grid[nx][ny] == 1) {
                        queue.offer(new int[]{nx, ny});
                        grid[nx][ny] = 2;
                    }
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) return -1;
            }
        }
        return time>0?time-1:time;
    }
}
