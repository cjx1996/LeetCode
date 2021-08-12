import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName Permutations_II_47
 * @Description
 * @Author cjx
 * @Date 2021/7/30 11:39
 * @Version 1.0
 */
public class Permutations_II_47 {
    @Test
    public void test(){
        int[] nums = new int[]{3,3,2,2};
        List<List<Integer>> ans = permuteUnique(nums);
        ans.forEach(x->System.out.println(x));


    }
    private List<List<Integer>> ans = new ArrayList<>();
    private List<Integer> tem = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums){
        Arrays.sort(nums);
        boolean[] used= new boolean[nums.length];
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
            if (used[i] == false&&(i==0||nums[i]!=nums[i-1]||used[i-1])) {
                tem.add(nums[i]);
                used[i] = true;
                dfs(used, nums, n + 1);
                tem.remove(tem.size() - 1);
                used[i] = false;
            }
        }
    }
}
