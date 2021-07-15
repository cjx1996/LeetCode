import java.util.HashMap;

/**
 * @ClassName Two_Sum_1
 * @Description TODO
 * @Author cjx
 * @Date 2021/6/2 23:20
 * @Version 1.0
 */
public class Two_Sum_1 {
    public int[] twoSum(int[] sums, int target){
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < sums.length; i++) {
            if(map.containsKey(target-sums[i]))
                return new int[]{map.get(target-sums[i]),i};
            else{
                map.put(sums[i],i);
            }
        }
        return new int[0];
    }
}
