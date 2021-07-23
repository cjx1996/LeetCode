import org.junit.Test;

import java.util.HashMap;
import java.util.concurrent.ForkJoinPool;

/**
 * @ClassName Valid_Sudoku_36
 * @Description TODO
 * @Author cjx
 * @Date 2021/7/15 22:23
 * @Version 1.0
 */
public class Valid_Sudoku_36 {

    public boolean isValidSudoku(char[][] board){
        int[] row = new int[9];
        int[] col = new int[9];
        int[] box = new int[9];
        for (int i = 0; i < 9; i++) {
            for(int j = 0;j<9;j++){
                int k = (i/3)*3+j/3;
                if(board[i][j]=='.') continue;
                int shift = 1<<(board[i][j]-'0');
                if((row[i]&shift)>0||(col[j]&shift)>0||(box[k]&shift)>0)
                    return false;
                row[i] |=shift;
                col[j] |=shift;
                box[k] |=shift;
            }
        }
        return true;
    }

    public boolean isValidSudoku1(char[][] board){
        int len = 9;
        for (int i = 0; i < len; i++) {
            boolean validRow = isValidPart(board,i,i,0,8);
            if(!validRow) return false;
            boolean validCol = isValidPart(board, 0, 8, i, i);
            if(!validCol) return false;
        }
        for (int i = 0; i < len; i=i+3) {
            for(int j =0;j<len;j=j+3){
                boolean validPart = isValidPart(board,i,i+2,j,j+2);
                if(!validPart) return false;
            }
        }
        return true;
    }


    boolean isValidPart(char[][] board,int rowl,int rowr,int coll,int colr) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = rowl; i <= rowr; i++) {
            for (int j = coll; j <= colr; j++) {
                char c = board[i][j];
                if (c != '.') {
                    Integer count = map.getOrDefault(c, 0);
                    if (count == 0) {
                        map.put(c, 1);
                    } else {
                        return false;
                    }
                }
            }

        }
        return true;
    }


}
