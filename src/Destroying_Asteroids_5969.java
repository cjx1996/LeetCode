import org.junit.Test;

import java.util.Arrays;

/**
 * @ClassName Destorying_Asteroids_5969
 * @Description
 * @Author cjx
 * @Date 2022/1/2 10:43
 * @Version 1.0
 */
public class Destroying_Asteroids_5969 {



    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        for (int i = 0; i < asteroids.length; i++) {
            int cur = asteroids[i];
            if (mass >= cur) {
                mass += cur;
            } else {
                return false;
            }
        }
        return true;
    }
}
