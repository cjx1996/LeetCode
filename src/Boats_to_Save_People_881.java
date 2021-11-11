import org.junit.Test;

import java.util.Arrays;

/**
 * @ClassName Boats_to_Save_People
 * @Description
 * @Author cjx
 * @Date 2021/8/26 10:40
 * @Version 1.0
 */
public class Boats_to_Save_People_881 {
    @Test
    public void test() {
        int[] people = new int[]{3, 2, 2, 2, 1};
        System.out.println(numRescueBoats(people, 3));
    }

    public int numRescueBoats(int[] people, int limit) {
        int len = people.length;
        if (len == 1) return 1;
        Arrays.sort(people);
        int left = 0, right = len - 1;
        int cnt = 0;
        while (left <= right) {
            cnt++;
            if (people[left] + people[right] <= limit) {
                left++;
                right--;
            } else {
                right--;
            }
        }
        return cnt;
    }
}
