package All_Problems;

import org.junit.Test;

/**
 * @ClassName Bulb_Switcher_319
 * @Description
 * @Author cjx
 * @Date 2021/11/15 16:07
 * @Version 1.0
 */
public class Bulb_Switcher_319 {
    @Test
    public void test(){
        System.out.println(bulbSwitch(6));}
    public int bulbSwitch(int n) {
        if (n == 0) return 0;

        return (int)Math.sqrt(n);

    }
}
