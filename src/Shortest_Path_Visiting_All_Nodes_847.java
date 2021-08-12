import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @ClassName Shortest_Path_Visiting_All_Nodes_847
 * @Description
 * @Author cjx
 * @Date 2021/8/6 18:02
 * @Version 1.0
 */
public class Shortest_Path_Visiting_All_Nodes_847 {
    @Test
    public void test() {
        int[][] graph = new int[][]{
                {1, 2, 3},
                {0},
                {0},
                {0}
        };
        System.out.println(shortestPathLength(graph));
    }

    public int shortestPathLength(int[][] graph) {
        //得到点的个数
        int n = graph.length;
        //表示每种搜索情况(i,mask)是否出现过
        boolean[][] occur = new boolean[n][1 << n];
        //用于bfs的队列
        Queue<int[]> queue = new ArrayDeque<>();
        //由于从任意一个点开始搜索都可以，初始化时，将从任意一点出发表示的状态加入队列中
        for (int i = 0; i < n; i++) {
            queue.offer(new int[]{i, 1 << i, 0});
            occur[i][1 << i] = true;
        }
        //队列不为空表示可以继续搜索下去
        while (!queue.isEmpty()) {
            //表示当前这个三维变量表示的搜索状态(i,mask,dist)表示当前搜索在i点，mask表示哪些点已经被走过，dist表示走到当前位置已经使用的距离
            int[] situ = queue.poll();
            int i = situ[0];
            int mask = situ[1];
            int dist = situ[2];
            //如果mask表示当前已经走完所有点，由于队列先进先出的特性，第一个出现这种情况的，对应的距离dist也就是题目想要求取的最小路径
            if (mask == (1 << n) - 1) return dist;
            for (int nextPoint : graph[i]) {
                //如果将下一个点加入路径中对应的状态变量没出现过就将下一个点加入队列，并将对应的状态变量设置为true，表示出现过
                if (!occur[nextPoint][mask | (1 << nextPoint)]) {
                    queue.offer(new int[]{nextPoint, mask | (1 << nextPoint), dist + 1});
                    occur[nextPoint][mask | (1 << nextPoint)] = true;
                }
            }
        }
        return -1;
    }
}
