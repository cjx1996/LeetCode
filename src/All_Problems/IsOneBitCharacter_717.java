package All_Problems;

import org.junit.Test;

/**
 * @ClassName IsOneBitCharacter_717
 * @Description
 * @Author cjx
 * @Date 2022/2/20 9:59
 * @Version 1.0
 */
public class IsOneBitCharacter_717 {
    @Test
    public void test() {
        int[] bits = new int[]{1, 1, 1, 0};
        System.out.println(isOneBitCharacter(bits));
    }

    public boolean isOneBitCharacter(int[] bits) {
        int n = bits.length;
        int index = 0;
        while(index<n-1){
            if(bits[index]==0) index++;
            else index+=2;
        }
        return index==n-1;
    }
}
