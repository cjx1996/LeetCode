package All_Problems;

import org.junit.Test;

import java.util.PriorityQueue;

/**
 * @ClassName Relative_Ranks_506
 * @Description   Heap(Priority Queue)
 * @Author cjx
 * @Date 2021/12/2 14:33
 * @Version 1.0
 */
public class Relative_Ranks_506 {

    @Test
    public void test() {
        int[] score = new int[]{5, 4, 3, 2, 1};
        String[] ranks = findRelativeRanks(score);
        for (String rank : ranks) {
            System.out.println(rank);
        }
    }

    public String[] findRelativeRanks(int[] score) {
        String[] ans = new String[score.length];
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> {
            return b[1] - a[1];
        });
        //将索引与分数组成数组，进行排序
        for (int i = 0; i < score.length; i++) {
            queue.add(new int[]{i, score[i]});
        }
        String[] medal = new String[]{"Gold Medal", "Silver Medal", "Bronze Medal"};
        for (int i = 0; i < score.length; i++) {
            int[] curr = queue.poll();
            if (i <= 2) {
                ans[curr[0]] = medal[i];
            } else {
                ans[curr[0]] = String.valueOf(i + 1);
            }
        }
        return ans;
    }
}
