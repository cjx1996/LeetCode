package All_Problems;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName Combination_Sum_II_40
 * @Description
 * @Author cjx
 * @Date 2021/7/30 12:06
 * @Version 1.0
 */
public class Combination_Sum_II_40 {
    @Test
    public void test() {
        int[] candidates = new int[]{2, 5, 2, 1, 2};
        int target = 5;
        List<List<Integer>> ans = combinationSum2(candidates, target);
        ans.forEach(x -> System.out.print(x));
    }

    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> tem = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        boolean[] used = new boolean[candidates.length];
        dfs(used, candidates, target, 0);
        return ans;
    }

    void dfs(boolean[] used, int[] candidates, int target, int index) {
        if (target == 0) {
            ans.add(new ArrayList<Integer>(tem));
            return;
        }
        if (index == candidates.length || target < candidates[index]) {
            return;
        }
        if (index == 0 || candidates[index] != candidates[index - 1] || used[index - 1]) {

            tem.add(candidates[index]);
            used[index] = true;
            dfs(used, candidates, target - candidates[index], index + 1);
            tem.remove(tem.size() - 1);
            used[index] = false;
        }
        dfs(used, candidates, target, index + 1);

    }
}
