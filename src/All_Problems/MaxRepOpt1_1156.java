package All_Problems;

import org.junit.Test;

import java.util.Arrays;

/**
 * @ClassName MaxRepOpt1_1156
 * @Description
 * @Author cjx
 * @Date 2023/6/3 10:55
 * @Version 1.0
 */
public class MaxRepOpt1_1156 {
    @Test
    public void test() {
        String text = "abcaaa";
        System.out.println(maxRepOpt1(text));
    }


    public int maxRepOpt1(String text) {
        char[] cs = text.toCharArray();
        int l = 0, r = 0;
        int n = cs.length;
        int ans = 1;
        int[] cnt = new int[26];
        for (char c : cs) {
            cnt[c - 'a']++;
        }
        int b = -1;
        int sCnt = 0;
        for (; r < n; r++) {
            if (cs[r] == cs[l]) continue;
            else if (sCnt == 0 && r - l + 1 <= cnt[cs[l] - 'a']) {
                sCnt++;
                b = r;
            } else {
                ans = Math.max(ans, Math.min(r - l, cnt[cs[l] - 'a']));
                l = b < 0 ? r : b;
                r = l;
                sCnt = 0;
                b = -1;
            }
        }
        int min = cnt[cs[l] - 'a'];
        if (r - l < min) min = sCnt == 0 ? r-l+1 : r - l;
        ans=Math.max(ans,min);
        return ans;
    }
}
