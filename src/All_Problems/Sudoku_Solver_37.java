package All_Problems;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Sudoku_Solver_37
 * @Description
 * @Author cjx
 * @Date 2021/7/17 23:17
 * @Version 1.0
 */
public class Sudoku_Solver_37 {
    int[] row = new int[9];
    int[] col = new int[9];
    int[] box = new int[9];
    boolean valid = false;
    List<int[]> points = new ArrayList<>();
@Test
public void test(){
    int a = 4;
    System.out.println(Integer.bitCount(a));
}
    public void solveSudoku(char[][] board) {

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    points.add(new int[]{i, j});
                } else {
                    flip(i, j, board[i][j] - '0');
                }
            }
        }
        dfs(board, 0);
    }

    public void dfs(char[][] board, int pos) {
        if(pos==points.size()){
            valid = true;
            return ;
        }
        int[] point = points.get(pos);
        int i = point[0];
        int j = point[1];
        int k = (i/3)*3+j/3;

        int mask = ~(row[i]|col[j]|box[k])&0x1ff;
        for(;!valid&&mask!=0;mask &=(mask-1)){
            int digitMask = mask&(-mask);
            int digit = Integer.bitCount(digitMask-1)+1;
            flip(i,j, digit);
            board[i][j] = (char) (digit+'0');
            dfs(board,pos+1);
            flip(i,j,digit);
        }
    }

    void flip(int i, int j, int digit) {
        row[i] |= 1 << (digit - 1);
        col[j] |= 1 << (digit - 1);
        int k = (i / 3) * 3 + j/3;
        box[k] |= 1 << (digit - 1);
    }
}
