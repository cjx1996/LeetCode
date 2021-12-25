/**
 * @ClassName Ranson_Note_383
 * @Description
 * @Author cjx
 * @Date 2021/12/4 14:57
 * @Version 1.0
 */
public class Ranson_Note_383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] cnt = new int[26];
        char[] ran = ransomNote.toCharArray();
        char[] mag = magazine.toCharArray();
        for (int i = 0; i < ran.length; i++) {
            char c = ran[i];
            cnt[c - 'a']++;
        }
        for (int i = 0; i < mag.length; i++) {
            char c = mag[i];
            cnt[c - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (cnt[i] > 0) return false;
        }
        return true;
    }
}
