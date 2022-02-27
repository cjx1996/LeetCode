import org.junit.Test;

/**
 * @ClassName Complex_Number_Multiplication_537
 * @Description
 * @Author cjx
 * @Date 2022/2/25 9:56
 * @Version 1.0
 */
public class Complex_Number_Multiplication_537 {
    @Test
    public void test() {
        String num1 = "1+1i";
        String num2 = "1+1i";
        System.out.println(complexNumberMultiply(num1, num2));
    }

    public String complexNumberMultiply(String num1, String num2) {
        int a = Integer.valueOf(num1.substring(0, num1.indexOf('+')));
        int b = Integer.valueOf(num1.substring(num1.indexOf('+') + 1, num1.length()-1));
        int c = Integer.valueOf(num2.substring(0, num2.indexOf('+')));
        int d = Integer.valueOf(num2.substring(num2.indexOf('+') + 1, num2.length()-1));
        int na = a * c - b * d;
        int nb = (b * c + a * d);
        return "" + na + "+" + nb + "i";
    }
}
