import java.util.*;

/**
 * @ClassName UncommonWordsfromTwoSentences_884
 * @Description
 * @Author cjx
 * @Date 2022/1/30 21:25
 * @Version 1.0
 */
public class UncommonWordsfromTwoSentences_884 {
    public String[] uncommonFromSentences(String s1,String s2){
       List<String> ans = new ArrayList<String>();
        String[] ss1 = s1.split(" ");
        String[] ss2 = s2.split(" ");
        Map<String,Integer> map = new HashMap<>();
        for (String s : ss1) {
            Integer cnt = map.get(s);
            if(cnt==1){
                ans.remove(s);
                map.put(s,2);
            }else if(cnt==2){
                continue;
            }else if(cnt==null){
                map.put(s,1);
                ans.add(s);
            }
        }
        for (String s : ss2) {
            Integer cnt = map.get(s);
            if(cnt==1){
                ans.remove(s);
                map.put(s,2);
            }else if(cnt==2){
                continue;
            }else if(cnt==null){
                map.put(s,1);
                ans.add(s);
            }
        }
        return ans.toArray(new String[0]);
    }
}
