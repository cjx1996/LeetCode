/**
 * @ClassName Search_a_2D_Matrix_74
 * @Description
 * @Author cjx
 * @Date 2021/7/17 11:44
 * @Version 1.0
 */
public class Search_a_2D_Matrix_74 {
    public boolean searchMatrix(int[][] matrix,int target){
        //行数
        int row = matrix.length;
        //列数
        int col = matrix[0].length;
        //总个数
        int len = row*col;
        int l =0;
        int r= len-1;
        while(l<=r){
            int mid = l+(r-l)/2;
            int i = mid/col;
            int j = mid%col;
            if(matrix[i][j]==target) return true;
            if(matrix[i][j]>target) r= mid-1;
            else l = mid+1;
        }
        return false;
    }
}
