package All_Problems;

import org.junit.Test;

import java.util.ArrayDeque;

/**
 * @ClassName Flood_Fill_733
 * @Description
 * @Author cjx
 * @Date 2021/8/11 22:11
 * @Version 1.0
 */
public class Flood_Fill_733 {
    @Test
    public void test() {
        int[][] image = new int[][]{
                {0, 0, 0},
                {0, 0, 0}
        };
        floodFill(image, 0, 0, 2);
        for (int[] row : image) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        bfs(image, sr, sc, newColor, image[sr][sc]);
        return image;
    }

    void bfs(int[][] image, int sr, int sc, int newColor, int oldColor) {
        if (sr < 0 || sr == image.length || sc < 0 || sc == image[0].length || image[sr][sc] != oldColor || image[sr][sc] == newColor)
            return;
        image[sr][sc] = newColor;
        bfs(image, sr - 1, sc, newColor, oldColor);
        bfs(image, sr + 1, sc, newColor, oldColor);
        bfs(image, sr, sc - 1, newColor, oldColor);
        bfs(image, sr, sc + 1, newColor, oldColor);
    }

}
