package All_Problems;

import org.junit.Test;

import java.util.PriorityQueue;

/**
 * @ClassName Construct_s
 * @Description
 * @Author cjx
 * @Date 2022/2/20 11:22
 * @Version 1.0
 */
public class Construct_String_With_Repeat_Limit_6014 {
    @Test
    public void test() {
        String s = "aabababaaaa";
        System.out.println(repeatLimitedString(s, 2));
    }


    public String repeatLimitedString(String s, int repeatLimit) {
        char[] sb = new char[s.length()];
        int[] cnt = new int[26];
        for (int i = 0; i < s.length(); i++) {
            cnt[s.charAt(i) - 'a']++;
        }
        int index = 0;
        for (int i = 25; i >= 0; i--) {
            if (cnt[i] > 0) {
                for (int j = 0; j < cnt[i]; j++) {
                    sb[index++] = ((char) (i + 'a'));

                }
            }
        }
        int count = 1;
        for (int l = 1, r = 2; l < s.length(); l++) {
            if (sb[l] != sb[l - 1]) {
                count = 1;
            } else {
                count++;
                if (count > repeatLimit) {
                    r = Math.max(r, l + 1);
                    while (r < s.length() && sb[r] == sb[l]) {
                        r++;
                    }
                    if (r < s.length()) {
                        char tem = sb[l];
                        sb[l] = sb[r];
                        sb[r] = tem;

                    } else {
                        return String.valueOf(sb).substring(0, l);
                    }
                }
            }
        }
        return String.valueOf(sb);
    }


/*
    public String repeatLimitedString(String s, int repeatLimit) {
        int[] cnt = new int[26];
        char[] cs = s.toCharArray();
        for (char c : cs) {
            cnt[c - 'a']++;
        }
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> (b[0] - a[0]));
        for (int i = 0; i < 26; i++) {
            if (cnt[i] > 0) q.add(new int[]{i, cnt[i]});
        }
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        while (sb.length() < n&&!q.isEmpty()) {
            int[] tem1 = q.poll();
            if (sb.length() > 0 && sb.charAt(sb.length() - 1) == tem1[0] + 'a') {
                if(q.isEmpty()) break;
                int[] tem2 = q.poll();
                sb.append((char)(tem2[0] + 'a'));
                tem2[1]--;
                if (tem2[1] > 0) q.add(tem2);
                q.add(tem1);
            } else {
                int num = Math.min(repeatLimit, tem1[1]);
                for (int i = 0; i < num; i++) {
                    sb.append((char)(tem1[0] + 'a'));
                }
                tem1[1] -= num;
                if (tem1[1] > 0) q.add(tem1);
            }
        }
        return sb.toString();
    }*/
}
