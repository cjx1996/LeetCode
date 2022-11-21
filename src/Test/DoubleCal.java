package Test;

import org.junit.Test;

/**
 * @ClassName DoubleCal
 * @Description
 * @Author cjx
 * @Date 2022/9/13 20:16
 * @Version 1.0
 */
public class DoubleCal {
    @Test
    public void test(){
        double x=1.732;
        System.out.println((int)(x*100)/100.0);
    }
    @Test
    public void test2(){
        int b=0b10;
        int c=0x10;
        int d=010;
        System.out.println(b+" "+c+" "+d);
    }


}
