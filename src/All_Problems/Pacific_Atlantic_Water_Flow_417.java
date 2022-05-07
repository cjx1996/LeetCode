package All_Problems;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @ClassName Pacific_Atlantic_Water_Flow_417
 * @Description
 * @Author cjx
 * @Date 2022/4/27 10:33
 * @Version 1.0
 */
public class Pacific_Atlantic_Water_Flow_417 {
    @Test
    public void test() {
        int[][] heights = new int[][]{
                {1, 2, 2, 3, 5}, {3, 2, 3, 4, 4}, {2, 4, 5, 3, 1}, {6, 7, 1, 4, 5}, {5, 1, 1, 2, 4}
        };
        List<List<Integer>> res = pacificAtlantic(heights);

        for (List<Integer> list : res) {
            for (Integer i : list) {
                System.out.print(i+" ");
            }
            System.out.println();
        }

    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        int[][] dirs = new int[][]{{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
        boolean[][] vis = new boolean[m][n];
        Deque<int[]> q = new ArrayDeque<>();
        int[][] cnt = new int[m][n];
        for (int i = 0; i < m; i++) {
            vis[i][0] = true;
            q.add(new int[]{i, 0});
            cnt[i][0]++;
        }
        for (int i = 1; i < n; i++) {
            vis[0][i] = true;
            q.add(new int[]{0, i});
            cnt[0][i]++;
        }
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] point= q.poll();
                int x = point[0], y = point[1];
                for (int j = 0; j < 4; j++) {
                    int dx = dirs[j][0], dy = dirs[j][1];
                    int nx = x + dx, ny = y + dy;
                    if (nx < 0 || nx >= m || ny < 0 || ny >= n || vis[nx][ny]) continue;
                    if(heights[nx][ny]>=heights[x][y]){
                        q.add(new int[]{nx, ny});
                        vis[nx][ny] = true;
                        cnt[nx][ny]++;
                    }
                }
            }
        }
        vis = new boolean[m][n];
        for (int i = 0; i < m - 1; i++) {
            vis[i][n - 1] = true;
            q.add(new int[]{i, n - 1});
            cnt[i][n - 1]++;
        }
        for (int i = 0; i < n; i++) {
            vis[m - 1][i] = true;
            q.add(new int[]{m - 1, i});
            cnt[m - 1][i]++;
        }
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] po=q.poll();
                int x = po[0], y = po[1];
                for (int j = 0; j < 4; j++) {
                    int dx = dirs[j][0], dy = dirs[j][1];
                    int nx = x + dx, ny = y + dy;
                    if (nx < 0 || nx >= m || ny < 0 || ny >= n || vis[nx][ny]) continue;
                    if(heights[nx][ny]>=heights[x][y]){
                        q.add(new int[]{nx, ny});
                        vis[nx][ny] = true;
                        cnt[nx][ny]++;
                    }
                }
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (cnt[i][j] == 2) {
                    List<Integer> po = new ArrayList<>();
                    po.add(i);
                    po.add(j);
                    res.add(po);
                }
            }
        }
        return res;
    }

}
