package All_Problems;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName Subsets_78
 * @Description
 * @Author cjx
 * @Date 2021/7/25 23:32
 * @Version 1.0
 */
public class Subsets_78 {
    @Test
    public void test(){
        int[] nums = new int[]{1,2,3};
        List ans = subsets(nums);
        ans.forEach(x -> System.out.println(x) );
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int len = nums.length;
        if (len == 0) {
            ans.add(new ArrayList<Integer>());
            return ans;
        }
        ans = subsets(Arrays.copyOf(nums,len-1));
        int size = ans.size();
        for (int i = 0; i < size; i++) {

            ArrayList<Integer> newSubset = new ArrayList<>(ans.get(i));
            newSubset.add(nums[len-1]);
            ans.add(newSubset);
        }
        return ans;

    }
}
