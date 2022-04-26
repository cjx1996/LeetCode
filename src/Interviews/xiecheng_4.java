package Interviews;

import java.util.Scanner;

/**
 * @ClassName Interviews.xiecheng_4
 * @Description 未完成，做不完
 * @Author cjx
 * @Date 2022/4/14 20:36
 * @Version 1.0
 */
public class xiecheng_4 {
    public int solution(){
        int M= (int)1e9+7;
        String str =new Scanner(System.in).nextLine();
        char[] cs = str.toCharArray();
        int n =cs.length;


        int[] cnt = new int[10];
       int ans = 0;
        int res = 0, t = 1;
        for(int i = n - 1; i >= 0; i--) {
            cnt[res]++;
            res = (res + (cs[i] - '0') * t) % 9;
            ans += cnt[res];
            ans = ans%M;
            t = t * 10 % 2019;
        }
        System.out.println(ans);
        return 0;
    }

}
