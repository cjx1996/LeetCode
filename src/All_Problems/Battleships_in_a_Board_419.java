package All_Problems;

import org.junit.Test;

/**
 * @ClassName Battleships_in_a_Board_419
 * @Description
 * @Author cjx
 * @Date 2021/12/18 9:39
 * @Version 1.0
 */
public class Battleships_in_a_Board_419 {
    @Test
    public void test() {
        char[][] board = new char[][]{
                {'X', '.', '.', 'X'},
                {'.', '.', '.', 'X'},
                {'.', '.', '.', 'X'}
        };
        System.out.println(countBattleships(board));
    }

    public int countBattleships(char[][] board) {
        int ans = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'X') {
                    dfs(board, i, j);
                    ans++;
                }
            }
        }
        return ans;
    }

    int dfs(char[][] board, int i, int j) {
        int m = board.length, n = board[0].length;
        if (i < 0 || j < 0 || i == m || j == n || board[i][j] != 'X') return 0;
        board[i][j] = '.';
        int[][] dir = new int[][]{
                {0, 1},
                {0, -1},
                {1, 0},
                {-1, 0}
        };
        for (int k = 0; k < 4; k++) {
            int x = i + dir[k][0], y = j + dir[k][1];
            dfs(board, x, y);
        }
        return 1;
    }
}
