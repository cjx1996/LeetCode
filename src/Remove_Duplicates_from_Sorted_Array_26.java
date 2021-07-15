import org.junit.Test;

/**
 * @ClassName Remove_Duplicates_from_Sorted_Array_26
 * @Description TODO
 * @Author cjx
 * @Date 2021/5/27 12:49
 * @Version 1.0
 */
public class Remove_Duplicates_from_Sorted_Array_26 {

    @Test
    public void test() {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 2, 3, 4};
        int len = removeDuplicates(nums);
        for (int i = 0; i < len; i++) {
            System.out.print(nums[i] + " ");
        }
    }


    //给定的数组是有序的，这个方法还适用于有序数组，方法效率差
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                int result = nums[i] ^ nums[j];
                if (result == 0) {
                    for (int k = j; k < len - 1; k++) {
                        nums[k] = nums[k + 1];
                    }
                    len--;
                    j--;
                }
            }
        }
        return len;
    }
    @Test
    public void test2() {
        int[] nums = {};
        int len = removeDuplicates1(nums);
        for (int i = 0; i < len; i++) {
            System.out.print(nums[i] + " ");
        }
    }
    //针对输入是有序数组进行了优化，时间复杂度为O(n)，空间复杂度为O(1)
    public int removeDuplicates1(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len-1; i++) {
            int result = nums[i] ^ nums[i+1];
            if (result == 0) {
                for (int k = i+1; k < len - 1; k++) {
                    nums[k] = nums[k + 1];
                }
                len--;
                i--;
            }
        }
        return len;
    }
    @Test
    public void test3() {
        int[] nums = {0,1,1,1,2,2,2,3,4,4,5,6,6,6,7};
        int len = removeDuplicates2(nums);
        for (int i = 0; i < len; i++) {
            System.out.print(nums[i] + " ");
        }
    }
    //相比于removeDuplicates1，本方法减少了发现一个重复数值，就将后续所有数值前移的这样一个操作，减少了时间复杂度
    public int removeDuplicates2(int[] nums){
        int slow=0;
        for(int fast=0;fast<nums.length;fast++){
            if(fast==0||nums[fast-1]!=nums[fast]) nums[slow++]=nums[fast];
        }
        return slow;
    }


}
