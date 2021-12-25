/**
 * @ClassName Valid_Tic_Tac_Toe_State_794
 * @Description
 * @Author cjx
 * @Date 2021/12/9 21:15
 * @Version 1.0
 */
public class Valid_Tic_Tac_Toe_State_794 {
    public boolean validTicTacToe(String[] board){
        char[][] cs = new char[3][3];        int ctX =0,ctO = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                char c = board[i].charAt(j);
                cs[i][j]= c;
                if(c=='O')ctO++;
                else if(c=='X') ctX++;
            }
        }

        if(ctO>ctX||ctX-ctO>1) return false;
        if(check(cs,'O')&&check(cs,'X')) return false;
        if(check(cs,'O')&&ctX==ctO+1) return false;
        if(check(cs,'X')&&ctX==ctO) return false;
        return true;
    }
    boolean check(char[][] cs,char c){
        for (int i = 0; i < 3; i++) {
            if(cs[i][0]==c&&cs[i][1]==c&&cs[i][2]==c) return true;
            if(cs[0][i]==c&&cs[1][i]==c&&cs[2][i]==c) return true;
        }
        if(cs[0][0]==c&&cs[1][1]==c&&cs[2][2]==c) return true;
        if(cs[0][2]==c&&cs[1][1]==c&&cs[2][0]==c) return true;
        return false;
    }
}
