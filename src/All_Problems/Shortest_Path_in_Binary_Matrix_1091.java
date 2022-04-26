package All_Problems;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName Shortest_Path_in_Binary_Matrix_1091
 * @Description
 * @Author cjx
 * @Date 2021/7/23 18:28
 * @Version 1.0
 */
public class Shortest_Path_in_Binary_Matrix_1091 {
    @Test
    public void test() {
        int[][] grid = new int[][]{
                {0, 1, 0, 0, 0, 0},
                {0, 1, 0, 1, 1, 0},
                {0, 1, 1, 0, 1, 0},
                {0, 0, 0, 0, 1, 0},
                {1, 1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1, 0}
        };
        System.out.println(shortestPathBinaryMatrix(grid));
    }



    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        //定义用于表示每个点是否被遍历过的
        boolean[][] used = new boolean[n][n];
        //表示每一步可能达到的点集
        Queue<int[]> points = new LinkedList<>();
        //如果需要使用step变量，那么从[0,0]开始后step初始化为1
        int step = 1;
        //定义X、Y数组表示8个方位的向量
        int[] X = new int[]{0,0,1,1,1,-1,-1,-1};
        int[] Y = new int[]{-1,1,-1,0,1,-1,0,1};
        //如果第一个点不为0，返回-1
        if (grid[0][0] != 0) return -1;
        //第一个点为0，加入第一个点
        points.add(new int[]{0, 0});
        used[0][0] = true;
        //只要点集不为空就可以继续尝试找下去
        while (!points.isEmpty()) {
            //当前步数可以到达的点的个数
            int size = points.size();
            //遍历每个点，将下一步可以到达的点加入点集
            for (int i = 0; i < size; i++) {
                int[] point = points.poll();
                //每个点的坐标
                int j = point[0];
                int k = point[1];
                if (j == k && j == n - 1) return step;
                //对于每个点，尝试将8个方位的其他点加入点集
                for (int l = 0; l < 8; l++) {
                    addPoint(grid,points,used,j+X[l],k+Y[l]);
                }
            }
            //遍历完后step增加，表示路径增加
            step++;
        }
        //找完全部可能到达的点，没有结果，返回-1
        return -1;
    }

    void addPoint(int[][] grid, Queue<int[]> points, boolean[][] used, int i, int j) {
        int n = grid.length;
        if (i < 0 || j < 0 || i >= n || j >= n) return;
        if (grid[i][j] == 0 && used[i][j] == false) {
            points.add(new int[]{i, j});
            used[i][j] = true;
        }
    }





    int ans = 10001;
    //深度优先搜索,超时严重
    void dfs(int[][] grid, int i, int j, List<Integer> list, int step) {
        int n = grid.length;
        if (ans != 10001) return;
        if (i < 0 || i >= n || j < 0 || j >= n) return;
        if (i == n - 1 && j == n - 1) {
            if (grid[i][j] == 0) {
                ans = Math.min(step + 1, ans);
            }
            return;
        }

        if (grid[i][j] == 0) {

            //右下
            if (!list.contains((Integer) (n * (i + 1) + j + 1))) {
                list.add(n * (i + 1) + j + 1);
                dfs(grid, i + 1, j + 1, list, step + 1);
                list.remove((Integer) (n * (i + 1) + j + 1));
            }

            //右
            if (!list.contains((Integer) (n * (i) + j + 1))) {
                list.add(n * (i) + j + 1);
                dfs(grid, i, j + 1, list, step + 1);
                list.remove((Integer) (n * (i) + j + 1));
            }


            //下
            if (!list.contains((Integer) (n * (i + 1) + j))) {
                list.add(n * (i + 1) + j);
                dfs(grid, i + 1, j, list, step + 1);
                list.remove((Integer) (n * (i + 1) + j));
            }

            //右上
            if (!list.contains((Integer) (n * (i - 1) + j + 1))) {
                list.add(n * (i - 1) + j + 1);
                dfs(grid, i - 1, j + 1, list, step + 1);
                list.remove((Integer) (n * (i - 1) + j + 1));
            }

            //左下
            if (!list.contains((Integer) (n * (i + 1) + j - 1))) {

                list.add(n * (i + 1) + j - 1);
                dfs(grid, i + 1, j - 1, list, step + 1);
                list.remove((Integer) (n * (i + 1) + j - 1));

            }

            //上
            if (!list.contains((Integer) (n * (i - 1) + j))) {

                list.add(n * (i - 1) + j);
                dfs(grid, i - 1, j, list, step + 1);
                list.remove((Integer) (n * (i - 1) + j));
            }

            //左
            if (!list.contains((Integer) (n * (i) + j - 1))) {

                list.add(n * (i) + j - 1);
                dfs(grid, i, j - 1, list, step + 1);
                list.remove((Integer) (n * (i) + j - 1));
            }

            //左上
            if (!list.contains((Integer) (n * (i - 1) + j - 1))) {

                list.add(n * (i - 1) + j - 1);
                dfs(grid, i - 1, j - 1, list, step + 1);
                list.remove((Integer) (n * (i - 1) + j - 1));
            }


        }
        return;

    }
}
