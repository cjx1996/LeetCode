import org.junit.Test;

/**
 * @ClassName Nth_Tribonacci_Number_1137
 * @Description
 * @Author cjx
 * @Date 2021/8/8 9:48
 * @Version 1.0
 */
public class Nth_Tribonacci_Number_1137 {
    @Test
    public void test(){
        System.out.println(tribonacci(1));}
        //统一n为0、1、2的情况
    public int tribonacci(int n){
        int[] res = new int[n+4];
        res[0] =-1;
        res[1] = 1;
        res[2] = 0;
        for (int i = 3; i < n+4; i++) {
            res[i]= res[i-1]+res[i-2]+res[i-3];
        }
        return res[n+3];

    }
}
