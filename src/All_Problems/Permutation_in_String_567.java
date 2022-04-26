package All_Problems;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @ClassName Permutation_in_String_567
 * @Description
 * @Author cjx
 * @Date 2021/8/10 18:49
 * @Version 1.0
 */
public class Permutation_in_String_567 {
    @Test
    public void test() {
        String s1 = "abc";
        String s2 = "eidbacoo";
        System.out.println(checkInclusion(s1, s2));
    }

    public boolean checkInclusion(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();
        if(l2<l1) return false;
        int[] map = new int[26];
        char[] c1 = s1.toCharArray(),c2=s2.toCharArray();
        for (char c : c1) {
            map[c-'a']++;
        }

        int cnt=0;
        int left=0,right=0;

        while(right<l2){
            char tem = c2[right];
            map[tem-'a']--;
            cnt++;
            right++;
            while (map[tem - 'a'] < 0) {
                map[c2[left] - 'a']++;
                cnt--;
                left++;
            }
            if (cnt == l1) return true;
        }
        return false;
    }


}
