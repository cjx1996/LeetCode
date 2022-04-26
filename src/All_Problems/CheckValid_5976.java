package All_Problems;

/**
 * @ClassName CheckValid_5976
 * @Description
 * @Author cjx
 * @Date 2022/1/9 10:39
 * @Version 1.0
 */
public class CheckValid_5976 {
    int[][] matrix;
    public boolean checkValid(int[][] matrix){
        this.matrix= matrix;
        int  n= matrix.length;
        for (int i = 0; i < n; i++) {
            if(!check(i))return false;
        }
        return true;
    }
    boolean check(int j){
        int n = matrix.length;
        int[] cnt1 = new int[n];
        int[] cnt2 = new int[n];
        for (int i = 0; i < n; i++) {
            cnt1[matrix[j][i]-1]++;
            cnt2[matrix[i][j]-1]++;

        }
        for (int i = 0; i < n; i++) {
            if(cnt1[i]!=1) return false;
            if(cnt2[j]!=1) return false;
        }
        return true;
    }

}
