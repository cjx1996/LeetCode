package Models;

/**
 * @ClassName QuickSort
 * @Description
 * @Author cjx
 * @Date 2022/4/29 16:50
 * @Version 1.0
 */
public class QuickSort {
    /**
     * @author Ye Hongzhi 公众号：java技术爱好者
     * @name SelectSort
     * @date 2020-09-06 22:27
     **/


    public static void main(String[] args) {
        QuickSort sort = new QuickSort();
      /*  int n =800;
        int[] nums=new int[n];
        for (int i = 0; i < n; i++) {
            nums[i]=(int)(Math.random()*800);
        }*/
        int[] nums=new int[]{10,20,30,0,50,55,2,22};
        sort.sort(nums);
        for (int i : nums) {
            System.out.println(i);
        }
    }


    protected void sort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        quickSort(nums, 0, nums.length - 1);
    }

    private void quickSort(int[] nums, int star, int end) {
        if (star > end) {
            return;
        }
        int i = star;
        int j = end;
        int key = nums[star];
        while (i < j) {
            //这里必须先自减j不能先自增i
            while (i < j && nums[j] > key) {
                j--;
            }
            while (i < j && nums[i] <= key) {
                i++;
            }
            if (i < j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        nums[star] = nums[i];
        nums[i] = key;
        quickSort(nums, star, i - 1);
        quickSort(nums, i + 1, end);
    }
//10万个数的数组，耗时：50毫秒
}
