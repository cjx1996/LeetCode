package All_Problems;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @ClassName Number_Of_Ways_To_Reconstruct_A_Tree_1719
 * @Description
 * @Author cjx
 * @Date 2022/2/16 18:03
 * @Version 1.0
 */
public class Number_Of_Ways_To_Reconstruct_A_Tree_1719 {
    @Test
    public void test() {
        int[][] pairs = new int[][]{
                {1, 2}, {1, 3}, {1, 4}, {1, 6}, {1, 7}, {2, 5}, {3, 6}, {4, 7}};
        System.out.println(checkWays(pairs));
    }

    public int checkWays(int[][] pairs) {


        int N = 505;
        boolean[][] graph = new boolean[N][N];
        int[] cnt = new int[N], forward = new int[N];
        Set<Integer> points = new HashSet<>();
        int m = pairs.length;
        for (int i = 0; i < m; i++) {
            int a = pairs[i][0], b = pairs[i][1];
            cnt[a]++;
            cnt[b]++;
            graph[a][b] = true;
            graph[b][a] = true;
            points.add(a);
            points.add(b);
        }
        List<Integer> list = new ArrayList<>(points);
        list.sort((a, b) -> (cnt[b] - cnt[a]));
        int n = list.size();

        if (m < n - 1) return 0;

        int root = list.get(0);
        if(cnt[root]!=n-1) return 0;
        forward[root] = -1;
        for (int i = 1; i < n; i++) {
            boolean ok = false;
            int a = list.get(i);
            for (int j = i - 1; j >= 0 && !ok; j--) {
                int b = list.get(j);
                if (graph[a][b]) {
                    forward[a] = b;
                    ok = true;
                }
            }
            if (!ok) return 0;
        }

        int c = 0, ans = 1;

        for (Integer i : points) {
            int j = i;
            while (forward[j] != -1) {
                if (!graph[i][forward[j]]) return 0;
                if (ans == 1 && cnt[j] == cnt[forward[j]]) ans = 2;
                c++;
                j = forward[j];
            }
        }
        return c < m ? 0 : ans;
    }
}
