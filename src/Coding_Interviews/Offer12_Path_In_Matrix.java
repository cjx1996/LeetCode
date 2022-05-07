package Coding_Interviews;

import org.junit.Test;

/**
 * @ClassName Offer12_Path_In_Matrix
 * @Description
 * @Author cjx
 * @Date 2022/4/28 9:50
 * @Version 1.0
 */
public class Offer12_Path_In_Matrix {
    @Test
    public void test() {
        char[][] _board = new char[][]{
                {'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'F', 'E'}
        };
        String word = "ABCCED";
        System.out.println(exist(_board, word));
    }

    char[] cs;
    char[] back;
    boolean[][] vis;
    char[][] board;
    int m, n, len;
    int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public boolean exist(char[][] _board, String word) {
        cs = word.toCharArray();

        board = _board;
        m = board.length;
        n = board[0].length;
        len = cs.length;

        vis = new boolean[m][n];
        back = new char[len];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (backTrack(i, j, 0)) return true;
            }
        }
        return false;
    }

    boolean backTrack(int i, int j, int index) {
        char c = board[i][j];
        if (c != cs[index]) return false;
        if (index == len - 1) return true;
        vis[i][j] = true;
        for (int[] dir : dirs) {
            int dx = dir[0], dy = dir[1];
            int nx = i + dx, ny = j + dy;
            if (nx < 0 || nx >= m || ny < 0 || ny >= n || vis[nx][ny]) continue;
            if (backTrack(nx, ny, index + 1)) {
                return true;
            };
        }
        vis[i][j] = false;
        return false;
    }


}
