package All_Problems;

/**
 * @ClassName Stone_Game_IX_2029
 * @Description
 * @Author cjx
 * @Date 2022/1/20 14:11
 * @Version 1.0
 */
public class Stone_Game_IX_2029 {
    public boolean stoneGameIX(int[] stones) {
        int[] cnt = new int[3];
        for (int stone : stones) {
            cnt[stone % 3]++;
        }
        return cnt[0] % 2 == 0 ? (cnt[1] > 0 && cnt[2] > 0) : (Math.abs(cnt[1] - cnt[2]) > 2);
    }
}
