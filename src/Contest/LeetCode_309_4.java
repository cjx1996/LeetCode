package Contest;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @ClassName LeetCode_309_4
 * @Description 本题中堆中的数组第一个元素是房间号，int就可以，但是第二个元素是房间最近一次的结束时间，超出int范围必须使用long才可以
 * @Author cjx
 * @Date 2022/9/4 15:29
 * @Version 1.0
 */
public class LeetCode_309_4 {
    @Test
    public void test() {
        int n = 2;
        int[][] meetings = new int[][]{
                {0, 10}, {1, 5}, {2, 7}, {3, 4}
        };
        System.out.println(mostBooked(n, meetings));
    }

    public int mostBooked(int n, int[][] meetings) {
        int[] cnt = new int[n];
        Arrays.sort(meetings, (o1, o2) -> o1[0] - o2[0]);
        int deadline = meetings[0][1];
        PriorityQueue<int[]> free = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        PriorityQueue<int[]> used = new PriorityQueue<>((o1, o2) -> {
            if (o1[1] != o2[1])
                return o1[1] - o2[1];
            else return o1[0] - o2[0];
        });
        for (int i = 0; i < n; i++) {
            free.add(new int[]{i, 0});
        }
        for (int i = 0; i < meetings.length; i++) {
            int[] meeting = meetings[i];
            while (!used.isEmpty() && used.peek()[1] <= meeting[0]) {
                free.add(used.poll());
            }
            if (free.isEmpty()) {
                free.add(used.poll());
            }
            int[] room = free.poll();
            if (room[1] <= meeting[0]) {
                room[1] = meeting[1];
            } else room[1] += meeting[1] - meeting[0];
            used.add(room);
            cnt[room[0]]++;

        }
        int ans = 0;
        for (int i = 1; i < n; i++) {
            if (cnt[i] > cnt[ans]) {
                ans = i;
            }
        }
        return ans;
    }

}
