package All_Problems;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Plates_Between_Candles_2055
 * @Description
 * @Author cjx
 * @Date 2022/3/8 9:15
 * @Version 1.0
 */
public class Plates_Between_Candles_2055 {
    @Test
    public void test() {
        String s = "**|**|***|";
        int[][] queries = new int[][]{
                {2, 5},
                {5, 9}
        };
        int[] ans = platesBetweenCandles(s, queries);
        for (int i : ans) {
            System.out.println(i);
        }
    }

    public int[] platesBetweenCandles(String s, int[][] queries) {
        char[] cs = s.toCharArray();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] == '|') list.add(i);
        }
        int n = queries.length;
        int[] ans = new int[n];
        if(list.isEmpty()) return ans;
        for (int i = 0; i < n; i++) {
            int[] query = queries[i];
            int lB = query[0], rB = query[1];
            int l = findMinMax(list, lB);
            int r = findMaxMin(list, rB);
            if (list.get(l) >= list.get(r) - 1) ans[i] = 0;
            else ans[i] = list.get(r) - list.get(l) - r + l;
        }
        return ans;
    }

    int findMinMax(List<Integer> list, int bound) {
        int l = 0, r = list.size()-1;
        while (l < r) {
            int m = l + (r - l) / 2;
            int index = list.get(m);
            if (index == bound) return m;
            else if (index < bound) l = m + 1;
            else r = m;
        }
        return l;
    }

    int findMaxMin(List<Integer> list, int bound) {
        int l = 0, r = list.size()-1;
        while (l < r) {
            int m = l + (r - l + 1) / 2;
            int index = list.get(m);
            if (index == bound) return m;
            else if (index < bound) l = m;
            else r = m - 1;
        }
        return l;
    }
}
