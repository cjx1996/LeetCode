import org.junit.Test;

/**
 * @ClassName Increasing_Triplet_Subsequence_334
 * @Description Greedy Array
 * @Author cjx
 * @Date 2022/1/12 14:09
 * @Version 1.0
 */
public class Increasing_Triplet_Subsequence_334 {
    @Test
    public void test(){
    int[] nums = new int[]{1,2};
        System.out.println(increasingTriplet(nums));
    }
    public boolean increasingTriplet(int[] nums){
        for (int i = 1,fir=nums[0],sec=Integer.MAX_VALUE; i < nums.length; i++) {
            int cur = nums[i];
            if(cur>sec) return true;
            else if(cur>fir) sec=cur;
            else {
                fir = cur;
            }
        }
        return false;
    }
}
