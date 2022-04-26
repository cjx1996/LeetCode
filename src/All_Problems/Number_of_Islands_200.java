package All_Problems;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @ClassName Number_of_Islands_200
 * @Description
 * @Author cjx
 * @Date 2021/7/20 18:16
 * @Version 1.0
 */
public class Number_of_Islands_200 {
    @Test
    public void test() {
        char[][] grid = new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '1'},
                {'0', '0', '1', '0', '1'}

        };
        System.out.println(numIslands(grid));
    }

    public int numIslands(char[][] grid) {
        int ans = 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    ans++;
                }
            }
        }
        return ans;
    }

    //对单个结点的值进行修改
    void dfs(char[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;
        grid[i][j] = '0';

        //考虑每个节点周围的四个节点情况，分情况讨论，如果满足条件，对该节点进行修改
        if (i > 0) {
            if (grid[i - 1][j] == '1') {
                dfs(grid, i - 1, j);
            }
        }
        if (j > 0) {
            if (grid[i][j - 1] == '1') {
                dfs(grid, i, j - 1);
            }
        }

        if (i < m - 1) {
            if (grid[i + 1][j] == '1') {
                dfs(grid, i + 1, j);
            }
        }
        if (j < n - 1) {
            if (grid[i][j + 1] == '1') {
                dfs(grid, i, j + 1);
            }
        }
    }

}
