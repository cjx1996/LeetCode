package All_Problems;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName Maximum_Number_of_Visible_Pooints_1610
 * @Description  滑动窗口 + 数学 (atan2) + 排序 TODO 可以使用list存储角度，可以简便语句
 * @Author cjx
 * @Date 2021/12/16 17:33
 * @Version 1.0
 */
public class Maximum_Number_of_Visible_Pooints_1610 {
    @Test
    public void test() {
        List<List<Integer>> points = new ArrayList<>();
        int[][] p = new int[][]{
                {2, 1},
                {2, 2},
                {3, 3}
        };
        for (int i = 0; i < p.length; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(p[i][0]);
            list.add(p[i][1]);
            points.add(list);
        }
        int angle = 90;
        List<Integer> location = new ArrayList<>();
        location.add(1);
        location.add(1);
        System.out.println(visiblePoints(points, angle, location));

    }


    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        int x = location.get(0), y = location.get(1);
        int con = 0;
        for (int i = 0; i < points.size(); i++) {
            int px = points.get(i).get(0), py = points.get(i).get(1);
            if (px == x && py == y) {
                con++;
                points.remove(i);
            }
        }
        int len = points.size();
        double[] angles = new double[len];
        for (int i = 0; i < len; i++) {
            int px = points.get(i).get(0), py = points.get(i).get(1);
            angles[i] = Math.atan2(py - y, px - x);
        }
        Arrays.sort(angles);
        angles = Arrays.copyOf(angles, 2 * len);
        for (int i = len; i < 2 * len; i++) {
            angles[i] = angles[i - len] + 2 * Math.PI;
        }
        double dAngle = angle / 180.0 * Math.PI;
        int ans = 0;
        for (int l = 0, r = 0; l < len; l++) {
            while (angles[r] - angles[l] <= dAngle) {
                r++;
            }
            ans = Math.max(ans, r - l);
        }
        return con + ans;
    }
}
