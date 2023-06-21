package All_Problems;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @ClassName FlipChess_LCP_41
 * @Description
 * @Author cjx
 * @Date 2023/6/21 23:22
 * @Version 1.0
 */
public class FlipChess_LCP_41 {
    int[][] dirs = {
            {0, 1},
            {0, -1},
            {1, 0},
            {-1, 0},
            {-1, -1},
            {1, 1},
            {1, -1},
            {-1, 1}
    };

    public int flipChess(String[] chessboard) {
        int m = chessboard.length, n = chessboard[0].length();
        char[][] cs = new char[m][n];
        for (int i = 0; i < m; i++) {
            cs[i] = chessboard[i].toCharArray();
        }
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (cs[i][j] == '.') res = Math.max(res, bfs(chessboard, i, j));
            }
        }
        return res;
    }

    int bfs(String[] chessboard, int px, int py) {
        int cnt = 0;
        int m = chessboard.length, n = chessboard[0].length();
        char[][] cs = new char[m][n];
        for (int i = 0; i < m; i++) {
            cs[i] = chessboard[i].toCharArray();
        }
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{px, py});
        cs[px][py] = 'X';
        while (!q.isEmpty()) {
            int[] point = q.poll();
            for (int j = 0; j < 8; j++) {
                int x = point[0], y = point[1];
                int dx = dirs[j][0], dy = dirs[j][1];
                if (judge(cs, x, y, dx, dy)) {
                    x += dx;
                    y += dy;
                    while (cs[x][y] != 'X') {
                        q.add(new int[]{x, y});
                        cs[x][y] = 'X';
                        x += dx;
                        y += dy;
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }

    boolean judge(char[][] cs, int x, int y, int dx, int dy) {
        int m = cs.length, n = cs[0].length;
        x += dx;
        y += dy;
        while (x >= 0 && x < m && y >= 0 && y < n) {
            if (cs[x][y] == 'X') return true;
            else if (cs[x][y] == '.') return false;
            x += dx;
            y += dy;
        }
        return false;
    }

}
