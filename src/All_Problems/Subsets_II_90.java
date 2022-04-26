package All_Problems;

import org.junit.Test;

import java.util.*;

/**
 * @ClassName Subsets_II_90
 * @Description
 * @Author cjx
 * @Date 2021/7/27 18:13
 * @Version 1.0
 */
public class Subsets_II_90 {
    @Test
    public void test() {
        int[] nums = new int[]{1, 4, 4, 4, 4};
        List<List<Integer>> ans = subsetsWithDup(nums);
        ans.forEach(x -> System.out.println(x));
    }


    private List<List<Integer>> ans = new ArrayList<>();
    private List<Integer> choice = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        dfs(used, nums, 0);
        return ans;
    }

    //已经有n位数字确定好，本次决定第n+1位
    void dfs(boolean[] used, int[] nums, int n) {
        if (n == nums.length) {
            List<Integer> tem = List.copyOf(choice);
            ans.add(tem);
            return;
        }

        dfs(used, nums, n + 1);
        if (n == 0 || nums[n] != nums[n - 1] || used[n - 1]) {

            choice.add(nums[n]);
            used[n] = true;
            dfs(used, nums, n + 1);
            choice.remove(choice.size()-1);
            used[n] = false;
        }
    }

}
