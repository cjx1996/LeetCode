import org.junit.Test;

import java.util.*;

/**
 * @ClassName Restore_the_Array_From_Adjacent_Pairs_1743
 * @Description
 * @Author cjx
 * @Date 2021/7/25 9:41
 * @Version 1.0
 */
public class Restore_the_Array_From_Adjacent_Pairs_1743 {
    @Test
    public void test() {
        int[][] adjacentPairs = new int[][]{
                {2, 1},
                {3, 4},
                {3, 2}
        };
        int[] ans = restoreArray(adjacentPairs);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }
    }

    //分为两个步骤：
    //①从元素对中找到两个边界数值中的一个
    //②将每个元素相邻的数值创建哈希表，根据哈希表进行深度优先搜索
    public int[] restoreArray(int[][] adjacentPairs) {

        Map<Integer, ArrayList<Integer>> near = new HashMap<>();
        for (int[] pair : adjacentPairs) {
            near.putIfAbsent(pair[1], new ArrayList<>());
            near.putIfAbsent(pair[0], new ArrayList<>());
            near.get(pair[1]).add(pair[0]);
            near.get(pair[0]).add(pair[1]);
        }

        int len = near.size();
        int[] ans = new int[len];

        Set<Map.Entry<Integer, ArrayList<Integer>>> entries = near.entrySet();
        for (Map.Entry entry : entries) {
            List value = (ArrayList) entry.getValue();
            if (value.size() == 1) {
                ans[0] = (Integer) entry.getKey();
                break;
            }
        }
        ans[1] = near.get(ans[0]).get(0);
        for (int i = 2; i < len; i++) {
            int prev = ans[i - 1];
            ans[i] = (ans[i - 2] == (near.get(prev).get(0)) ? near.get(prev).get(1) : near.get(prev).get(0));
        }

        return ans;
    }
}
