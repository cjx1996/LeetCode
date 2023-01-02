package All_Problems;

import org.junit.Test;

import java.util.Arrays;

/**
 * @ClassName Soup_Servings_808
 * @Description
 * @Author cjx
 * @Date 2022/11/21 9:39
 * @Version 1.0
 */
public class Soup_Servings_808 {
    @Test
    public void test(){
        int n= 1;
        System.out.println(soupServings(n));
    }

    double[][] memo;
    public double soupServings(int n){
        n = (int)Math.ceil((double)n/25);
        if(n>179) return 1;
        memo=new double[n+1][n+1];
        return backTrack(n,n);
    }
    double backTrack(int m,int n){
        if(m<=0&&n<=0) return 0.5;
        else if(m<=0&&n>0) return 1;
        else if(m>0&&n<=0) return 0;

        if(memo[m][n]==0){
            memo[m][n]=0.25*(backTrack(m-4,n)+backTrack(m-3,n-1)+backTrack(m-2,n-2)+backTrack(m-1,n-3));
        }
        return memo[m][n];
    }
}
