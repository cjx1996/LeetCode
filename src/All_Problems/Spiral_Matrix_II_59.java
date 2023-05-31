package All_Problems;

import org.junit.Test;

/**
 * @ClassName Spiral_Matrix_II_59
 * @Description
 * @Author cjx
 * @Date 2023/5/29 22:48
 * @Version 1.0
 */
public class Spiral_Matrix_II_59 {

    @Test
    public void test(){
        int n=3;
        int[][] ans = generateMatrix(n);
        for (int[] an : ans) {
            for (int i : an) {
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int[][] dirs = {
                {0, 1},
                {1, 0},
                {0, -1},
                {-1, 0}
        };
        int[] dir = dirs[0];
        int index = 0;
        int x = 0, y = -1;
        for (int i = 1; i <= n * n; i++) {
            int nx = x + dir[0], ny = y + dir[1];
            if (nx < 0 || nx >= n || ny < 0 || ny >= n || ans[nx][ny] != 0) {
                dir = dirs[(++index) % 4];
                nx = x + dir[0];
                ny = y + dir[1];
            }
            ans[nx][ny]=i;
            x=nx;
            y=ny;
        }
        return ans;
    }

}
