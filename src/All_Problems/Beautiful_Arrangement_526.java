package All_Problems;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Beautiful_Arrangement_526
 * @Description
 * @Author cjx
 * @Date 2021/8/16 17:53
 * @Version 1.0
 */
public class Beautiful_Arrangement_526 {
    @Test
    public void test() {
        for (int i = 1; i < 16; i++) {
            System.out.println(countArrangement(i));
        }

    }

    int ans;
    boolean[] vis;
    List<Integer>[] match;

    public int countArrangement(int n) {
        vis = new boolean[n + 1];
        match = new List[n + 1];
        ans = 0;

        for (int i = 1; i < n + 1; i++) {
            match[i] = new ArrayList<>();
            for (int j = 1; j < n + 1; j++) {
                if (i % j == 0 || j % i == 0) {
                    match[i].add(j);
                }
            }
        }
        backtrack(1, n);
        return ans;
    }

    void backtrack(int index, int n) {
        if (index == n + 1) {
            ans++;
            return;
        }
        for (Integer num : match[index]) {
            if (!vis[num]) {
                vis[num] = true;
                backtrack(index + 1, n);
                vis[num] = false;
            }
        }
    }
}
