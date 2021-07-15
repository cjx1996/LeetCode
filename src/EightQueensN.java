import java.util.*;

/**
 * @author cjx
 * @create 2021-01-04-11:43
 * @description
 */
public class EightQueensN {


    /**
     * @return 输出形式为List<List < String>>的List，每个元素代表一种方案
     */

    public List<List<String>> eightQueensN(int n) {
        List<List<String>> solutions = new ArrayList<>();//代表方案集的列表
        Set<Integer> columns = new HashSet<>();//代表每一列是否有皇后，如果集合中有该值，代表该列有皇后
        Set<Integer> diagonals1 = new HashSet<>();//代表主对角方向是否有皇后
        Set<Integer> diagonals2 = new HashSet<>();//代表副对角方向是否有皇后
        int[] queens = new int[n];//下标代表行号，值代表该行皇后的位置索引
        Arrays.fill(queens, -1);//首先全部设置为-1，即皇后未放置

        backtrack(solutions, queens, columns, diagonals1, diagonals2, 0, n);
        return solutions;
    }

    public void backtrack(List<List<String>> solutions, int[] queens, Set<
            Integer> columns, Set<Integer> diagonals1, Set<Integer> diagonals2, int index, int nums) {
        if (index == nums) {
            //若已经全部安排好皇后，则根据数组形成图例，并加入到方案集中
            List<String> solution = generateList(queens);
            solutions.add(solution);
        } else {
            for (int i = 0; i < nums; i++) {
                //定义两个代表皇后位置所属的对角方向的变量
                int diagonalp = index - i;
                int diagonalm = index + i;
                //判断皇后位置是否可行
                if (columns.contains(i)) continue;
                if (diagonals1.contains(diagonalp)) continue;
                if (diagonals2.contains(diagonalm)) continue;
                //皇后位置可行，将当前皇后位置加入到示意已用参数的集合中
                queens[index] = i;
                columns.add(i);
                diagonals1.add(diagonalp);
                diagonals2.add(diagonalm);
                //继续进行接下来的行的皇后位置的设置
                backtrack(solutions, queens, columns, diagonals1, diagonals2, index + 1, nums);
                //回溯，删除当前行的皇后的位置，为下一个列位置的判断做好准备
                queens[index] = -1;
                columns.remove(i);
                diagonals1.remove(diagonalp);
                diagonals2.remove(diagonalm);
            }
        }
    }

    public List<String> generateList(int[] queens) {
        int n = queens.length;
        List<String> solution = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[queens[i]] = 'Q';
            String rowStr = String.valueOf(row);
            solution.add(rowStr);
        }
        return solution;
    }
}

