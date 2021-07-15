import org.junit.Test;

import java.util.HashMap;

/**
 * @ClassName Subarray_Sum_Equals_K_560
 * @Description 对于给定的数组，返回其和等于给定值K的子数组数目
 * @Author cjx
 * @Date 2021/6/2 17:36
 * @Version 1.0
 */
public class Subarray_Sum_Equals_K_560 {

    public int subarraySum(int[] nums,int k){
        HashMap<Integer, Integer> prev = new HashMap<>();
        int result = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if(prev.containsKey(sum)){
                prev.put(sum,prev.get(sum)+1);
            }else{
                prev.put(sum,1);
            }
            sum+=nums[i];
            if(prev.containsKey(sum-k)){
                result+=prev.get(sum-k);
            }
        }
        return result;
    }

    @Test
    public void test(){
        int[] nums={1,2,3};
        System.out.println(subarraySum(nums,3));
    }


}
