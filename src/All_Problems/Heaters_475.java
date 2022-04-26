package All_Problems;

import org.junit.Test;

import java.util.Arrays;

/**
 * @ClassName Heaters_475
 * @Description
 * @Author cjx
 * @Date 2021/12/20 9:13
 * @Version 1.0
 */
public class Heaters_475 {
    @Test
    public void test() {
        int[] houses = new int[]{617819336, 399125485, 156091745, 356425228
        };
        int[] heaters = new int[]{585640194, 937186357};
        System.out.println(findRadius(houses, heaters));
    }


    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int l = 0, ll = houses.length, r = 0, rl = heaters.length;
        int ans = 0;
        for (; l < ll; l++) {
            while (heaters[r] <= houses[l] && r < rl) {
                r++;
            }
            int tem = 0;
            if (r == 0) tem = heaters[0] - houses[l];
            else if (r == rl) tem = houses[l] - heaters[r - 1];
            else tem = Math.min(heaters[r] - houses[l], houses[l] - heaters[r - 1]);
            ans = Math.max(ans, tem);
        }
        return ans;
    }


}
