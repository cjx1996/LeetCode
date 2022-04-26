package All_Problems;

/**
 * @ClassName Word_Search_79
 * @Description
 * @Author cjx
 * @Date 2021/7/30 23:17
 * @Version 1.0
 */
public class Word_Search_79 {
    public boolean exist(char[][] board,String word){
        char[] chars = word.toCharArray();
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(board[i][j]==chars[0]){
                    if(dfs(board,chars,i,j)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    boolean dfs(char[][] board,char[] chars,int i,int j){
return false;
    }
}
