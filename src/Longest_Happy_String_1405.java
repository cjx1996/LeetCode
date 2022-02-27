import org.junit.Test;

import java.util.PriorityQueue;

/**
 * @ClassName Longest_Happy_String_1405
 * @Description
 * @Author cjx
 * @Date 2022/2/7 10:25
 * @Version 1.0
 */
public class Longest_Happy_String_1405 {
    @Test
    public void test() {
        System.out.println(longestDiverseString(2,2,1));
    }

    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<int[]> q = new PriorityQueue<>((i, j) -> (j[1] - i[1]));
        StringBuilder ans = new StringBuilder();
        if (a != 0) q.add(new int[]{'a', a});
        if (b != 0) q.add(new int[]{'b', b});
        if (c != 0) q.add(new int[]{'c', c});
        while (!q.isEmpty()) {
            int[] tem1 = q.poll();
            int[] tem2 = new int[0];
            int n = ans.length();
            if (n >= 2 && ans.charAt(n - 1) == ans.charAt(n - 2) && ans.charAt(n - 1) == tem1[0]) {
                tem2 = tem1;
                if (q.isEmpty()) break;
                tem1 = q.poll();
                q.add(tem2);
            }
            ans.append((char) tem1[0]);
            if (--tem1[1] > 0) q.add(tem1);
        }
        return ans.toString();
    }
}
