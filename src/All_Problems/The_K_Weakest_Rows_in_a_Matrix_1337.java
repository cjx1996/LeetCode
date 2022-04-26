package All_Problems;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName The_K_Weakest_Rows_in_a_Matrix_1337
 * @Description TODO 本题目涉及一个子问题：快速选择，以后要研究学习
 * @Author cjx
 * @Date 2021/8/1 11:34
 * @Version 1.0
 */
public class The_K_Weakest_Rows_in_a_Matrix_1337 {
    @Test
    public void test() {
        int[][] mat = new int[][]{
                {1, 0},
                {1, 0},
                {1, 0},
                {1, 1}

        };
        int[] ans = kWeakestRows(mat, 4);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }
    }


    public int[] kWeakestRows(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        int[] sum = new int[m];
        //读取每行共有多少个1
        for (int i = 0; i < m; i++) {
            int low = 0;
            int high = n-1;
            while(low<high){
                int mid = low+(high-low)/2;
                if(mat[i][mid]==1){
                    low = mid+1;
                }else{
                    high = mid;
                }
            }
            sum[i] = low;
        }
        for (int i = 0; i < sum.length; i++) {
            sum[i] = sum[i]*100+i;
        }
        Arrays.sort(sum);
        for (int i = 0; i < k; i++) {
            sum[i] %=100;
        }
        return Arrays.copyOf(sum,k);
    }

    public int[] kWeakestRows1(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        int[] sum = new int[m];
        //对数组计数可以使用二分法,而不必挨个搜索
        for (int i = 0; i < m; i++) {
            int num = 0;
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    num++;
                }
            }
            sum[i] = num;
        }
        List<Integer> ans = new ArrayList<>();

        //排序
        for (int i = 0; i < m; i++) {

            int low = 0;
            int high = Math.min(ans.size() - 1, k - 1);

            if (high == 0) low = (sum[ans.get(0)] <= sum[i]) ? 1 : 0;
            if (high == k - 1 && sum[ans.get(high)] <= sum[i]) continue;


            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (sum[ans.get(mid)] <= sum[i]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }

            }
            if (low == ans.size()) {
                ans.add(i);
            } else {
                ans.add(low, i);
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = ans.get(i);
        }
        return res;
    }


}
