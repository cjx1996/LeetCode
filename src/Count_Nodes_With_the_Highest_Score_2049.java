import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName Count_Nodes_With_the_Highest_Score_2049
 * @Description
 * @Author cjx
 * @Date 2022/3/11 9:57
 * @Version 1.0
 */
public class Count_Nodes_With_the_Highest_Score_2049 {
    @Test
    public void test() {
        int[] parents = new int[]{-1, 2, 0};
        System.out.println(countHighestScoreNodes(parents));
    }

    public int countHighestScoreNodes(int[] parents) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int n = parents.length;
        for (int i = 1; i < n; i++) {
            List<Integer> list = map.getOrDefault(parents[i], new ArrayList<Integer>());
            list.add(i);
            map.put(parents[i], list);
        }
        int[] cnt = new int[n];
        num(cnt, 0, map);
        int ans = 0, max = 0;
        for (int i = 0; i < n; i++) {
            int mul = 1;
            List<Integer> list = map.getOrDefault(i, new ArrayList<>());
            int sum = n;
            for (Integer j : list) {
                sum -= cnt[j];
                mul *= cnt[j];
            }
            if (sum != 1) mul *= sum - 1;
            if (mul > max) {
                max = mul;
                ans = 1;
            } else if (mul == max) ans++;
        }
        return ans;
    }

    int num(int[] cnt, int node, Map<Integer, List<Integer>> map) {
        if (cnt[node] != 0) return cnt[node];
        List<Integer> list = map.getOrDefault(node, new ArrayList<>());
        int ans = 1;
        for (Integer integer : list) {
            ans += num(cnt, integer, map);
        }
        cnt[node] = ans;
        return ans;
    }
}
