package All_Problems;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @ClassName Merge_Intervals_56
 * @Description
 * @Author cjx
 * @Date 2022/4/16 16:38
 * @Version 1.0
 */
public class Merge_Intervals_56 {
    @Test
    public void test(){
        int[][] intervals = new int[][]{

                {7,9},
                {1,5},
                {4,6},
                {9,10}
        };
        for (int[] interval : merge(intervals)) {
            System.out.println(interval[0] + " "+interval[1]);
        }
    }
    //左界排序
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (o1,o2)->o1[0]-o2[0]);
        List<int[]> list = new ArrayList<>();
        list.add(intervals[0]);
        for(int i=1;i<intervals.length;i++){
            int[] cur = intervals[i];
            int left = cur[0];
            int[] last = list.get(list.size()-1);
            int right = last[1];
            if(left>right) list.add(cur);
            else last[1] = Math.max(last[1],cur[1]);
        }
        int[][] ans=  new int[list.size()][2];
        int i = 0;
        for (int[] interval : list) {
            ans[i++] = interval;
        }
        return ans;
    }
    //前缀和，比较复杂
    /*public int[][] merge(int[][] intervals) {
        int[] suffix = new int[20002];
        for (int[] interval : intervals) {
            int start = interval[0], end = interval[1];
            suffix[start*2 ]++;
            suffix[2*end + 1]--;
        }
        List<int[]> list = new ArrayList<>();
        int sum = 0;
        int start = -1;
        for (int i = 0; i < suffix.length; i++) {
            int cur = suffix[i];
            sum += cur;
            if (sum == cur && sum > 0) start = i/2 ;
            if (sum == 0 && cur < 0) list.add(new int[]{start, i/2});
        }
        int[][] ans = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
*/
}
