package All_Problems;

import org.junit.Test;

/**
 * @ClassName Find_the_Duplicate_Number_287
 * @Description
 * @Author cjx
 * @Date 2023/1/7 16:51
 * @Version 1.0
 */
public class Find_the_Duplicate_Number_287 {
    @Test
    public void test(){
        int[] nums=new int[]{1,3,4,2,2};
        System.out.println(findDuplicate(nums));
    }
    public int findDuplicate(int[] nums) {
        int n=nums.length-1;
        int bitMax=31;
        while((n>>bitMax)==0){
            bitMax--;
        }
        int[] cnt=new int[bitMax+1];
        for(int num:nums){
            int pow=0;
            while(num!=0){
                cnt[bitMax-pow]+=num%2;
                num>>=1;
                pow++;
            }
        }
        for(int i=1;i<=n;i++){
            int pow=0;
            int num =i;
            while(num!=0){
                cnt[bitMax-pow]-=num%2;
                num>>=1;
                pow++;
            }
        }
        int ans=0;
        for(int i=0;i<=bitMax;i++){
            ans=ans*2+(cnt[i]>0?cnt[i]:0);
        }
        return ans;
    }

}
