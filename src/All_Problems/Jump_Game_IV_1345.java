package All_Problems;

import org.junit.Test;

import java.util.*;

/**
 * @ClassName Jump_Game_IV_1345
 * @Description
 * @Author cjx
 * @Date 2022/1/21 11:11
 * @Version 1.0
 */
public class Jump_Game_IV_1345 {
    @Test
    public void test() {
        int[] arr = new int[]{100, -23, -23, 404, 100, 23, 23, 23, 3, 404};
        System.out.println(minJumps(arr));
    }

    public int minJumps(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int num = arr[i];
            if (!map.containsKey(num)) map.put(num, new ArrayList<>());
            List<Integer> list = map.get(num);
            list.add(i);
        }
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.add(n - 1);
        dp[n - 1] = 0;
        while (q.size() != 0) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Integer po = q.poll();
                if (po == 0) return dp[0];
                if (po > 0 && dp[po - 1] == -1) {
                    if(po==1) return dp[po]+1;
                    dp[po - 1] = dp[po] + 1;
                    q.add(po - 1);
                }
                if (po < n - 1 && dp[po + 1] == -1) {
                    dp[po + 1] = dp[po] + 1;
                    q.add(po + 1);
                }
                List<Integer> li = map.getOrDefault(arr[po], new ArrayList<>());
                for (Integer index : li) {
                    if (dp[index] == -1) {
                        if(index==0) return dp[po]+1;
                        dp[index] = dp[po] + 1;
                        q.add(index);
                    }
                }
                map.remove(arr[po]);
            }
        }
        return dp[0];
    }
}
