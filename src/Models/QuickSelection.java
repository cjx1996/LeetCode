package Models;

import org.junit.Test;

/**
 * @ClassName QuickSelection
 * @Description
 * @Author cjx
 * @Date 2022/6/28 21:41
 * @Version 1.0
 */
public class QuickSelection {


    @Test
    public void test() {
        int[] arr = new int[]{3, 2, 1, 5, 6, 4};
        int k = 2;
        System.out.println(quickSelection(0, arr.length - 1, k, arr));
    }


    public int quickSelection(int begin, int end, int k, int[] arr) {
        if (begin == end) return arr[begin];
        int i = begin, j = end, m = begin;
        int key = arr[m];
        while (i < j) {
            while (i < j && arr[j] >= key) {
                j--;
            }
            while (i < j && arr[i] <= key) {
                i++;
            }
            if (i < j) {
                int tem = arr[i];
                arr[i] = arr[j];
                arr[j] = tem;
            }
        }
        //无论选择的key是哪一个，最后一定要将其交换到分界坐标处
        arr[m] = arr[i];
        arr[i] = key;
        int cnt = end - j + 1;
        if (cnt == k) return arr[i];
        else if (cnt > k) return quickSelection(j+1, end, k, arr);
        else return quickSelection(begin, j - 1, k - cnt, arr);
    }

}
