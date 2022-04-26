package All_Problems;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName Coloring_A_Border_1034
 * @Description
 * @Author cjx
 * @Date 2021/12/7 16:53
 * @Version 1.0
 */
public class Coloring_A_Border_1034 {
    int[][] grid;
    boolean[][] used;
    List<int[]> ans = new ArrayList<>();
    Queue<int[]> tem = new ArrayDeque<>();
    int ori;

    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        //定义初始变量
        int m = grid.length;
        int n = grid[0].length;
        this.grid = grid;
        ori = grid[row][col];
        used = new boolean[m][n];
        //初始化队列
        tem.add(new int[]{row, col});
        //对队列进行广度优先搜索
        while (tem.size() != 0) {
            for (int i = 0; i < tem.size(); i++) {
                int[] point = tem.poll();
                ifPoint(point);
            }
        }
        for (int i = 0; i < ans.size(); i++) {
            int[] point = ans.get(i);
            grid[point[0]][point[1]] = color;
        }
        return grid;
    }

    void ifPoint(int[] point) {
        int[][] dirs = new int[][]{
                {0, 1},
                {0, -1},
                {1, 0},
                {-1, 0}
        };
        int m = grid.length;
        int n = grid[0].length;
        int x = point[0], y = point[1];
        for (int i = 0; i < 4; i++) {
            int[] diff = dirs[i];
            int X = x + diff[0], Y = y + diff[1];
            if (X < 0 || X >= m || Y < 0 || Y >= n || grid[X][Y] != ori) {
                if (!ans.contains(new int[]{x, y})) {
                    ans.add(new int[]{x, y});
                }
                continue;
            } else if (!used[X][Y]) {
                tem.add(new int[]{X, Y});
            }
        }
        used[x][y] = true;
    }

    @Test
    public void test() {
        int[][] grid = new int[][]{
                {1, 1, 1},
                {1, 1, 1},
                {1, 1, 1}
        };
        int[][] ans = colorBorder(grid, 1, 1, 2);
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[0].length; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }


}
