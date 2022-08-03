package All_Problems;

import jdk.jfr.StackTrace;
import org.junit.Test;

/**
 * @ClassName Remove_Outermost_Parentheses_1021
 * @Description
 * @Author cjx
 * @Date 2022/5/28 23:38
 * @Version 1.0
 */
public class Remove_Outermost_Parentheses_1021 {
    @Test
    public void test() {
        String s = "(()())(())";
        System.out.println(removeOuterParentheses(s));
    }

    public String removeOuterParentheses(String s) {
        StringBuilder res = new StringBuilder();
        int cnt = 0;
        char[] cs = s.toCharArray();
        int n = s.length();
        int l = 0;
        for (int i = 0; i < n; i++) {
            if (cs[i] == '(') {
                if (cnt == 0) l = i;
                cnt++;
            } else cnt--;
            if (cnt == 0) {
                res.append(s.substring(l + 1, i));
                cnt = 0;
            }
        }

        return res.toString();
    }
}
