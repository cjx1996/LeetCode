package Contest;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName findInde_6356
 * @Description
 * @Author cjx
 * @Date 2023/2/12 11:17
 * @Version 1.0
 */
public class findIndex_6356 {
    @Test
    public void test() {
        String s = "101101";
        int[][] queries = new int[][]{
                {0,5},
                {1,2}
        };
        int[][] ans = substringXorQueries(s, queries);
        for (int[] res : ans) {
            System.out.print(res[0]);
            System.out.print(",");
            System.out.println(res[1]);
        }
    }


    public int[][] substringXorQueries(String s, int[][] q) {
        int len = q.length;
        int[][] ret = new int[len][2];
        int i = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int l = 1; l <= 31; l++) {
            for (int j = 0; j + l <= s.length(); j++) {
                int t = Integer.parseInt(s.substring(j, j + l), 2);
                map.putIfAbsent(t, j);
            }
        }
        for (int[] d : q) {
            int l = d[0], r = d[1];
            int t = r ^ l;
            int le = Integer.toBinaryString(t).length();
            int idx = map.getOrDefault(t, -1);
            if (idx >= 0 && idx < s.length()) {
                ret[i][0] = idx;
                ret[i][1] = idx + le - 1;
            } else {
                ret[i][0] = -1;
                ret[i][1] = -1;
            }
            i++;
        }
        return ret;
    }
}




