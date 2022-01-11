/**
 * @ClassName Maximum_Nesting_Depth_of_the_Parentheses
 * @Description
 * @Author cjx
 * @Date 2022/1/7 12:48
 * @Version 1.0
 */
public class Maximum_Nesting_Depth_of_the_Parentheses {
    public int maxDepth(String s){
        int ans = 0;
        int level = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='('){
                level++;
                ans = Math.max(ans,level);
            }else if(s.charAt(i)==')'){
                level--;
            }else {
                ans= Math.max(ans,level);
            }
        }
        return ans;
    }
}
