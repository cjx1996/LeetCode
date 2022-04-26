package All_Problems;

import org.junit.Test;

import java.util.HashMap;

/**
 * @ClassName Longest_Substring_Without_Repeating_Characters_3
 * @Description
 * @Author cjx
 * @Date 2021/8/10 12:26
 * @Version 1.0
 */
public class Longest_Substring_Without_Repeating_Characters_3 {
    @Test
    public void test() {
        String s = "abba";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        if (n < 2) return n;
        int ans = 0;
        //记录当前滑动窗口中包含的字符
        int[] hash = new int[128];
        for (int i = 0; i < 128; i++) {
            hash[i] = -1;
        }
        for (int left = 0, right = 0; right < n; right++) {
            left = Math.max(left, hash[chars[right]] + 1);
            ans = Math.max(ans, right - left + 1);
            hash[chars[right]] = right;
        }
        return ans;
    }
}
