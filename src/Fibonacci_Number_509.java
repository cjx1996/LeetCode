import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cjx
 * @create 2021-01-04-15:45
 * @description
 */
public class Fibonacci_Number_509 {

    @Test
    public void test(){
        System.out.println(fib(20));
    }

    public int fib(int n) {
        List<Integer> results=new ArrayList<>();
        results.add(0);
        results.add(1);
        for(int i =2;i<n+1;i++){
            results.add(results.get(i-1)+results.get(i-2));
        }
        return results.get(n);
    }

}
