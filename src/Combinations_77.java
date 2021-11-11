import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Combinations_77
 * @Description
 * @Author cjx
 * @Date 2021/8/17 18:01
 * @Version 1.0
 */
public class Combinations_77 {
    @Test
    public void test() {
        List<List<Integer>> ans = combine(4, 2);
        for (List<Integer> list : ans) {
            for (Integer num : list) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    List<List<Integer>> ans;
    List<Integer> tem = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        ans = new ArrayList<>();
        backtrack(1, k, n);
        return ans;
    }

    void backtrack(int index, int k, int n) {
        if (tem.size() + n - index + 1 < k) return;
        if (tem.size() == k) {
            ans.add(new ArrayList<>(tem));
            return;
        }
        tem.add(index);
        backtrack(index + 1, k, n);
        tem.remove(tem.size() - 1);
        backtrack(index + 1, k, n);


    }
}
