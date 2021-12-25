import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @ClassName Maximum_Number_of_Eaten_Apples_1705
 * @Description
 * @Author cjx
 * @Date 2021/12/24 10:29
 * @Version 1.0
 */
public class Maximum_Number_of_Eaten_Apples_1705 {
    @Test
    public void test() {
        int[] apples = new int[]{1, 2, 3, 5, 2};
        int[] days = new int[]{3, 2, 1, 4, 2};
        System.out.println(eatenApples(apples, days));
    }

    public int eatenApples(int[] apples, int[] days) {
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>((a, b) -> a[0] - b[0]);
        int ans = 0, day = apples.length, i = 0;
        while (i < day || !queue.isEmpty()) {
            if (i < day && apples[i] != 0) {
                queue.add(new int[]{i + days[i] - 1, apples[i]});
            }
            while (!queue.isEmpty() && queue.peek()[0] < i) queue.poll();
            if (!queue.isEmpty()) {
                if (queue.peek()[1] > 1) queue.peek()[1]--;
                ans++;
            }
            i++;
        }
        return ans;
    }
}
