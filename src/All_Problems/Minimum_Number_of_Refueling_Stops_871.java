package All_Problems;

import org.junit.Test;

import java.util.PriorityQueue;

/**
 * @ClassName Minimum_Number_of_Refueling_Stops_871
 * @Description
 * @Author cjx
 * @Date 2022/7/8 10:50
 * @Version 1.0
 */
public class Minimum_Number_of_Refueling_Stops_871 {
    @Test
    public void test() {
        int target = 1000000;
        int startFuel = 70768;
        int[][] stations = new int[][]{
                {12575, 171159}, {81909, 101253}, {163732, 164401}, {190025, 65493}, {442889, 31147}, {481202, 166081}, {586028, 206379}, {591952, 52748}, {595013, 9163}, {611883, 217156}
        };
        System.out.println(minRefuelStops(target, startFuel, stations));
    }

    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
        int cnt = 0;
        int max = startFuel;
        int idx = 0;
        int n = stations.length;
        while (max < target ) {
            while (idx < n && stations[idx][0] <= max) {
                q.add(stations[idx++]);
            }
            if (!q.isEmpty()) {
                int[] tem = q.poll();
                max += tem[1];
                cnt++;
            } else return -1;
        }
        return max >= target ? cnt : -1;
    }

}
