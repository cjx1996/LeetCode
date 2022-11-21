package Interviews;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @ClassName XC0928_1
 * @Description
 * @Author cjx
 * @Date 2022/9/28 19:30
 * @Version 1.0
 */
public class XC0928_1 {
    public static void main(String[] args) {
        Scanner scan =new Scanner(System.in);
        int n = Integer.valueOf(scan.nextLine());
        for (int i = 0; i < n; i++) {
            String[] ss=scan.nextLine().split(" ");
            System.out.println(onceExchange(ss[0],ss[1]));
        }
    }
    static String onceExchange(String str1,String str2){
        char[] cs1 = str1.toCharArray();
        char[] cs2 = str2.toCharArray();
        Map<Character,Integer> map=new HashMap<>();
        int n1=cs1.length,n2=cs2.length;
        if(n1!=n2) return "No";
        int cnt=0;
        boolean overTwo=false;
        for(int i=0;i<n1;i++){
            char c1=cs1[i],c2=cs2[i];
            map.put(c1,map.getOrDefault(c1,0)+1);
            if(c1!=c2)cnt++;
        }
        for (int i = 0; i < n1; i++) {
            char c2=cs2[i];
            if(map.getOrDefault(c2,0)>=2) overTwo=true;
            map.put(c2,map.getOrDefault(c2,0)-1);
        }
        for (Integer value : map.values()) {
            if(value!=0) return "No";
        }
        if(cnt==2||(cnt==0&&overTwo)) return "Yes";
        else return "No";
    }

}
