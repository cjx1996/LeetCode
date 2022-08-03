package All_Problems;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * @ClassName Orderly_Queue_899
 * @Description
 * @Author cjx
 * @Date 2022/8/3 14:43
 * @Version 1.0
 */
public class Orderly_Queue_899 {
    @Test
    public void test() {
        String s = "cba";
        int k = 1;
        System.out.println(orderlyQueue(s, k));
    }

    public String orderlyQueue(String s, int k) {
        int n = s.length();
        char[] cs = s.toCharArray();
        if (k > 1) {
            Arrays.sort(cs);
            return String.valueOf(cs);
        }

        //时间复杂度为O(n^2)的方法
        /*
        ArrayDeque<Integer> q1 = new ArrayDeque<>();
        ArrayDeque<Integer> q2 = new ArrayDeque<>();
        int cur = 'z' + 1;
        for (int i = 0; i < n; i++) {
            if (cs[i] < cur) {
                cur = cs[i];
                q1.clear();
                q1.add(i);
            } else if (cs[i] == cur) {
                q1.add(i);
            }
        }
        int offset = 1;
        while (q1.size() > 1 && offset < n - 1) {
            cur = 'z' + 1;
            while (!q1.isEmpty()) {
                int tem = q1.poll();
                if (cs[(tem + offset) % n] < cur) {
                    q2.clear();
                    q2.add(tem);
                    cur = cs[(tem + offset) % n];
                } else if (cs[(tem + offset) % n] == cur) {
                    q2.add(tem);
                }
            }
            q1 = q2.clone();
            offset++;
        }
        int po = q1.poll();
        return s.substring(po) + s.substring(0, po);*/

        //最小表示法
        int i = 0, j = 1, d = 0;
        while (i < n && j < n && d < n) {
            char a = cs[(i + d) % n], b = cs[(j + d) % n];
            if (a == b) d++;
            else {
                if (a > b) i += d + 1;
                else j += d + 1;
                d = 0;
                if (i == j) i++;
            }
        }
        i = Math.min(i, j);
        return s.substring(i) + s.substring(0, i);
    }

}
