package All_Problems;

import java.util.List;

/**
 * @ClassName Minimum_Time_Difference_539
 * @Description
 * @Author cjx
 * @Date 2022/1/18 10:53
 * @Version 1.0
 */
public class Minimum_Time_Difference_539 {
    public int findMinDifference(List<String> timePoints) {
        int[] cnt = new int[1440 * 2 + 1];
        for (String s : timePoints) {
            String[] ss = s.split(":");
            cnt[Integer.valueOf(ss[0]) * 60 + Integer.valueOf(ss[1])]++;
            cnt[Integer.valueOf(ss[0]) * 60 + Integer.valueOf(ss[1]) + 1440]++;
        }
        int last = -1, min = 1440;
        for (int i : cnt) {
            if (cnt[i] > 1) return 0;
            if (cnt[i] == 0) continue;
            if (last != -1) min = Math.min(min, i - last);
            last = i;
        }
        return min;
    }

    public int findMinDifference1(List<String> timePoints) {
        timePoints.sort((a, b) -> a.compareTo(b));
        String s1 = timePoints.get(0);
        String s2 = String.valueOf(Integer.valueOf(s1.substring(0, 2)) + 24) + s1.substring(2, 5);
        timePoints.add(s2);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < timePoints.size() - 1; i++) {
            min = Math.min(min, diff(timePoints.get(i), timePoints.get(i + 1)));
        }
        return min;
    }

    int diff(String t1, String t2) {
        int h = Integer.valueOf(t2.substring(0, 2)) - Integer.valueOf(t1.substring(0, 2));
        int m = Integer.valueOf(t2.substring(3, 5)) - Integer.valueOf(t1.substring(3, 5));
        return h * 60 + m;
    }
}
