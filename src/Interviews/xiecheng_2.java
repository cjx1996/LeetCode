package Interviews;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @ClassName Interviews.xiecheng_2
 * @Description
 * @Author cjx
 * @Date 2022/4/14 19:36
 * @Version 1.0
 */
public class xiecheng_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i]=sc.nextInt();
        }
        sc.nextLine();
        String str = sc.nextLine();
        char[] cs  =str.toCharArray();

        long res = 0;
        Map<Integer,Integer> redHash = new HashMap<>();
        Map<Integer,Integer> blueHash = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if(cs[i]=='R'){
                redHash.put(nums[i],redHash.getOrDefault(nums[i],0 )+1);
            }else{
                blueHash.put(nums[i],blueHash.getOrDefault(nums[i],0)+1);
            }
        }
        for (Integer key : redHash.keySet()) {
            res+=(long)redHash.get(key)*(long)blueHash.getOrDefault(key,0);
        }
        System.out.println(res);
    }

}
