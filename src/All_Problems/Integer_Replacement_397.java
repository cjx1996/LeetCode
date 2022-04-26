package All_Problems;

import org.junit.Test;

/**
 * @ClassName Integer_Replacement_397
 * @Description
 * @Author cjx
 * @Date 2021/11/19 11:55
 * @Version 1.0
 */
public class Integer_Replacement_397 {
    @Test
    public void test() {
        System.out.println(integerReplacement(2147483647));
    }

    public int integerReplacement(int n) {
        if(n==1) return 0;
        if(n%2==0) return 1+integerReplacement(n/2);
        else {
            if((n>>1)%2==0||n==3){
                return 2+integerReplacement((n-1)/2);
            }else{
                return 2+integerReplacement((n-1)/2+1);
            }
        }
    }
}
