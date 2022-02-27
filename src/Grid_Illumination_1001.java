import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName Grid_Illumination_1001
 * @Description
 * @Author cjx
 * @Date 2022/2/8 11:30
 * @Version 1.0
 */
public class Grid_Illumination_1001 {
    public int[] gridIllumination(int n, int[][] lamps, int[][] queries) {
        Map<Integer, Integer> row = new HashMap<>();
        Map<Integer, Integer> col = new HashMap<>();
        Map<Integer, Integer> diff = new HashMap<>();
        Map<Integer, Integer> sum = new HashMap<>();
        Set<Long> allLamp = new HashSet<>();

        for (int[] lamp : lamps) {
            if(allLamp.contains((long)lamp[0]*n+lamp[1])) continue;
            allLamp.add((long)lamp[0] * n + lamp[1]);
            row.put(lamp[0], row.getOrDefault(lamp[0], 0) + 1);
            col.put(lamp[1], col.getOrDefault(lamp[1], 0) + 1);
            diff.put(lamp[0] - lamp[1], diff.getOrDefault(lamp[0] - lamp[1], 0) + 1);
            sum.put(lamp[0] + lamp[1], sum.getOrDefault(lamp[0] + lamp[1], 0) + 1);
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int x = query[0], y = query[1];
            if (row.getOrDefault(x, 0) > 0 || col.getOrDefault(y, 0) > 0 || diff.getOrDefault(x - y, 0) > 0 || sum.getOrDefault(x + y, 0) > 0) {
                ans[i] = 1;
                for (int j = -1; j <= 1; j++) {
                    int nx = x+j;
                    for (int k = -1; k <= 1; k++) {
                        int ny = y + k;
                        if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                        if (allLamp.contains((long)nx * n + ny)) {
                            allLamp.remove((long)nx * n + ny);
                            row.put(nx, row.get(nx) - 1);
                            col.put(ny, col.get(ny) - 1);
                            diff.put(nx - ny, diff.get(nx - ny) - 1);
                            sum.put(nx + ny, sum.get(nx + ny) - 1);
                        }
                    }
                }
            }
        }
        return ans;
    }
}
