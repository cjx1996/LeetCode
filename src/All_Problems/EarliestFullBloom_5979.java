package All_Problems;

import java.util.PriorityQueue;

/**
 * @ClassName EarLiestFullBollm_5979
 * @Description
 * @Author cjx
 * @Date 2022/1/9 12:43
 * @Version 1.0
 */
public class EarliestFullBloom_5979 {
    public int earliestFullBloom(int[] plantTime,int[] growTime){
        PriorityQueue<int[]> heap = new PriorityQueue<>((a1,a2)->(a2[1]-a1[1]));
        for (int i = 0; i < plantTime.length; i++) {
            heap.add(new int[]{plantTime[i],growTime[i]});
        }
        int ans = 0;
        int plant = 0;
        for (int i = 0; i < plantTime.length; i++) {
            int[] tem = heap.poll();
            plant +=tem[0];
            ans = Math.max(ans,plant+tem[1]);
        }
        return ans+1;
    }
}
