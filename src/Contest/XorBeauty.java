package Contest;

import org.junit.Test;

/**
 * @ClassName XorBeauty
 * @Description
 * @Author cjx
 * @Date 2023/1/7 23:13
 * @Version 1.0
 */
public class XorBeauty {
    @Test
    public void test(){
        int[] nums=new int[]{1,4};
        System.out.println(xorBeauty(nums));
    }
    public int xorBeauty(int[] nums) {
        int[] cnt=new int[32];
        int n = nums.length;
        for(int num:nums){
            int pow=0;
            while(num!=0){
                cnt[31-pow]+=num%2;
                num>>=1;
                pow++;
            }
        }
        int[] ans=new int[32];
        for(int i=0;i<32;i++){
            if(cnt[i]%2==0){
                ans[i]=0;
                continue;
            }else ans[i]=1;
        }
        int res=0;
        for(int i=0;i<32;i++){
            res=res*2+ans[i];
        }
        return res;
    }

}
