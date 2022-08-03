package All_Problems;

import org.junit.Test;

/**
 * @ClassName Unique_Paths_62
 * @Description
 * @Author cjx
 * @Date 2022/6/27 10:38
 * @Version 1.0
 */
public class Unique_Paths_62 {
    @Test
    public void test(){
        int m =10,n=10;
        System.out.println(uniquePaths(m,n));
    }
    public int uniquePaths(int m,int n){
        int a=n;
        int b=1;
        int ans=1;
        while(b<m){
            ans*=a++;
            ans/=b++;
        }
        return ans;
    }

}
