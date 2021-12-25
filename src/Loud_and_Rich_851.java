import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName Loud_and_Rich_851
 * @Description
 * @Author cjx
 * @Date 2021/12/15 20:11
 * @Version 1.0
 */
public class Loud_and_Rich_851 {
    @Test
    public void test() {
        loudAndRich(null, new int[10]);
    }

    ;
    int[] ans;
    ArrayList[] gr;

    public int[] loudAndRich(int[][] richer, int[] quiet) {
        ans = new int[quiet.length];
        Arrays.fill(ans, -1);

        gr = new ArrayList[quiet.length];
        for (int i = 0; i < gr.length; i++) {
            gr[i] = new ArrayList();
        }
        for (int[] ints : richer) {
            gr[ints[1]].add(ints[0]);
        }
        for (int i = 0; i < ans.length; i++) {
            dfs(quiet, i);
        }
        return ans;
    }

    ;

    void dfs(int[] quiet, int person) {
        List<Integer> more = gr[person];
        ans[person] = person;
        if (!more.isEmpty()) {
            for (Integer p : more) {
                if (ans[p] == -1) {
                    dfs(quiet, p);
                }
                if (quiet[ans[person]] > quiet[ans[p]]) {
                    ans[person] = ans[p];
                }
            }
        }
    }

}
