package Test;

import org.junit.Test;

import java.util.Scanner;

/**
 * @ClassName Scanner_newLine
 * @Description
 * @Author cjx
 * @Date 2022/9/3 13:48
 * @Version 1.0
 */
public class Scanner_newLine {
    public static void main(String[] args) {
        Scanner scan= new Scanner(System.in);
        String str=scan.nextLine();
        String str2=scan.nextLine();
        String s3=scan.nextLine();
        System.out.println("str="+str);
        System.out.println("str2="+str2);
        System.out.println("s3="+s3);
    }


}
