import org.junit.Test;

/**
 * @ClassName Move_Zeroes_283
 * @Description
 * @Author cjx
 * @Date 2021/8/7 22:13
 * @Version 1.0
 */
public class Move_Zeroes_283 {
    @Test
    public void test() {
        int[] nums = new int[]{1,0,2,3,0,4,0};
        moveZeroes(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }

    public void moveZeroes(int[] nums) {
        int left = 0, right = 0;
        int n = nums.length;
        while(right<n){
            if(nums[right]!=0){
                nums[left++] = nums[right];
            }
            right++;
        }
        while(left<n){
            nums[left++] = 0;
        }
    }
}
