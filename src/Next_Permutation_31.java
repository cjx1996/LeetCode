import org.junit.Test;

import java.util.jar.JarEntry;

/**
 * @ClassName Next_Permutation_31
 * @Description TODO
 * @Author cjx
 * @Date 2021/7/15 16:04
 * @Version 1.0
 */
public class Next_Permutation_31 {
    @Test
    public void test() {
        int[] nums = new int[]{1, 3, 2};
        nextPermutation(nums);
        for (int num:nums){
            System.out.println(num);
        }
    }

    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int left = n - 2;

        while(left>=0&&nums[left]>=nums[left+1]){
            left--;
        }

        if (left != -1) {
            int right = n - 1;
            while (right>=0&&nums[right]<=nums[left]) {
                right--;
            }
            swap(nums,left,right);
        }

        reverse(nums,left+1);


    }

    void swap(int[] nums,int i,int j){
        nums[i] ^=nums[j];
        nums[j] ^=nums[i];
        nums[i] ^=nums[j];
    }
    void reverse(int[] nums,int start){
        int n = nums.length-1;
        while (start<n){
            swap(nums,start, n);
            n--;
            start++;
        }
    }
}
