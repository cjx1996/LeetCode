package All_Problems;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName NumDifferenceIntegres_1805
 * @Description
 * @Author cjx
 * @Date 2022/12/6 9:37
 * @Version 1.0
 */
public class NumDifferenceIntegres_1805 {
    @Test
    public void test(){
        String word="0b0";
        System.out.println(numDifferentIntegers(word));
    }
    public int numDifferentIntegers(String word){
        Set<String> set=new HashSet<>();
        StringBuilder num=new StringBuilder();
        for(int i=0;i<word.length();i++){
            char c=word.charAt(i);
            if(c>='0'&&c<='9'){
                if((num.length()==1&&Integer.valueOf(num.toString())==0)){
                    num=new StringBuilder();
                }
                num.append(c);
            }else if(c>='a'&&c<='z'&&num.length()>0){
                set.add(num.toString());
                num=new StringBuilder();
            }
            if(i==word.length()-1&&num.length()>0){
                set.add(num.toString());
            }

        }
        return set.size();

    }

}
