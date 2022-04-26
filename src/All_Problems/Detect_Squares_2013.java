package All_Problems;

import org.junit.Test;

import java.util.Arrays;

/**
 * @ClassName Detect_Squares_2013
 * @Description
 * @Author cjx
 * @Date 2022/1/26 10:08
 * @Version 1.0
 */
public class Detect_Squares_2013 {
    @Test
    public void test(){
        DetectSquares detectSquares = new DetectSquares();
        detectSquares.add(new int[]{5,10});
        detectSquares.add(new int[]{10,5});
        detectSquares.add(new int[]{10,10});
        detectSquares.add(new int[]{3,0});
        detectSquares.add(new int[]{8,0});
        detectSquares.add(new int[]{8,5});
        detectSquares.add(new int[]{9,0});
        detectSquares.add(new int[]{9,8});
        detectSquares.add(new int[]{1,8});
        detectSquares.add(new int[]{0,0});
        detectSquares.add(new int[]{8,0});
        detectSquares.add(new int[]{8,8});
        System.out.println(detectSquares.count(new int[]{0,8}));
    }
    private class DetectSquares {
        int[][] points;

        public DetectSquares() {
            points = new int[1001][1001];
        }

        public void add(int[] point) {
            int x = point[0], y = point[1];
            points[x][y]++;
        }

        public int count(int[] point) {
            int[] xs = new int[1001], ys = new int[1001];
            int x = point[0], y = point[1];
            for (int i = 0; i < 1001; i++) {
                if (points[x][i] > 0) {
                    ys[i] = points[x][i];
                }
                if (points[i][y] > 0) {
                    xs[i] = points[i][y];
                }
            }

            xs[x] = 0;
            ys[y] = 0;

            int ans = 0;
            for (int i = 0; i < 1001; i++) {
                if(xs[i]==0) continue;
                int len = x-i;
                int[] nums=new int[]{y-len,y+len};
                for (int j :nums) {
                    if(ys[j]==0) continue;
                    if (points[i][j] > 0) {
                        ans += xs[i] * ys[j] * points[i][j];
                    }
                }
            }
            return ans;
        }
    }
}
