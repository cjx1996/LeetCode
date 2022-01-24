import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName Escape_a_Large_Maze_1036
 * @Description dfs
 * @Author cjx
 * @Date 2022/1/11 11:26
 * @Version 1.0
 */
public class Escape_a_Large_Maze_1036 {


    int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    Set<Long> blocks = new HashSet<>();
    Long BASE = 1000000L;


    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        if (blocked.length == 0) return true;
        for (int[] block : blocked) {
            blocks.add(block[0] * BASE + block[1]);
        }
        boolean flag1 = dfs(source[0], source[1], source, target);
        vis = new HashSet<>();
        boolean flag2 = dfs(target[0], target[1], target, source);
        return flag1 && flag2;

    }

    Set<Long> vis = new HashSet();

    boolean dfs(int x1, int y1, int[] start, int[] end) {
        int x = start[0], y = start[1];
        if (x == end[0] && y == end[1]) return true;
        if (Math.abs(x1 - x) + Math.abs(y1 - y) > 400) return true;
        vis.add(start[0] * BASE + start[1]);
        for (int[] dir : dirs) {
            int nx = x + dir[0], ny = y + dir[1];
            if (nx < 0 || nx == BASE || ny < 0 || ny == BASE) continue;
            long num = nx * BASE + ny;
            if (vis.contains(num)) continue;
            if (blocks.contains(num)) continue;
            if (dfs(x1, y1, new int[]{nx, ny}, end)) return true;
            vis.add(num);
        }
        return false;
    }
}
