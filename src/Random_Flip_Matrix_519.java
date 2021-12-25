import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @ClassName Random_Flip_Matrix_519
 * @Description
 * @Author cjx
 * @Date 2021/11/27 20:45
 * @Version 1.0
 */
public class Random_Flip_Matrix_519 {
    class Solution{
        int m,n,cnt;
        Map<Integer,Integer> map  = new HashMap<>();
        Random random = new Random();
        public Solution(int m,int n){
            this.m=m;
            this.n=n;
            this.cnt=m*n;
        }

        public int[] flip(){
            int x = random.nextInt(cnt--);
            x= map.getOrDefault(x,x);
            map.put(x,map.getOrDefault(cnt,cnt));
            return new int[]{x/n,x%n};
        }

        public void reset(){
            map.clear();
            cnt = m*n;
        }
    }
}
