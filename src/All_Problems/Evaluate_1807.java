package All_Problems;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName Evaluate_1807
 * @Description
 * @Author cjx
 * @Date 2023/1/12 9:53
 * @Version 1.0
 */
public class Evaluate_1807 {

    @Test
    public void test(){
        String s ="(a)(b)";
        List<List<String>> knowledge=new ArrayList<>();
        List<String> list=new ArrayList<>();
        list.add("a");list.add("b");
        knowledge.add(list);
        list=new ArrayList<>();
        list.add("b");list.add("a");
        knowledge.add(list);

        System.out.println(evaluate(s,knowledge));
    }
    public String evaluate(String s, List<List<String>> knowledge){
        Map<String,String> map=new HashMap<>();
        for (List<String> list : knowledge) {
            map.put(list.get(0),list.get(1));
        }
        boolean addKey=false;
        StringBuilder key=new StringBuilder();
        StringBuilder res=new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c=s.charAt(i);
            if(c=='('){
                addKey=true;
            }else if(c==')'){
                String value=map.getOrDefault(String.valueOf(key),"?");
                key=new StringBuilder();
                res.append(value);
                addKey=false;
            }else {
                if(addKey)key.append(c);
                else res.append(c);
            }
        }
        return res.toString();
    }

}
