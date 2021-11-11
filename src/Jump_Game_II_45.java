import org.junit.Test;

/**
 * @ClassName Jump_Game_II_45
 * @Description
 * @Author cjx
 * @Date 2021/8/26 18:52
 * @Version 1.0
 */
public class Jump_Game_II_45 {
    @Test
    public void test() {
        int[] nums = new int[]{2, 3, 0, 1, 4};
        System.out.println(jump(nums));
    }

    public int jump(int[] nums) {
        //表示走了多少步
        int steps = 0;
        //表示每一轮尝试的边界
        int end =0;
        //表示当前尝试的最大边界索引
        int maxPosition = 0;
        //表示数组的长度
        int len = nums.length;
        //通过maxPosition变量的设置，记录了将要选择的下一步的落点，同时还不用回溯
        for (int i = 0; i < len - 1; i++) {
            maxPosition= Math.max(maxPosition,i+nums[i]);
            if(i==end){
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }
}
