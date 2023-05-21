package All_Problems;
import org.junit.Test;

public class AddNegaBinary_1073 {
    @Test
    public void test(){
        int[] arr1=new int[]{1,1,0,1},arr2=new int[]{1,1,0,1};
        int[] ans=addNegabinary(arr1,arr2);
        for (int i : ans) {
            System.out.println(i);
        }
    }
    public int[] addNegabinary(int[] arr1, int[] arr2) {
        int m =arr1.length,n=arr2.length;
        if(m<n){
            int[] tem;
            tem=arr1;
            arr1=arr2;
            arr2=tem;
            m^=n;
            n^=m;
            m^=n;
        }
        int[] ans=new int[m+2];
        for(int i=0;i<m;i++){
            ans[m+1-i]=arr1[m-1-i]+(i<=n-1?arr2[n-1-i]:0);
        }
        for(int i=0;i<m;i++){
            int cur=ans[m+1-i];
            if(cur<=1)continue;
            if(cur>=2){
                ans[m+1-i]-=2;
                if(ans[m-i]>0) {
                    ans[m-i]--;
                }else{
                    ans[m-i]++;
                    ans[m-1-i]++;
                }
            }
        }
        int len=0;
        while(len<m+2&&ans[len]==0){
            len++;
        }
        if(len==m+2)return new int[]{0};
        int[] res=new int[m+2-len];
        for(int i=0;i<res.length;i++){
            res[res.length-1-i]=ans[m+1-i];
        }
        return res;
    }
}
