package All_Problems;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName Combination_Sum_39
 * @Description
 * @Author cjx
 * @Date 2021/7/30 11:54
 * @Version 1.0
 */
public class Combination_Sum_39 {
    @Test
    public void test() {
        int[] candidates = new int[]{2, 3, 5};
        int target = 8;
        List<List<Integer>> ans = combinationSum(candidates, target);
        ans.forEach(x -> System.out.print(x));
    }

    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> tem = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates, target, 0);
        return ans;
    }

    void dfs(int[] candidates, int target, int index) {
        if (target == 0) {
            ans.add(new ArrayList<Integer>(tem));
            return;
        }
        if (index == candidates.length || target < candidates[index]) {
            return;
        }
        tem.add(candidates[index]);
        dfs(candidates, target - candidates[index], index);
        tem.remove(tem.size() - 1);

        dfs(candidates, target, index + 1);

    }

}
