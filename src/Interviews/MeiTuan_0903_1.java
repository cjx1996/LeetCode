package Interviews;

import java.util.Scanner;

/**
 * @ClassName MeiTuan_0903
 * @Description
 * @Author cjx
 * @Date 2022/9/3 9:58
 * @Version 1.0
 */
public class MeiTuan_0903_1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a= scan.nextInt();
        int b=scan.nextInt();
        if(b+2>=11){
            System.out.println((b+2-a));
            return;
        }else {
            System.out.println(11-a);
        }
    }

}
