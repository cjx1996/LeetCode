package All_Problems;

import org.junit.Test;

/**
 * @ClassName Koko_Eating_Bananas_875
 * @Description
 * @Author cjx
 * @Date 2022/6/7 11:13
 * @Version 1.0
 */
public class Koko_Eating_Bananas_875 {

    @Test
    public void test() {
        int[] piles = new int[]{30, 11, 23, 4, 20};
        int h = 6;
        System.out.println(minEatingSpeed(piles, h));
    }

    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for (int i : piles) {
            max = Math.max(i, max);
        }
        int l = 1, r = max;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (check(piles, mid, h))
                r = mid;
            else l = mid + 1;
        }
        return r;
    }

    boolean check(int[] piles, int s, int h) {
        int ans = 0;
        for (int pile : piles) {
            ans += Math.ceil(pile * 1.0 / s);
        }
        return ans <= h;
    }

}
