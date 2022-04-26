package All_Problems;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

/**
 * @ClassName Matrix_01_542
 * @Description
 * @Author cjx
 * @Date 2021/8/13 22:36
 * @Version 1.0
 */
public class Matrix_01_542 {
    @Test
    public void test() {
        int[][] mat = new int[][]{
                {1, 1, 1},
                {0, 1, 1},
                {1, 1, 1}
        };
        updateMatrix(mat);
        for (int[] ints : mat) {
            for (int i : ints) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public int[][] updateMatrix(int[][] mat) {
        Queue<int[]> queue = new ArrayDeque<>();
        int m = mat.length;
        int n = mat[0].length;
        int[][] directions = new int[][]{
                {0, 1},
                {0, -1},
                {1, 0},
                {-1, 0}
        };
        boolean[][] used = new boolean[m][n];
        //将所有0加入队列
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    used[i][j] = true;
                    queue.offer(new int[]{i, j});
                }
            }
        }
        //bfs过程
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            int x = point[0], y = point[1];
            for (int[] direction : directions) {
                int nx = x + direction[0], ny = y + direction[1];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && !used[nx][ny]) {
                    used[nx][ny] = true;
                    mat[nx][ny] = mat[x][y] + 1;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
        return mat;
    }


}
