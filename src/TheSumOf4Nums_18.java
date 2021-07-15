import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author cjx
 * @create 2021-01-07-9:26
 * @description 给定一个数组int[] nums，一个target int，返回所有4个之和等于target的不同组合
 */
public class TheSumOf4Nums_18 {

    @Test
    public void test(){
        int[] nums=new int[]{1,4,-3,0,0,0,5,0};

        int target = 0;
        List<List<Integer>> lists = fourSum(nums, target);
        for (List<Integer> iterator:lists
             ) {
            System.out.println(iterator);

        }
    }


    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> resultList = new ArrayList<>();
        int length = nums.length;
        Arrays.sort(nums);
        if(length<4)return resultList;
        for (int i = 0; i < length - 3; i++) {
            int currNum = nums[i];
            List<List<Integer>> list = threeSum(Arrays.copyOfRange(nums,i+1,length),target-currNum);
            if(list.size()==0)//如果为空，结束本次遍历
                continue;
            for (int j = 0; j < list.size(); j++) {
                List<Integer> iterator=list.get(j);

                iterator.add((Integer)currNum);
                resultList.add(iterator);
            }
            while(i<length-1&&nums[i]==nums[i+1]){
                i++;
            }
        }
        return resultList;
    }


    public static List<List<Integer>> threeSum(int[] nums, int target) {
        //定义结果集变量
        List<List<Integer>> list = new ArrayList<>();
        //得到数组的长度
        int length = nums.length;
        //将数组排序
        Arrays.sort(nums);
        if (length <= 2) return null;
        //第一个元素沿数组遍历
        for (int i = 0; i < length - 2; i++) {

            int right = length - 1;
            for (int left = i + 1; left < right; left++) {
                if (left > i + 1 && nums[left] == nums[left - 1]) {
                    continue;
                }
                while (left != right && (nums[i] + nums[left] + nums[right]) > target) {
                    right--;
                }
                if (left == right) {
                    break;
                }

                if (nums[i] + nums[left] + nums[right] == target) {
                    list.add(new ArrayList(Arrays.asList(new Integer[]{nums[i], nums[left], nums[right]})));
                }


            }
            //如果后一个数值和当前数值相等，第一个元素指针后移一个
            while (i < length - 1 && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return list;
    }


}
