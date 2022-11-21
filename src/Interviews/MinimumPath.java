package Interviews;

import org.junit.Test;

import java.util.Scanner;

/**
 * @ClassName MinimumPath
 * @Description 在一个100*100的格线网上，某些网线交点上有食物。一只蚂蚁现在原点，它能顺着格线网去吃掉食物，问题：蚂蚁吃掉所有食物，最少爬行多远？
 * 时间复杂度O(n*n)
 * @Author cjx
 * @Date 2022/9/15 20:15
 * @Version 1.0
 */
public class MinimumPath {
    @Test
    public void tset() {
        int[][] _points=new int[][]{
                {0,5},
                {1,1}
        };
        System.out.println(getMinLen(_points));
    }

    int n;
    int[][] points;
    boolean[][] vis = new boolean[100][100];
    int ans = Integer.MAX_VALUE;

    public int getMinLen(int[][] _points) {
        points = _points;
        n = points.length;
        backtrack(0, 0, 0, 0);
        return ans;
    }

    void backtrack(int cx, int cy, int cnt, int cost) {
        if (cnt == n) {
            ans = Math.min(ans, cost);
            return;
        }
        for (int[] point : points) {
            int x = point[0], y = point[1];
            if (!vis[x][y]) {
                vis[x][y] = true;
                cost += Math.abs(cx - x) + Math.abs(cy - y);
                backtrack(x, y, cnt + 1, cost);
                cost -= Math.abs(cx - x) + Math.abs(cy - y);
                vis[x][y] = false;
            }
        }
    }
}
