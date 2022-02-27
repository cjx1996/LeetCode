import org.junit.Test;

import java.util.Arrays;

/**
 * @ClassName The_Number_of_Weak_Characters_in_the_Game_1996
 * @Description
 * @Author cjx
 * @Date 2022/1/28 10:46
 * @Version 1.0
 */
public class The_Number_of_Weak_Characters_in_the_Game_1996 {
    @Test
    public void test(){
    int[][] properties= new int[][]{
            {2,2},
            {3,3}
    };
        System.out.println(numberOfWeakCharacter(properties));

    }
    public int numberOfWeakCharacter(int[][] properties){
        Arrays.sort(properties,(a,b)->(b[0]-a[0]));
        int n = properties.length;
        int max=0,ans=0;
        for (int i = 0; i < n; ) {
            int cur = max;
            int j = i;
            for (; j <n&&properties[i][0]==properties[j][0]; j++) {
                max = Math.max(max,properties[j][1]);
                if(properties[j][1]<cur){
                    ans++;
                }
            }
            i=j;
        }
        return ans;
    }
}
