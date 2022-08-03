package All_Problems;

import org.junit.Test;

/**
 * @ClassName Validate_IP_Address_468
 * @Description
 * @Author cjx
 * @Date 2022/5/29 19:13
 * @Version 1.0
 */
public class Validate_IP_Address_468 {
    @Test
    public void test() {
        String s = "";
        System.out.println(validIPAddress(s));
    }

    public String validIPAddress(String queryIP) {
        if (isIPV4(queryIP)) return "IPv4";
        else if (isIPV6(queryIP)) return "IPv6";
        else return "Neither";
    }

    boolean isIPV4(String queryIP) {
        String[] ss = queryIP.split("\\.");
        if (ss.length != 4) return false;
        if(queryIP.charAt(0)=='.'||queryIP.charAt(queryIP.length()-1)=='.') return false;
        for (int i = 0; i < 4; i++) {
            if (!validIPV4(ss[i])) return false;
        }
        return true;
    }

    boolean validIPV4(String address) {
        int n = address.length();
        if (n > 3||n==0) return false;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int cur = address.charAt(i) - '0';
            if (sum == 0 &&  i > 0) return false;
            if (cur < 0 || cur > 9) return false;
            sum = sum * 10 + cur;
        }
        if (sum > 255) return false;
        return true;
    }

    boolean isIPV6(String queryIP) {
        String[] ss = queryIP.split("\\:");
        if (ss.length != 8) return false;
        if(queryIP.charAt(0)==':'||queryIP.charAt(queryIP.length()-1)==':') return false;
        for (int i = 0; i < 8; i++) {
            if (!validIPV6(ss[i])) return false;
        }
        return true;
    }

    boolean validIPV6(String address) {
        int n = address.length();
        if (n > 4||n==0) return false;
        for (int i = 0; i < n; i++) {
            char cur = address.charAt(i);
            if ((cur >= '0' && cur <= '9') || (cur >= 'a' && cur <= 'f') || (cur >= 'A' && cur <= 'F')) continue;
            else return false;
        }
        return true;
    }

}
