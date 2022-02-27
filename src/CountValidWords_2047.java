import org.junit.Test;

/**
 * @ClassName CountValidWords_2047
 * @Description
 * @Author cjx
 * @Date 2022/1/27 14:19
 * @Version 1.0
 */
public class CountValidWords_2047 {
    @Test
    public void test() {
        String sentence = "cat and dog";
        System.out.println(countValidWords(sentence));
    }

    public int countValidWords(String sentence) {
        String[] words = sentence.split(" ");
        int ans = 0;
        for (String word : words) {
            if (isValid(word)) ans++;
        }
        return ans;
    }

    public boolean isValid(String word) {
        int n = word.length();
        if(n==0) return false;
        for (int i = 0,cnt = 0; i < n; i++) {
            char c = word.charAt(i);
            if('a'<=c&&c<='z') continue;
            if('0'<=c&&c<='9') return false;
            if(c=='-'){
                if(i==0||i==n-1||cnt>0) return false;
                char pre = word.charAt(i-1),nex=word.charAt(i+1);
                if(pre<'a'||pre>'z'||nex<'a'||nex>'z') return false;
                continue;
            }
            if(c=='.'||c==','||c=='!') {
                if(i!=n-1) return false;
                continue;
            }
            return false;
        }
        return true;
        //这部分代码写的不好，重写
        /*
        if(word.isBlank()) return false;
        int hyps = 0, marks = 0;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (Character.isLetter(c)) continue;
            else if ('0' <= c && c <= '9') return false;
            else if (c == '-') {
                if (i == 0 || i == word.length() - 1 || hyps > 0)
                    return false;
                else if (Character.isLetter(word.charAt(i - 1)) && Character.isLetter(word.charAt(i + 1)))
                    hyps++;
                else return false;
            } else if (i == word.length() - 1) {
                marks++;
            } else {
                return false;
            }
        }
        return true;
        */
    }
}
