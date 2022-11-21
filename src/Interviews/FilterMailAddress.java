package Interviews;

import org.junit.Test;

/**
 * @ClassName FilterMailAddress
 * @Description
 * @Author cjx
 * @Date 2022/9/23 16:44
 * @Version 1.0
 */
public class FilterMailAddress {
    public String filter(String mail){
        char[] cs=mail.toCharArray();
        int n =cs.length;
        int index=mail.indexOf('@');
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < index; i++) {
            if(cs[i]=='.') continue;
            else if(cs[i]=='+') break;
            else sb.append(cs[i]);

        }
        return String.valueOf(sb)+mail.substring(index,n);
    }

}
