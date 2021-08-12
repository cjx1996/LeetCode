import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Find_Eventual_Safe_States_802
 * @Description
 * @Author cjx
 * @Date 2021/8/5 9:48
 * @Version 1.0
 */
public class Find_Eventual_Safe_States_802 {
    @Test
    public void test() {
        int[][] graph = new int[][]{
                {1, 2},
                {2, 3},
                {5},
                {0},
                {5},
                {},
                {}
        };
        System.out.println(eventualSafeNodes(graph));
    }



    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> circle = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        int n = graph.length;
        int[] situ = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            safe(graph, situ, i);
        }
        for (int i = 0; i < n; i++) {
            if (situ[i] == 2) {
                ans.add(i);
            }
        }
        return ans;
    }

    void safe(int[][] graph, int[] situ, int i) {
        if (situ[i] != 0) return;
        situ[i] = 1;
        for (int point : graph[i]) {
            safe(graph, situ, point);
            if (situ[point] == 1) return;
        }
        situ[i] = 2;
        return;
    }

}
