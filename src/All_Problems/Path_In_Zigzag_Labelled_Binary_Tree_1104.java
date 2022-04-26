package All_Problems;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @ClassName Path_In_Zigzag_Labelled_Binary_Tree_1104
 * @Description
 * @Author cjx
 * @Date 2021/7/29 18:01
 * @Version 1.0
 */
public class Path_In_Zigzag_Labelled_Binary_Tree_1104 {
    @Test
    public void test() {
        System.out.println(pathInZigZagTree(16));
    }

    public List<Integer> pathInZigZagTree(int label) {
        int len = findBits(label);
        ArrayList<Integer> res = new ArrayList<>();
        res.add(label);
        for (int i = len - 2; i >= 0; i--) {
            if ((len - 1 - i) % 2 == 1) {
                res.add((1 << i) + (1 << (i + 1)) - 1 - (label >>= 1));
            } else {
                res.add((label >>= 1));
            }
        }
        Collections.reverse(res);
        return res;
    }

    //得到不超过目标值的最大的2的幂次的位数
    int findBits(int target) {
        int num = target;
        num |= num >> 1;
        num |= num >> 2;
        num |= num >> 4;
        num |= num >> 8;
        num |= num >> 16;
        return Integer.bitCount(num);
    }
}
