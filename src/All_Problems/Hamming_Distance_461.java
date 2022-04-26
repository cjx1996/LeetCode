package All_Problems;

import org.junit.Test;

/**
 * @ClassName Hamming_Distance_461
 * @Description
 * @Author cjx
 * @Date 2021/5/27 10:43
 * @Version 1.0
 */
public class Hamming_Distance_461 {
    @Test
    public void test(){
        int x= 1;
        int y = 3;
        System.out.println(hammingDistance(x,y));
    }

    public int hammingDistance(int x,int y){
        int z = x^y;

        int result=0;
        while(z!=0){
            z=z&(z-1);
            result++;
        }
        return result;
    }
}
