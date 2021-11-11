import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Count_Unhappy_Friends_1583
 * @Description
 * @Author cjx
 * @Date 2021/8/14 10:44
 * @Version 1.0
 */
public class Count_Unhappy_Friends_1583 {
    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                int fri = preferences[i][j];
                map[i][fri] = j;
            }
        }
        int[] match = new int[n];
        for (int[] pair : pairs) {
            int x = pair[0], y = pair[1];
            match[x] = y;
            match[y] = x;
        }
        List<Integer> unHappy = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!unHappy.contains(i)) {
                int j = match[i];
                int index = map[i][j];
                for (int k = 0; k < index; k++) {
                    int u = preferences[i][k];
                    int v = match[u];
                    if (map[u][i] < map[u][v]) {
                        if (!unHappy.contains(i)) {
                            unHappy.add(i);
                        }
                        if (!unHappy.contains(u)) {
                            unHappy.add(u);
                        }
                    }
                }
            }
        }
        return unHappy.size();
    }
}
