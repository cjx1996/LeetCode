package All_Problems;

import org.junit.Test;

/**
 * @ClassName Jump_Game_55
 * @Description
 * @Author cjx
 * @Date 2021/8/26 17:57
 * @Version 1.0
 */
public class Jump_Game_55 {
    @Test
    public void test() {

        int[] nums = new int[]{
                3, 2, 1, 0, 4
        };
        System.out.println(canJump(nums));
    }

    public boolean canJump(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i <= max) {
                max = Math.max(max, i + nums[i]);
            }
        }
        return max >= nums.length-1;
    }
}
