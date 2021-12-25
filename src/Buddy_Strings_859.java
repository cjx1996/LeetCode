import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName Buddy_Strings_859
 * @Description
 * @Author cjx
 * @Date 2021/11/23 14:30
 * @Version 1.0
 */
public class Buddy_Strings_859 {
    @Test
    public void test() {
        String s = "ab";
        String goal = "ba";
        System.out.println(buddyStrings(s, goal));
    }

    public boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length()) return false;
        int[] m = new int[26], n = new int[26];
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            int a = s.charAt(i) - 'a', b = goal.charAt(i) - 'a';
            m[a]++;
            n[b]++;
            if(a!=b) sum++;
        }
        boolean ok = false;
        for (int i = 0; i < 26; i++) {
            if(m[i]!=n[i]) return false;
            if(m[i]>1) ok=true;
        }
        return sum==2||(sum==0&&ok);
    }
}
