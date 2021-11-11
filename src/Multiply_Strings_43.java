import org.junit.Test;

/**
 * @ClassName Multiply_Strings_43
 * @Description
 * @Author cjx
 * @Date 2021/8/25 17:35
 * @Version 1.0
 */
public class Multiply_Strings_43 {
    @Test
    public void test() {
        System.out.println(multiply("123", "456"));
    }

    public String multiply(String num1, String num2) {

        StringBuffer[] results = new StringBuffer[num2.length()];
        for (int i = 0; i < num2.length(); i++) {
            results[i] = multiplyBit(num1, num2.charAt(i), num2.length() - 1 - i);
        }
        StringBuffer result = new StringBuffer();
        for (StringBuffer buffer : results) {
            result = add(result, buffer);
        }
        return String.valueOf(result.reverse());

    }

    StringBuffer multiplyBit(String num1, char bit, int weight) {
        if(bit=='0'||num1.equals("0")) return new StringBuffer("0");
        int bit2 = bit - '0';
        int i = 0;
        int carry = 0;
        StringBuffer result = new StringBuffer();
        for (int j = 0; j < weight; j++) {
            result.append('0');
        }
        while (i < num1.length() || carry != 0) {
            int bit1 = i < num1.length() ? num1.charAt(num1.length() - 1 - i) - '0' : 0;
            int sum = bit1 * bit2 + carry;
            result.append((char) (sum % 10 + '0'));
            carry = sum / 10;
            i++;
        }
        return result;
    }

    StringBuffer add(StringBuffer str1, StringBuffer str2) {
        int len1 = str1.length(), len2 = str2.length();
        StringBuffer result = new StringBuffer();
        int i = 0, j = 0, carry = 0;
        while (i < len1 || j < len2 || carry != 0) {
            int a = i < len1 ? str1.charAt(i) - '0' : 0;
            int b = j < len2 ? str2.charAt(j) - '0' : 0;
            int sum = a + b + carry;
            carry = sum / 10;
            result.append((char) (sum % 10 + '0'));
            i++;
            j++;
        }
        return result;
    }
}
