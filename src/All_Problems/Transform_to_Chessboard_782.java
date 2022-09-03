package All_Problems;

import org.junit.Test;

/**
 * @ClassName Transform_to_Chessboard_782
 * @Description
 * @Author cjx
 * @Date 2022/8/23 20:58
 * @Version 1.0
 */
public class Transform_to_Chessboard_782 {
    @Test
    public void test() {
        int[][] board = new int[][]{
                {0, 1},
                {0, 1}
        };
        System.out.println(movesToChessboard(board));
    }

    static final int INF = 0x3f3f3f3f;

    public int getMoves(int a, int b) {
        return Integer.bitCount(a) != Integer.bitCount(b) ? INF : Integer.bitCount(a ^ b) / 2;
    }

    public int movesToChessboard(int[][] board) {
        int n = board.length;
        int r1 = -1, r2 = -1, c1 = -1, c2 = -1, ans = 0;
        for (int i = 0; i < n; i++) {
            int a = 0, b = 0;
            for (int j = 0; j < n; j++) {
                if (board[i][j] != 0) a += 1 << j;
                if (board[j][i] != 0) b += 1 << j;
            }
            if (r1 == -1) r1 = a;
            else if (a != r1 && r2 == -1) r2 = a;
            if (c1 == -1) c1 = b;
            else if (b != c1 && c2 == -1) c2 = b;
            if (a != r1 && a != r2) return -1;
            if (b != c1 && b != c2) return -1;
        }
        int mask = (1 << n) - 1;
        if (Integer.bitCount(r1) + Integer.bitCount(r2) != n) return -1;
        if (Integer.bitCount(c1) + Integer.bitCount(c2) != n) return -1;
        if ((r1 ^ r2) != mask || (c1 ^ c2) != mask) return -1;
        int tar = 0;
        for (int i = 0; i < n; i += 2) {
            tar += 1 << i;
        }
        ans = Math.min(getMoves(r1, tar), getMoves(r2, tar)) + Math.min(getMoves(c1, tar), getMoves(c2, tar));
        return ans >= INF ? -1 : ans;

    }

}
