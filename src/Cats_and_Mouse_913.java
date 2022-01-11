import java.util.Arrays;

/**
 * @ClassName Cats_and_Mouse_913
 * @Description
 * @Author cjx
 * @Date 2022/1/4 11:46
 * @Version 1.0
 */
public class Cats_and_Mouse_913 {
    int[][] graph;
    int[][][] table;

    public int catMouseGame(int[][] graph) {
        this.graph = graph;
        int n = graph.length;
        table = new int[n + 1][n + 1][2 * n + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                Arrays.fill(table[i][j], -1);
            }
        }
        return dp(2, 1, 0);
    }

    int dp(int cat, int mouse, int turns) {
        if (turns == 2 * graph.length) return 0;
        else if (cat == mouse) return 2;
        else if (mouse == 0) return 1;
        if (table[cat][mouse][turns] != -1) return table[cat][mouse][turns];
        //老鼠移动
        if (turns % 2 == 0) {
            int[] moves = graph[mouse];
            int result = 2;
            for (int move : moves) {
                int tem = table[cat][move][turns + 1] == -1 ?
                        dp(cat, move, turns + 1) :
                        table[cat][move][turns + 1];
                table[cat][move][turns + 1] = tem;
                if (tem == 1) {
                    return table[cat][mouse][turns] = 1;
                } else if (tem == 0) {
                    result = 0;
                }
            }
            return table[cat][mouse][turns] = result;
        }
        //猫移动
        else {
            int[] moves = graph[cat];
            int result = 1;
            for (int move : moves) {
                if (move == 0) continue;
                int tem = table[move][mouse][turns + 1] == -1 ?
                        dp(move, mouse, turns + 1) :
                        table[move][mouse][turns + 1];
                table[move][mouse][turns + 1] = tem;
                if (tem == 2) return table[cat][mouse][turns] = 2;
                else if (tem == 0) result = 0;
            }
            return table[cat][mouse][turns] = result;
        }
    }

}