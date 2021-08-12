import org.junit.Test;

/**
 * @ClassName Rotate_Array_189
 * @Description
 * @Author cjx
 * @Date 2021/8/6 22:59
 * @Version 1.0
 */
public class Rotate_Array_189 {
    @Test
    public void test() {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        rotate1(nums, 3);
        for (int num : nums) {
            System.out.println(num);
        }
    }

    //翻转全部 + 翻转前一部分 + 翻转后一部分
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        reverse(nums, 0, n);
        reverse(nums, 0, k);
        reverse(nums, k, n);
    }

    void reverse(int[] nums, int start, int end) {
        int l = start, r = end - 1;
        while (l < r) {
            nums[l] ^= nums[r];
            nums[r] ^= nums[l];
            nums[l] ^= nums[r];
            l++;
            r--;
        }
    }

    //环状替换
    public void rotate1(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        int count = gcd(n, k);
        for (int i = 0; i < count; i++) {

            int tem = nums[i];
            int index = k + i;
            for (int j = 0; j < (n / count); j++) {
                index %= n;
                tem ^= nums[index];
                nums[index] ^= tem;
                tem ^= nums[index];
                index += k;
            }
        }
    }

    int gcd(int x, int y) {
        return y > 0 ? gcd(y, x % y) : x;
    }
}
