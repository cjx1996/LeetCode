package All_Problems;

import org.junit.Test;

import java.util.Arrays;

/**
 * @ClassName ApplyOperations_2460
 * @Description
 * 给你一个下标从 0 开始的数组 nums ，数组大小为 n ，且由 非负 整数组成。
 *
 * 你需要对数组执行 n - 1 步操作，其中第 i 步操作（从 0 开始计数）要求对 nums 中第 i 个元素执行下述指令：
 *
 * 如果 nums[i] == nums[i + 1] ，则 nums[i] 的值变成原来的 2 倍，nums[i + 1] 的值变成 0 。否则，跳过这步操作。
 * 在执行完 全部 操作后，将所有 0 移动 到数组的 末尾 。
 *
 * 例如，数组 [1,0,2,0,0,1] 将所有 0 移动到末尾后变为 [1,2,1,0,0,0] 。
 * 返回结果数组。
 *
 * 注意 操作应当 依次有序 执行，而不是一次性全部执行。
 * @Author 陈加兴
 * @Date 2023/6/5 13:45
 * @Version 1.0
 */
public class ApplyOperations_2460 {
    @Test
    public void test(){
        int[] arr=new int[]{0,1};
        int[] ans = applyOperations(arr);
        Arrays.stream(ans).forEach(e->System.out.println(e));
    }
    public int[] applyOperations(int[] arr){
        int n =arr.length;
        for(int i=0;i<n;i++){
            if(i<n-1&&arr[i]==arr[i+1]){
                arr[i]*=2;
                arr[i+1]=0;
            }
        }
        int l=0,r=0;
        while(r<n){
            if(arr[r]!=0){
                arr[l++]=arr[r];
            }
            r++;
        }
        while(l<n){
            arr[l++]=0;
        }
        return arr;
    }
}
