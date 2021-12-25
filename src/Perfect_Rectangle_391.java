import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @ClassName Perfect_Rectangle_391
 * @Description
 * @Author cjx
 * @Date 2021/11/16 17:29
 * @Version 1.0
 */
public class Perfect_Rectangle_391 {
    @Test
    public void test() {
        int[][] rectangle = new int[][]{
                {1, 1, 3, 3},
                {3, 1, 4, 2},
                {3, 2, 4, 4},
                {1, 3, 2, 4},
                {2, 3, 3, 4}
        };
        System.out.println(isRectangleCover(rectangle));
    }

    public boolean isRectangleCover(int[][] rectangle) {
        long area = 0;
        int minX = rectangle[0][0], minY = rectangle[0][1], maxX = rectangle[0][2], maxY = rectangle[0][3];
        Map<Point, Integer> cnt = new HashMap<>();
        for (int[] rec : rectangle) {
            int a = rec[0], b = rec[1], c = rec[2], d = rec[3];
            minX = Math.min(minX, a);
            minY = Math.min(minY, b);
            maxX = Math.max(maxX, c);
            maxY = Math.max(maxY, d);
            cnt.put(new Point(a, b), cnt.getOrDefault(new Point(a, b), 0) + 1);
            cnt.put(new Point(a, d), cnt.getOrDefault(new Point(a, d), 0) + 1);
            cnt.put(new Point(c, b), cnt.getOrDefault(new Point(c, b), 0) + 1);
            cnt.put(new Point(c, d), cnt.getOrDefault(new Point(c, d), 0) + 1);
            area += new Point(a, b).area(new Point(c, d));

        }
        if (area != new Point(minX, minY).area(new Point(maxX, maxY)) ||
                cnt.getOrDefault(new Point(minX, minY), 0) != 1 ||
                cnt.getOrDefault(new Point(minX, maxY), 0) != 1 ||
                cnt.getOrDefault(new Point(maxX, minY), 0) != 1 ||
                cnt.getOrDefault(new Point(maxX, maxY), 0) != 1
        ) {
            return false;
        }
        cnt.remove(new Point(minX, minY));
        cnt.remove(new Point(minX, maxY));
        cnt.remove(new Point(maxX, minY));
        cnt.remove(new Point(maxX, maxY));
        for (Integer value : cnt.values()) {
            if (value != 2 && value != 4) {
                return false;
            }
        }
        return true;
    }

    class Point {
        int x = 0;
        int y = 0;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof Point)) {
                return false;
            }
            Point p2 = (Point) obj;
            return this.x == p2.x && this.y == p2.y;
        }

        int area(Point p2) {
            return (Math.abs(this.x - p2.x) * Math.abs(this.y - p2.y));
        }
    }
}
