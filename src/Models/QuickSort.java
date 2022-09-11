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

        int[] arr=new int[]{3,5,1,6,7,-1};
        sort.sort(arr);
        for (int i : arr) {
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
            //从右向左找出第一个比key小的数据
            while (i < j && nums[j] > key) {
                j--;
            }
            //这里和上面必须有一个是有等号的
            //从左向右找到第一个比key大的数据
            while (i < j && nums[i] <= key) {
                i++;
            }
            //没有过界则交换
            if (i < j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        //将分界值与当前指针数据交换
        nums[star] = nums[i];
        nums[i] = key;
        //对左右两边数组进行排序
        quickSort(nums, star, i - 1);
        quickSort(nums, i + 1, end);
    }
}
