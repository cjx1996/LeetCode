import java.util.Arrays;

/**
 * @ClassName Friends_Of_Appropriate_Ages_825
 * @Description
 * @Author cjx
 * @Date 2021/12/27 9:16
 * @Version 1.0
 */
public class Friends_Of_Appropriate_Ages_825 {
    public int numFriendRequests(int[] ages) {
        int N=  121;
        int[] cnt = new int[N];
        for (int age : ages) cnt[age]++;
        for (int i = 1; i < N; i++) cnt[i] += cnt[i - 1];
        int ans = 0;
        for (int i = N-1, j = N-1; i >= 15; i--) {
            int num = cnt[i] - cnt[i - 1];
            if (num == 0) continue;
            if (j > i) j = i;
            while (j > 0 && j>(i/2+7)) j--;
            int b = cnt[i] - cnt[j] - 1;
            if (b > 0) ans += b * num;
        }
        return ans;
    }


}
