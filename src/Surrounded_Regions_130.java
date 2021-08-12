import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ForkJoinPool;

/**
 * @ClassName Surrounded_Regions_130
 * @Description
 * @Author cjx
 * @Date 2021/7/24 11:41
 * @Version 1.0
 */
public class Surrounded_Regions_130 {
    @Test
    public void test(){
        char[][] board = new char[][]{
                {'O','O','O','O','X','X'},
                {'O','O','O','O','O','O'},
                {'O','X','O','X','O','X'},
                {'O','X','O','O','X','O'},
                {'O','X','O','X','O','O'},
                {'O','X','O','O','O','O'}

        };
        solve(board);
    }
    public void solve(char[][] board){
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            solvePoint(board,i,0);
            solvePoint(board,i,n-1  );
        }
        for(int j = 0;j<n;j++){
            solvePoint(board,0,j);
            solvePoint(board,m-1,j);
        }

        for (int i = 0; i < m ; i++) {
            for (int j = 0; j < n; j++) {
                if(board[i][j]=='R') board[i][j]='O';
                else if(board[i][j]=='O') board[i][j]='X';
            }
        }
    }
    void solvePoint(char[][] board,int i,int j){
        int m = board.length;
        int n = board[0].length;
        if(i<0||j<0||i>m-1||j>n-1||board[i][j]!='O') return;
        int[] X = new int[]{-1,+1,0,0};
        int[] Y = new int[]{0,0,-1,+1};
        board[i][j] = 'R';
        for (int k = 0; k < 4; k++) {
            solvePoint(board,i+X[k],j+Y[k]);
        }
    }
}
