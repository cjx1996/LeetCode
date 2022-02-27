import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * @ClassName Knight_Probability_in_Cheseboard_688
 * @Description
 * @Author cjx
 * @Date 2022/2/17 11:24
 * @Version 1.0
 */
public class Knight_Probability_in_Cheseboard_688 {


    @Test
    public void test() {
        System.out.println(knightProbability(3, 2, 0, 0));
    }

    int[][] dirs = new int[][]{
            {2, 1},
            {2, -1},
            {-2, 1},
            {-2, -1},
            {-1, 2},
            {1, 2},
            {-1, -2},
            {1, -2}
    };


    public double knightProbability(int n, int k, int row, int column) {
        double[][] grid1 = new double[n][n], grid2 = new double[n][n];
        double[][] result = grid1;
        grid1[row][column] = 1;
        for (int i = 0; i < k; i++) {
            if(i%2==0){
                calculate(grid1,grid2);
                result= grid2;
            }else{
                calculate(grid2,grid1);
                result=grid1;
            }
        }

        double ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ans+=result[i][j];
            }
        }
        return ans;
    }

    void calculate(double[][] origin, double[][] target) {
        int n = target.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                target[i][j]=0;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (origin[i][j] > 0) {
                    for (int[] dir : dirs) {
                        int dx = dir[0], dy = dir[1];
                        int nx = i + dx, ny = j + dy;
                        if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                        target[nx][ny] += origin[i][j] /8;
                    }
                }

            }
        }
    }
}