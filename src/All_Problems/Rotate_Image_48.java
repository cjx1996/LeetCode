package All_Problems;

/**
 * @ClassName Rotate_Image_48
 * @Description
 * @Author cjx
 * @Date 2021/11/12 17:36
 * @Version 1.0
 */
public class Rotate_Image_48 {
    public void rotate(int[][] matrix) {
        int n = matrix.length - 1;
        boolean[][] used = new boolean[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                int x = i, y = j;
                int tem = matrix[x][y];
                while (!used[x][y]) {
                    int ex = tem;
                    tem = matrix[y][n - x];
                    matrix[y][n - x] = ex;
                    used[x][y] = true;
                    ex = y;
                    y = n - x;
                    x = ex;
                }
            }
        }
    }
}
