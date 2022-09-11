package Interviews;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @ClassName MeiTuan_0910_3
 * @Description
 * 看见这种题目就忍不住认为是dp，其实不是。
 * 这里不是dp，使用dp反而由于过于arr[i]的值可能特别大，导致超时。
 * 这里就是一个简单的迭代，时间复杂度为 n个宝藏的遍历时间复杂度为O(n)，而对于每一个已知位置的宝藏，都需要往上寻找父节点，由于n最大值为2^32，因此每个宝藏往上寻找的时间复杂度最大为O(32)。
 * 所以时间复杂度为O(n)
 * @Author cjx
 * @Date 2022/9/10 16:07
 * @Version 1.0
 */
public class MeiTuan_0910_3 {

    static Map<Integer,Integer> map=new HashMap<>();
    public static void main(String[] args) {
        Scanner scan= new Scanner(System.in);
        int n= scan.nextInt();
        int[] arr=new int[n];
        for (int i = 0; i < n; i++) {
            arr[i]=scan.nextInt();
        }
        for (int i = 0; i < n; i++) {
            map.put(arr[i],map.getOrDefault(arr[i],0)+scan.nextInt());
        }
        int ans=0;
        for (int i = 0; i < n; i++) {
            int cur=0;
            int index=arr[i];
            while(index>=1){
                cur+=map.getOrDefault(index,0);
                index>>=1;
            }
            ans=Math.max(ans,cur);
        }
        System.out.println(ans);
    }

}
