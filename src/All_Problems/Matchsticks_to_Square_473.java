package All_Problems;

import org.junit.Test;

import java.util.Arrays;

/**
 * @ClassName Matchsticks_to_Square_473
 * @Description
 * @Author cjx
 * @Date 2022/6/1 11:18
 * @Version 1.0
 */
public class Matchsticks_to_Square_473 {
    @Test
    public void test() {
        int[] sticks = new int[]{
                3,3,3,3,4
        };
        System.out.println(makesquare(sticks));
    }

    int n;
    int[] sum = new int[4];
    int all;
    int[] matchsticks;

    public boolean makesquare(int[] _matchsticks) {
        matchsticks = _matchsticks;
        Arrays.sort(matchsticks);
        n = matchsticks.length;
        for (int i : matchsticks) {
            all += i;
        }
        if (all % 4 != 0) return false;
        return dfs(n - 1);
    }

    boolean dfs(int i) {
        if (i == -1) {
            for (int j = 0; j < 4; j++) {
                if (sum[j] != all / 4) return false;
            }
            return true;
        }
        for (int j = 0; j < 4; j++) {
            if (sum[j] + matchsticks[i] > all / 4) continue;
            sum[j] += matchsticks[i];
            if (dfs(i - 1)) return true;
            sum[j] -= matchsticks[i];
        }
        return false;
    }

}
