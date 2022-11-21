package Interviews;

import java.util.Scanner;

/**
 * @ClassName MinimumNum
 * @Description
 * @Author cjx
 * @Date 2022/9/17 15:43
 * @Version 1.0
 */
public class MinimumNum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        cs = scan.nextLine().toCharArray();
        n = cs.length;
        backtrack(0, 0);
        System.out.println(ans);
    }

    static char[] cs;
    static String ans = null;
    static int n = 0;
    static void backtrack(int index, int sum) {
        if (index == n) {
            if (sum % 3 == 0) ans = String.valueOf(cs);
            return;
        }
        if (cs[index] != '?') {
            if (index != 0 && cs[index] == cs[index - 1]) return;
            backtrack(index + 1, sum + cs[index] - '0');
            return;
        }
        for (int i = 0; i <= 9; i++) {
            if (index == 0 && i == 0) continue;
            if (index != 0 && cs[index - 1] - '0' == i) continue;
            cs[index] = (char) (i + '0');
            backtrack(index + 1, sum + i);
            if (ans != null) return;
        }
    }
}