import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName Maximum_Employees_to_Be_Invited_to_a_Meeting_5970
 * @Description TODO 还未写出，不会写
 * @Author cjx
 * @Date 2022/1/2 11:08
 * @Version 1.0
 */
public class Maximum_Employees_to_Be_Invited_to_a_Meeting_5970 {
    int[] v;
    int[] len;
    boolean[] vis;
    int[] cnt;
    int ans;

    public int maximumInvitations(int[] favorite) {
        int n = favorite.length;
        v = favorite;
        len = new int[n];
        vis = new boolean[n];
        cnt = new int[n];
        for (int i = 0; i < n; i++) {
            cnt[v[i]]++;
        }
        prune();
        for (int i = 0; i < n; i++) {
            if (v[v[i]] == i) {
                ans += 1 + len[i];
            }
        }
        for (int i = 0; i < n; i++) {
            dfs(i, 0);
        }
        return ans;
    }

    void dfs(int i, int count) {
        if (!vis[i]) {
            vis[i] = true;
            dfs(v[i], count + 1);
        } else {
            ans = Math.max(ans, count);
        }
    }

    void prune() {
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < v.length; i++) {
            if (cnt[i] == 0) {
                q.offer(i);
            }
        }
        int level = 0;
        while (!q.isEmpty()) {
            level++;
            int n = q.size();
            for (int i = 0; i < n; i++) {
                int p = q.poll();
                if (!vis[p]) {
                    vis[p] = true;
                    cnt[v[p]]--;
                    if (cnt[v[p]] == 0) {
                        q.offer(v[p]);
                    }
                    len[v[p]] = level;
                }
            }
        }
    }
}
