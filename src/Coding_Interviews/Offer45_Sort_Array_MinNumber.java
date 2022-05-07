package Coding_Interviews;

import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @ClassName Offer45_Sort_Array_MinNumber
 * @Description
 * @Author cjx
 * @Date 2022/4/29 15:08
 * @Version 1.0
 */
public class Offer45_Sort_Array_MinNumber {
    @Test
    public void test(){
        int[] nums=new int[]{10,20,30,0,50,55,2,22};
        System.out.println(minNumber(nums));
    }

    public String minNumber(int[] nums){
     /*   PriorityQueue<String> q=new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return compareStrs(o1,o2);
            }
        });
        for (int num : nums) {
            q.add(String.valueOf(num));
        }
        StringBuilder sb=new StringBuilder();
        while(!q.isEmpty()){
            sb.append(q.poll());
        }
        return sb.toString();*/
        int n =nums.length;
        String[] ss=new String[n];
        for (int i = 0; i < n; i++) {
            ss[i]=String.valueOf(nums[i]);
        }
        quickSort(ss,0,n-1);
        StringBuilder sb=new StringBuilder();
        for (String s : ss) {
            sb.append(s);
        }
        return sb.toString();
    }
    public void quickSort(String[] ss,int l,int r){
        if(l>r) return;
        int i =l,j=r;
        String key=ss[l];
        while(i<j){
            while(i<j&&compareStrs(key,ss[j])<0) j--;
            while(i<j&&compareStrs(key,ss[i])>=0) i++;
            if(i<j){
                String tem = ss[i];
                ss[i] = ss[j];
                ss[j] = tem;
            }
        }
        ss[l]=ss[i];
        ss[i]=key;
        quickSort(ss,l,i-1);
        quickSort(ss,i+1,r);
    }
    int compareStrs(String str1,String str2){
        String s1=str1+str2;
        String s2=str2+str1;
        char[] cs1=s1.toCharArray();
        char[] cs2=s2.toCharArray();
        for (int i = 0; i < cs1.length; i++) {
            if(cs1[i]!=cs2[i]) return cs1[i]-cs2[i];
        }
        return 0;
    }

}
