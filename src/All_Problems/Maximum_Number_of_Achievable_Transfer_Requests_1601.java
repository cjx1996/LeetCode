package All_Problems;

import org.junit.Test;

/**
 * @ClassName Maximum_Number_of_Achievable_Transfer_Requests_1601
 * @Description
 * @Author cjx
 * @Date 2022/2/28 10:01
 * @Version 1.0
 */
public class Maximum_Number_of_Achievable_Transfer_Requests_1601 {


    public int maximumRequests(int n, int[][] requests) {
        int m = requests.length;
        int N = (int) 1 << m;
        int ans = 0;
        for (int i = 1; i < N; i++) {
            int tem = count(i);
            if (tem <= ans) continue;
            if (isOk(i, requests)) ans = tem;
        }
        return ans;
    }

    boolean isOk(int s, int[][] requests) {
        int[] cnt = new int[20];
        int sum = 0;
        for (int i = 0; i < 16; i++) {
            if (((s >> i) & 1) != 0) {
                int[] route = requests[i];
                if (++cnt[route[0]] == 1) sum++;
                if (--cnt[route[1]] == 0) sum--;
            }
        }
        return sum == 0;
    }

    /* boolean isOk(int i,int[][] requests){
         int[] cnt = new int[20];
         int j = 0;
         while(i!=0){
             if((i&1)!=0){
                 int[] route = requests[j];
                 cnt[route[0]]--;
                 cnt[route[1]]++;
             }
             i>>=1;
             j++;
         }
         for (int k = 0; k < 20; k++) {
             if(cnt[k]!=0) return false;
         }
         return true;
     }*/
    int count(int s) {
        int ans = 0;
        for (int i = s; i > 0; i -= i & -i) ans++;
        return ans;
    }
    /*int count(int i){
        int ans = 0;
        while(i!=0){
            ans+=i&1;
            i>>=1;
        }
        return ans;
    }*/
}
