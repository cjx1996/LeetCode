package All_Problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @ClassName Unique_Email_Addresses_929
 * @Description
 * @Author cjx
 * @Date 2022/6/4 16:57
 * @Version 1.0
 */
public class Unique_Email_Addresses_929 {

    public int numUniqueEmails(String[] emails) {
        Set<String> set=new HashSet<>();
        for(String str:emails){
            StringBuilder sb=new StringBuilder();
            int n = str.length();
            int i =0;
            boolean  flag=true;
            while(i<n){
                char c = str.charAt(i);
                if(c=='@'&&i++>=0) break;
                if(c=='.') continue;
                if(c=='+')flag=false;
                if(flag) sb.append(c);
                i++;
            }
            set.add(sb.append(str.substring(i)).toString());
        }
        return set.size();
    }

}
