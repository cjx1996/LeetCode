import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName Slowest_Key_1629
 * @Description
 * @Author cjx
 * @Date 2022/1/9 10:26
 * @Version 1.0
 */
public class Slowest_Key_1629 {
    public char slowestKey(int[] releaseTimes,String keysPressed){
        char ans=127;
        int curLong = 0;
        for (int i = 0; i < keysPressed.length(); i++) {
            char cs= keysPressed.charAt(i);
            int time = releaseTimes[i];
            if(i>0) time-=releaseTimes[i-1];

            if(time>curLong||(time==curLong&&cs>ans)){
                ans = cs;
                curLong=time;
            }
        }
        return ans;
    }
}
