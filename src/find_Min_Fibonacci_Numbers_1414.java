import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName find_Min_Fibonacci_Numbers_1414
 * @Description
 * @Author cjx
 * @Date 2022/2/3 9:46
 * @Version 1.0
 */
public class find_Min_Fibonacci_Numbers_1414 {
    @Test
    public void test() {
        System.out.println(findMinFibonacciNumbers(7));
    }

    public int findMinFibonacciNumbers(int k) {
        if(k==0) return 0;
        int f1 = 1, f2 = 1;
        while (f2 <= k) {
            int f3 = f1 + f2;
            f1 = f2;
            f2 = f3;
        }
        return 1 + findMinFibonacciNumbers(k - f1);
    }
    /*
    List<Integer> li = new ArrayList<>();

    {
        li.add(1);
        li.add(1);
    }

    public int findMinFibonacciNumbers(int k) {
        if (k == 0) return 0;
        int index = binSearch(k);
        return 1 + findMinFibonacciNumbers(k - li.get(index));
    }


    private int binSearch(int num) {
        while (li.get(li.size() - 1) <= num) {
            int n = li.size();
            li.add(li.get(n - 1) + li.get(n - 2));
        }
        int l = 0, r = li.size() - 1;
        while (l < r) {
            int mid = l + (r - l + 1) / 2;
            if (li.get(mid) > num) {
                r = mid - 1;
            } else {
                l = mid;
            }
        }
        return l;
    }*/
}
