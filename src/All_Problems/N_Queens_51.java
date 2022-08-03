package All_Problems;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName N_Queens_51
 * @Description
 * @Author cjx
 * @Date 2022/6/7 15:20
 * @Version 1.0
 */
public class N_Queens_51 {
    boolean[] row;
    boolean[] col;
    boolean[] diff;
    boolean[] sum;
    int N=0;
    List<List<String>> ans = new ArrayList<>();
    List<String> tem=new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        N=n;
        row = new boolean[n];
        col = new boolean[n];
        diff = new boolean[2 * n - 1];
        sum = new boolean[2 * n - 1];

        return ans;

    }

    void backTrack(int i,int j,StringBuilder sb){

    }

}
