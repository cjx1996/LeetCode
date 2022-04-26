package All_Problems;

/**
 * @ClassName Convert_1D_Array_Into_2D_Array_2022
 * @Description
 * @Author cjx
 * @Date 2022/1/1 10:27
 * @Version 1.0
 */
public class Convert_1D_Array_Into_2D_Array_2022 {
    public int[][] construct2DArray(int[] original,int m,int n){
        if(original.length!=m*n) return new int[0][0];
        int[][] ans = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans[i][j] = original[i*n+j];
            }
        }
        return ans;
    }
}
