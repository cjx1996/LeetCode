package Test;

import org.junit.Test;

/**
 * @ClassName String_split
 * @Description
 * @Author cjx
 * @Date 2022/8/31 19:59
 * @Version 1.0
 */
public class String_split {

    @Test
    public void test(){
        String s="a b  c";
        String[] ss=s.split(" ");
        for (int i = 0; i < ss.length; i++) {
            System.out.println("ss的第"+i+"个元素为:"+ss[i]);
        }
    }

}
