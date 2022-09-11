package Interviews;

import org.junit.Test;

/**
 * @ClassName QuickSort
 * @Description
 * @Author cjx
 * @Date 2022/9/6 19:24
 * @Version 1.0
 */
public class QuickSort {
    @Test
    public void test(){
        int[] arr=new int[]{3,5,1,6,7,-1};

        int[] nums=new int[]{10,20,30,0,50,55,2,22};
        quickSort(nums,0,arr.length-1);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(nums[i]);
        }
    }
    public void quickSort(int[] arr,int star,int end){
        if(star>=end)return;
        int i =star;
        int j=end;
        int key =arr[star];
        while(i<j){
            while(i<j&&arr[j]>key){
                j--;
            }
            while(i<j&&arr[i]<=key){
                i++;
            }
            if(i<j){
                int tem=arr[i];
                arr[i]=arr[j];
                arr[j]=tem;
            }
        }
        arr[star]=arr[i];
        arr[i]=key;
        quickSort(arr,star,i-1);
        quickSort(arr,i+1,end);
    }

}
