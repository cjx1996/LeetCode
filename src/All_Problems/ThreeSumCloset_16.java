package All_Problems;

import java.util.Arrays;

/**
 * @author cjx
 * @create 2020-12-11-14:41
 * @description
 */
public class ThreeSumCloset_16 {
    public static void main(String[] args) {
        int[] nums = new int[]{-1, 2, 1, -4};
        int target = 1;
        System.out.println(threeSumClosest1(nums, target));
    }

    public static int threeSumClosest1(int[] nums, int target) {
        //数组排序
        Arrays.sort(nums);
        //定义数组长度变量
        int len = nums.length;
        //定义最接近的数值
        int currCloset = 9999999;
        for (int i = 0; i < len - 2; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            //定义右指针的索引
            int right = len - 1;
            int currCloseH = 99999999;
            int currCloseL = -9999999;
            for (int left = i + 1; left < len - 1; left++) {
                //如果left在增长后数值与前一个相等，则退出本次循环
                if ((left > i + 1) && (nums[left] == nums[left - 1])) {
                    continue;
                }
                currCloseL = nums[i] + nums[left] + nums[right];
                //控制右指针左移
                while ((left < right) && (nums[i] + nums[left] + nums[right]) > target) {
                    currCloseH = nums[i] + nums[left] + nums[right];
                    right--;
                }//这里只要出现和的拐点就跳出本次遍历，不需要遍历完整个数组

                //如果左右指针不相等，左边极值赋值
                if (left != right) {
                    currCloseL = nums[i] + nums[left] + nums[right];
                }
                if ((Math.abs(target - currCloseH)) < (Math.abs(target - currCloset))) {
                    currCloset = currCloseH;
                }
                if ((Math.abs(target - currCloseL)) < (Math.abs(target - currCloset))) {
                    currCloset = currCloseL;
                }
                if (currCloset == target) {
                    return target;
                }
                if (left == right) {
                    break;
                }
            }

        }
        return currCloset;


    }


    public int threeSumClosest2(int[] nums, int target) {
        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left != right) {//这里需要遍历完整个数组
                int min = nums[i] + nums[left] + nums[left + 1];
                if (target < min) {
                    if (Math.abs(result - target) > Math.abs(min - target))
                        result = min;
                    break;
                }
                int max = nums[i] + nums[right] + nums[right - 1];
                if (target > max) {
                    if (Math.abs(result - target) > Math.abs(max - target))
                        result = max;
                    break;
                }
                int sum = nums[i] + nums[left] + nums[right];
                // 判断三数之和是否等于target
                if (sum == target)
                    return sum;
                //找到更好的解
                if (Math.abs(sum - target) < Math.abs(result - target))
                    result = sum;
                if (sum > target) {//若和比目标值大，右指针左移
                    right--;
                    while (left != right && nums[right] == nums[right + 1])//对于右指针前后重复的元素，跳开
                        right--;
                } else {//若和比目标值小，左指针右移
                    left++;
                    while (left != right && nums[left] == nums[left - 1])//对于左指针前后重复的元素，跳开
                        left++;
                }
            }
            while (i < nums.length - 2 && nums[i] == nums[i + 1])//对于第一个目标元素，如果前后重复，跳开
                i++;
        }
        return result;
    }


    public int threeSumCloset3(int[] nums,int target){
        Arrays.sort(nums);
        int result = nums[0]+nums[1]+nums[2];
        int len = nums.length;
        for(int i=0;i<len-2;i++){
            int left = i+1;
            int right = len-1;

            while(left!=right) {
                int min = nums[i] + nums[left] + nums[left + 1];
                if (target < min) {
                    if (Math.abs(result - target) > Math.abs(min - target))
                        result = min;

                    break;
                }
                int max = nums[i] + nums[right] + nums[right - 1];
                if (target > max) {
                    if (Math.abs(result - target) > Math.abs(max - target))
                        result = max;
                    break;
                }
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == target) {
                    return target;
                }
                if (Math.abs(result - target) > Math.abs(sum - target))
                    result = sum;
                if (sum > target) {
                    right--;
                    while (left > right && nums[right] == nums[right + 1])
                        right--;
                } else {
                    left++;
                    while (left > right && nums[left] == nums[left - 1])
                        left++;
                }
            }
        //这里要提出一种比较，除了在末尾加上下面代码，还有一种方案：
//            while(i>0&&nums[i]==nums[i-1]){
//                i++;
//            }
            //上述代码如果放在for循环顶部，也可以起到防止两次i对应数字相同的问题，但上面方案有个问题
            //假设num[len-3]==nums[len-4]，那么i取len-3时，i自增变为len-2，此时i超限，却进行了循环

            //相反，有一种等价方法为：
//            while(i>0&&nums[i]==nums[i-1]){
//                continue;
//            }
            //这种代码虽然功能上等价，但是相比于下面的代码，美观性和流畅性差了很多
        while(i<len&&nums[i]==nums[i+1]){
            i++;
        }

        }
        return result;
    }

}