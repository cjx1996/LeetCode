package Contest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName MinOperations_6365
 * @Description
 * @Author cjx
 * @Date 2023/2/19 11:25
 * @Version 1.0
 */
public class MinOperations_6365 {
    @Test
    public void test() {
        int n = 25;
        System.out.println(minOperations(n));
    }

/*
    public int minOperations(int n) {
       if( Integer.bitCount(n)==1) return 1;
        int x = n - (n & (n - 1));
        int res = Math.min(minOperations(n + x), minOperations(n - x)) + 1;
        return res;
    }
*/
    public int minOperations(int n){
        int ans=0,cnt=0;
        while(n!=0){
            if((n&1)==1)cnt++;
            else{
                if(cnt==1){
                    ans++;
                    cnt=0;
                }else if(cnt>1){
                    ans++;
                    cnt=1;
                }
            }
            n>>=1;
        }
        if(cnt==1) ans++;
        else ans+=2;
        return ans;
    }
}
