import org.junit.Test;

import java.util.Stack;

/**
 * @author cjx
 * @description
 * @create 2021-01-21-14:34
 */
public class Valid_Parentheses_20 {

    @Test
    public void test(){
        String s =  "{[]}";
        System.out.println(isValid(s));
    }

    public boolean isValid(String s) {
        int len = s.length();
        if (len % 2 == 1) {
            return false;
        }
        Stack<Character> stack= new Stack<>();
        for (int i= 0; i <len; i++) {
            if(stack.empty()){
                stack.push(s.charAt(i));
                //这里通过对ASCII码的理解来判断是否能配对，如果当前char和stack栈顶的charASCII码相差1或2，认为此时配对，这是由ASCII码决定的
                //但有个特别之处在于，当不能配对时，如果当前的是左括号，那么将其推入栈中；如果当前是右括号，逻辑上已经可以认为是
                //输出false了，但无法判断是否是右括号，只好也同样将其推入栈中，在后续的配对中，这个右括号永远也不能被配对推出，因此最后的判断
                //stack.empty()一定输出fasle，不影响最终结果的输出
            }else if((s.charAt(i)-stack.peek())==1||(s.charAt(i)-stack.peek())==2){
                stack.pop();
            }else{
                stack.push(s.charAt(i));
            }

        }
        return stack.empty();
    }


}
