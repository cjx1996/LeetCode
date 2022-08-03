package All_Problems;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @ClassName Set_Intersection_Size_At_Least_Two_757
 * @Description
 * @Author cjx
 * @Date 2022/7/22 10:46
 * @Version 1.0
 */
public class Set_Intersection_Size_At_Least_Two_757 {
    @Test
    public void test() {
        int[][] intervals = new int[][]{
                {1, 2},
                {2, 3},
                {2, 4},
                {4, 5}
        };
        System.out.println(intersectionSizeTwo(intervals));
    }

    //倒序操作
/*    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] != b[0]) return b[0] - a[0];
            else return a[1] - b[1];
        });
        int ans = 0;
        int min = Integer.MAX_VALUE, sMin = Integer.MAX_VALUE;
        for (int i = 0; i < intervals.length; i++) {
            int[] tem = intervals[i];
            if (tem[1] < min) {
                min = tem[0];
                sMin = tem[0] + 1;
                ans += 2;
            } else if (tem[1] < sMin) {
                sMin = min;
                min = tem[0];
                ans++;
            }
        }
        return ans;
    }*/
    //修改为正序操作
    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[1] != b[1]) return a[1] - b[1];
            else return b[0] - a[0];
        });
        int ans = 0;
        int sMax = -1, max = -1;
        for (int i = 0; i < intervals.length; i++) {
            int[] tem = intervals[i];
            if (tem[0] > max) {
                sMax = tem[1] - 1;
                max = tem[1];
                ans += 2;
            } else if (tem[0] > sMax) {
                sMax = max;
                max = tem[1];
                ans += 1;
            }
        }
        return ans;
    }

}
