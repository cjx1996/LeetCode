package All_Problems;

import org.junit.Test;

import java.sql.SQLOutput;

/**
 * @ClassName Max_Increase_to_Keep_City_Skeyline_807
 * @Description
 * @Author cjx
 * @Date 2021/12/13 16:36
 * @Version 1.0
 */
public class Max_Increase_to_Keep_City_Skeyline_807 {
    @Test
    public void test(){
    int[][] grid= new int[][]{
            {3,0,8,4},
            {2,4,5,7},
            {9,2,6,3},
            {0,3,1,0}
    };
        System.out.println(maxIncreaseKeepingSkyline(grid));
    }
    public int maxIncreaseKeepingSkyline(int[][] grid){
        int len = grid.length;
        int[] row = new int[len];
        int[] col = new int[len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                row[i]= Math.max(row[i],grid[i][j]);

                col[i] = Math.max(col[i],grid[j][i]);

            }
        }
        int ans = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                ans += Math.min(row[i],col[j])-grid[i][j];
            }
        }
        return ans;
    }
}
