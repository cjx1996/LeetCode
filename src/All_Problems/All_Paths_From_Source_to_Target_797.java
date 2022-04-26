package All_Problems;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName All_Paths_From_Source_to_Target_797
 * @Description
 * @Author cjx
 * @Date 2021/7/24 23:47
 * @Version 1.0
 */
public class All_Paths_From_Source_to_Target_797 {

    @Test
    public void test() {
        int[][] graph = new int[][]{
                {4,3,1},
                {3,2,4},
                {3},
                {4},
                {}
        };
        allPathsSourceTarget(graph);
        for(List<Integer> route:ans){
            System.out.println(route);
        }
    }

    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        dfs(graph, 0, new ArrayList<Integer>());
        return ans;
    }

    void dfs(int[][] graph, int index, List<Integer> route) {
        route.add(index);
        if (index == graph.length - 1) {
            ans.add(new ArrayList<>(route));
            return;
        }
        int[] nextPoint = graph[index];
        for (int i = 0; i < nextPoint.length; i++) {
            dfs(graph, nextPoint[i], route);
            route.remove((Integer)nextPoint[i]);
        }
    }
}
