package All_Problems;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName InsertInterval_57
 * @Description
 * @Author cjx
 * @Date 2023/5/18 22:39
 * @Version 1.0
 */
public class InsertInterval_57 {
    @Test
    public void test() {
        int[][] intervals = new int[][]{
                {1, 3},
                {6, 9}
        };
        int[] newInterval = new int[]{2, 5};
        int[][] res = insert(intervals, newInterval);
        for (int[] re : res) {
            for (int i : re) {
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        int a = newInterval[0], b = newInterval[1];
        boolean flag = false;
        int is = -1, ie = -1;
        int n = intervals.length;
        for (int[] interval : intervals) {
            int c = interval[0], d = interval[1];
            if (flag) {
                list.add(interval);
                continue;
            }
            if (b < c) {
                if (is < 0) is = a;
                if (ie < 0) ie = b;
                if (ie >= 0 && is >= 0) {
                    list.add(new int[]{is, ie});
                    flag = true;
                }
                list.add(interval);
            } else if (d < a) {
                list.add(interval);
            } else {
                if (a <= c && is < 0) is = a;
                if (a >= c && a <= d) is = c;
                if (b >= c && b <= d) ie = d;
                if (ie >= 0 && is >= 0) {
                    list.add(new int[]{is, ie});
                    flag = true;
                }
            }
        }
        if(ie<0){
            if(is<0) list.add(new int[]{a,b});
            else list.add(new int[]{is,b});
        }
        int[][] res = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }


}
