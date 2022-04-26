package All_Problems;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Simplified_Fractions_1447
 * @Description
 * @Author cjx
 * @Date 2022/2/10 11:12
 * @Version 1.0
 */
public class Simplified_Fractions_1447 {
    public List<String> simplifiedFractions(int n){
        ArrayList<String> ans = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                if(gcd(i,j)==1){
                    ans.add(j+"/"+i);
                }
            }
        }
        return ans;
    }

    public int gcd(int a,int b){
        if(a%b==0)return b;
        return gcd(b,a%b);
    }
}
