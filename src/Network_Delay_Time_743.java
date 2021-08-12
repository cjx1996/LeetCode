import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName Network_Delay_Time_743
 * @Description
 * @Author cjx
 * @Date 2021/8/2 10:27
 * @Version 1.0
 */
public class Network_Delay_Time_743 {
    @Test
    public void test() {
        int[][] times = new int[][]{
                {1,2,1},
                {2,1,3}
        };
        System.out.println(networkDelayTime(times, 2, 2));

    }

     int Max = 0;

    public int networkDelayTime(int[][] time, int n, int k) {
        Map<Integer, ArrayList> map = new HashMap<>();
        for (int i = 0; i < time.length; i++) {
            map.putIfAbsent(time[i][0], new ArrayList<int[]>());
            map.get(time[i][0]).add(new int[]{time[i][1], time[i][2]});
        }
        int usedNum = 0;
        boolean[] used = new boolean[n];
        dfs(map, k, 0, used);
        for (int i = 0; i < used.length; i++) {
            if (!used[i]) {
                return -1;
            }
        }
        return Max;
    }

    void dfs(Map<Integer, ArrayList> map, int point, int distance, boolean[] used) {
        used[point - 1] = true;
        ArrayList<int[]> nextPoints = map.get(point);
        if (nextPoints == null) {
            Max = Math.max(Max, distance);
            return;
        }
        for (int[] nextPoint : nextPoints) {
            if(!used[nextPoint[0]-1]){
                dfs(map, nextPoint[0], distance + nextPoint[1], used);
            }else{
                Max = Math.max(Max,distance);
            }
        }
    }
}
