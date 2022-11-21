package All_Problems;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName Making_A_Large_Island_827
 * @Description
 * @Author cjx
 * @Date 2022/9/18 22:42
 * @Version 1.0
 */
public class Making_A_Large_Island_827 {
    @Test
    public void test(){
        int[][] grid=new int[][]{
                {1,1},
                {1,0}
        };
        System.out.println(largestIsland(grid));
    }

    int N = 510;
    int[] p = new int[N * N], sz = new int[N * N];
    int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    int find(int x) {
        if (p[x] != x) {
            p[x] = find(p[x]);
        }
        return p[x];
    }

    void union(int a, int b) {
        int oa = find(a), ob = find(b);
        if(oa==ob) return;
        if (sz[oa] < sz[ob]) {
            union(b, a);
        } else {
            sz[oa] += sz[ob];
            p[ob] = p[oa];
        }
    }

    public int largestIsland(int[][] grid) {
        int n = grid.length;
        for (int i = 0; i < n * n; i++) {
            p[i] = i;
            sz[i] = 1;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0) {
                    for (int k = 0; k < 4; k++) {
                        int x = i + dirs[k][0], y = j + dirs[k][1];
                        if (x < 0 || x >= n || y < 0 || y >= n || grid[x][y] == 0) continue;
                        union(i * n + j , x * n + y );
                    }
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    ans = Math.max(ans, sz[find(i * n + j )]);
                } else {
                    int tot = 1;
                    Set<Integer> set = new HashSet<>();
                    for (int k = 0; k < 4; k++) {
                        int x = dirs[k][0] + i, y = dirs[k][1] + j;
                        if (x < 0 || x >= n || y < 0 || y >= n || grid[x][y] == 0) continue;
                        if (set.contains(find(x*n+y))) continue;
                        tot += sz[find(x * n + y )];
                        set.add(find(x*n+y));
                    }
                    ans = Math.max(tot, ans);
                }
            }
        }
        return ans;
    }

}
