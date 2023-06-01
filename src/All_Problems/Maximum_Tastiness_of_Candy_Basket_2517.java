package All_Problems;

import org.junit.Test;

import java.util.Arrays;

/**
 * @ClassName Maximum_Tastiness_of_Candy_Basket_2517
 * @Description
 * @Author 陈加兴
 * @Date 2023/6/1 17:56
 * @Version 1.0
 */
public class Maximum_Tastiness_of_Candy_Basket_2517 {
    @Test
    public void test(){
        int[] price=new int[]{7,7,7,7};
        int k = 2;
        System.out.println(maximumTastiness(price,k));
    }
    public int maximumTastiness(int[] price,int k){
        Arrays.sort(price);
        int n=  price.length;
        int l=0,r=(price[n-1]-price[0])/(k-1);
        while(l<r){
            int mid = ((r-l)>>1)+l+1;
            if(isValid(mid,price,k)){
                l=mid;
            }else r=mid-1;
        }
        return l;
    }
    boolean isValid(int interval,int[] price,int k){
        int cnt=0;
        int cur=price[0];
        for(int i:price){
            if(i>=cur+interval){
                cnt++;
                cur=i;
            }
        }
        return cnt>=k-1;
    }

}
