import org.junit.Test;

import java.util.*;

/**
 * @ClassName Minimum_Height_Trees_310
 * @Description
 * @Author cjx
 * @Date 2022/4/7 11:02
 * @Version 1.0
 */
public class Minimum_Height_Trees_310 {
    @Test
    public void test(){
    int n = 4;
    int[][] edges = new int[][]{
            {1,0},
            {1,2},
            {1,3}
    };
        List<Integer> ans = findMinHeightTrees(4,edges);
        for (Integer an : ans) {
            System.out.println(an);
        }
    }
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        int[] degree = new int[n];
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            degree[i] = graph[i].size();
            if (degree[i] == 1) q.add(i);
        }
        int remain = n;
        while (remain> 2) {
            int m = q.size();
            for (int i = 0; i < m; i++) {
                remain--;
                Integer point = q.poll();
                degree[point]--;
                for (Integer conn : graph[point]) {
                    if (--degree[conn] == 1) q.add(conn);
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()){
            ans.add(q.poll());
        }
        return ans;
    }
}
