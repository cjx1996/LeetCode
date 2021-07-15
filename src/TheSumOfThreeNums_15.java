import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author cjx
 * @create 2020-12-02-9:37
 * @description
 */
public class TheSumOfThreeNums_15 {
    public static void main(String[] args) {
        int[] nums = new int[] {0,1,1};
        System.out.println(threeNums(nums));
    }

    public static List<List<Integer>> threeNums(int[] nums){
        Arrays.sort(nums);
        int len = nums.length;

        List<List<Integer>> list = new ArrayList<>();
        //第一个数从第一个开始进行循环
        for (int i = 0; i <len-2; i++) {
            if(i!=0&&(nums[i]==nums[i-1])){
                continue;
            }
            //初始右指针
            int right = len-1;
            for (int left = i+1 ; left < len-1; left++) {
                //如果当前数值和上一个相同，则继续加1
                if((left>i+1)&&nums[left]==nums[left-1]){
                    continue;
                }

                //如果当前和过大，移动右指针
                //这里存在一个隐藏的逻辑：如果右指针移动后和上一个数值相等会怎么样？
                //这里要明确，和是不可能为0的，因为如果和为0，那右指针不会移动
                //流程如下：如果和为0，那么第一次计算出来时将跳过此处判定，往下被记录
                //左指针移动，和必然变大；只有和大于0，此处右指针才会不断减小
                while(right>left&&(nums[i]+nums[left]+nums[right])>0){
                    right--;
                }


                //保证左指针在右指针左边
                if(left==right){
                    break;
                }
                //如果相等，将数组加入到列表中
                if((nums[i]+nums[left]+nums[right])==0){
                    list.add(Arrays.asList(nums[i],nums[left],nums[right]));
                }
            }
        }
        return list;
    }
}
