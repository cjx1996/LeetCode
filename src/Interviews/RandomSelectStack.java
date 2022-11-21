package Interviews;

import java.util.Scanner;

/**
 * @ClassName RandomSelectStack
 * @Description
 * @Author cjx
 * @Date 2022/9/24 19:01
 * @Version 1.0
 */
public class RandomSelectStack {
    public static void main(String[] args) {
        System.out.println(lastRemaining(15,7)+1);
    }
    static public int lastRemaining(int n,int m){
        return f(n,m);
    }
    static public int f(int n,int m){
        if(n==1) return 0;
        int x=f(n-1,m);
        return (m+x)%n;
    }

}
