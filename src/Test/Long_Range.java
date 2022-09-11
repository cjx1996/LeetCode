package Test;

import org.junit.Test;

/**
 * @ClassName Long_Range
 * @Description
 * @Author cjx
 * @Date 2022/9/5 14:32
 * @Version 1.0
 */
public class Long_Range {
    @Test
    public void test(){
        long a=24*60*60*1000*1000; //这里发生了int类型溢出，实际执行过程中是几个int数先相乘，发生了int数值溢出后又将溢出的值赋给了long类型变量a
        System.out.println(a);
        System.out.println(a/1000/1000/60/60);
    }

}
