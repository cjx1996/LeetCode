import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.prefs.PreferenceChangeEvent;

/**
 * @ClassName Find_All_Anagrams_in_a_String_438
 * @Description slicing window
 * @Author cjx
 * @Date 2021/7/19 18:10
 * @Version 1.0
 */
public class Find_All_Anagrams_in_a_String_438 {
    @Test
    public void test() {
        String s = "cbaebabacd", p = "abc";
        System.out.println(findAnagrams(s, p));
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int len = s.length();
        int pLen = p.length();
        if (len < pLen) {
            return ans;
        }

        int[] map = new int[26];
        for (int i = 0; i < pLen; i++) {
            map[p.charAt(i) - 'a']++;
        }
        int left = 0;
        int right = 0;

        int count = 0;
        for (; right < len; right++) {
            char c = s.charAt(right);

            if (map[c - 'a'] > 0) {
                map[c - 'a']--;
                count++;
                if (count == pLen) {
                    ans.add(left);
                }
            } else {

                while (map[c - 'a'] == 0 && left < right) {
                    char c2 = s.charAt(left);
                    map[c2 - 'a']++;
                    left++;
                    count--;
                }
                if (right == left && map[c - 'a'] == 0) {
                    left++;
                    right++;
                }
                right--;
            }
        }
        return ans;
    }
}
