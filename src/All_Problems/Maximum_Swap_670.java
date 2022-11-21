package All_Problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName Maximum_Swap_670
 * @Description
 * @Author cjx
 * @Date 2022/9/13 22:43
 * @Version 1.0
 */
public class Maximum_Swap_670 {
    public int maximumSwap(int num){
        List<Integer> bits=new ArrayList<>();
        while(num!=0){
            bits.add(num%10);
            num/=10;
        }
        int n= bits.size();
        int[] index=new int[n];
        for (int i = 0,j=0; i < n; i++) {
            if(bits.get(i)>bits.get(j)) j=i;
            index[i]=j;
        }
        for (int i = n-1; i >=0; i--) {
            if(bits.get(i)!=bits.get(index[i])){
                int tem =bits.get(i);
                bits.set(i, bits.get(index[i]));
                bits.set(index[i],tem);
                break;
            }
        }
        int ans=0;
        for (int i = n-1; i >=0; i--) {
            ans=ans*10+bits.get(i);
        }
        return ans;
    }

}
