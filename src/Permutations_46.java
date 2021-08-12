import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Permutations_46
 * @Description
 * @Author cjx
 * @Date 2021/7/30 11:27
 * @Version 1.0
 */
public class Permutations_46 {
    @Test
    public void test() {
        int[] nums = new int[]{1, 2, 3};
        System.out.println(permute(nums));
    }


    private List<List<Integer>> ans = new ArrayList<>();
    private List<Integer> tem = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        boolean[] used = new boolean[nums.length];
        dfs(used,nums,0);
        return ans;
    }

    void dfs(boolean[] used, int[] nums, int n) {
        if (n == nums.length) {
            List<Integer> res = List.copyOf(tem);
            ans.add(res);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i] == false) {
                tem.add(nums[i]);
                used[i] = true;
                dfs(used, nums, n + 1);
                tem.remove(tem.size() - 1);
                used[i] = false;
            }
        }
    }

}
