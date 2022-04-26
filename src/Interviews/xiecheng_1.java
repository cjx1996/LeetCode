package Interviews;

import java.util.Scanner;

/**
 * @ClassName Interviews.xiecheng_1
 * @Description
 * @Author cjx
 * @Date 2022/4/14 19:11
 * @Version 1.0
 */
public class xiecheng_1 {
    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < n; j++) {
            sb.append('*');
        }
        for (int j = 0; j < 2 * n; j++) {
            sb.append('.');
        }
        for (int j = 0; j < n; j++) {
            sb.append('*');
        }
        for (int i = 0; i < 3*n; i++) {
            System.out.println(sb);
        }
        sb= new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb= new StringBuilder();
            for (int j = 0; j <i+1 ; j++) {
                sb.append('.');
            }
            for (int j = 0; j < n; j++) {
                sb.append('*');
            }
            for (int j = 0; j < 2 * n - 2 - 2 * i; j++) {
                sb.append('.');
            }
            for (int j = 0; j < n; j++) {
                sb.append('*');
            }
            for (int j = 0; j < i+1; j++) {
                sb.append('.');
            }
            System.out.println(sb);
        }
    }

}
