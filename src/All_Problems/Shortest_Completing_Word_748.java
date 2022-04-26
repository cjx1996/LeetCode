package All_Problems;

import org.junit.Test;

import java.util.Arrays;

/**
 * @ClassName Shortest_Completing_Word_748
 * @Description String
 * @Author cjx
 * @Date 2021/12/10 18:14
 * @Version 1.0
 */
public class Shortest_Completing_Word_748 {
    @Test
    public void test() {
        String licensePlate = "1s3 PSt";
        String[] words = new String[]{"step", "steps", "stripe", "stepple"};
        System.out.println(shortestCompletingWord(licensePlate, words));
    }

    public String shortestCompletingWord(String licensePlate, String[] words) {
        licensePlate = licensePlate.toLowerCase();
        int[] cnt = new int[26];
        for (int i = 0; i < licensePlate.length(); i++) {
            char c = licensePlate.charAt(i);
            if (c >= 'a') cnt[c - 'a']++;
        }
        String ans = "                                ";
        for (String word : words) {
            int[] tem = Arrays.copyOf(cnt, 26);
            if (check(tem, word) && word.length() < ans.length()) ans = word;
        }
        return ans;
    }

    boolean check(int[] cnt, String word) {
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            cnt[c - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (cnt[i] > 0) return false;
        }
        return true;
    }
}
