package All_Problems;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName Calculate_24_Point
 * @Description
 * @Author cjx
 * @Date 2022/4/24 15:16
 * @Version 1.0
 */
public class Calculate_24_Point {
    @Test
    public void test(){
        int[] nums = new int[]{1,9,1,9};
        System.out.println(card(nums));

    }

    public boolean card(int[] nums) {
        List<Double> list = new ArrayList<>();
        for (int i : nums) {
            list.add((double) i);
        }
        return dfs(list);
    }

    private boolean dfs(List<Double> list) {
        if (list.size() == 1) {
            // 如果此时list只剩下了一张牌
            if (Math.abs(list.get(0) - 24.0) < 0.00001) {
                return true;
            }
            return false;
        }

        // 选取两张牌
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                // 对于每下一个可能的产生的组合
                for (double c : compute(list.get(i), list.get(j))) {
//                    System.out.println(c);
                    List<Double> nextRound = new ArrayList<>();
                    // 将他们加入到下一个list循环中去
                    nextRound.add(c);

                    for (int k = 0; k < list.size(); k++) {
                        if (k == j || k == i) continue; // 不可以等于之前的牌
                        nextRound.add(list.get(k)); // 选择出剩余的牌，加入到下一次的循环中
                    }
                    if (dfs(nextRound)) return true;
                }
            }
        }
        return false;
    }

    private List<Double> compute(double a, double b) {
        List<Double> res = Arrays.asList(a + b, a - b, b - a, a * b, a / b, b / a);
        return res;
    }


}
