package All_Problems;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LetterTilePoss_1079 {
    @Test
    public void test() {
        String tiles = "V";
        System.out.println(numTilePossibilities(tiles));
    }


    int[] cnt = new int[26];
    int res=0;
    int max = 0;
    Set<Integer> set;

    public int numTilePossibilities(String tiles) {
        cnt = new int[26];
        res=0;
        set=new HashSet<>();
        char[] cs = tiles.toCharArray();
        max = cs.length;
        for (int i = 0; i < max; i++) {
            cnt[cs[i] - 'A']++;
            if(cnt[cs[i]-'A']>0)set.add(cs[i]-'A');
        }
        backTrack(0);
        return res;
    }

    void backTrack(int len) {
        if (len == max) return;
        for (int i:set) {
            if(cnt[i]>0){
                cnt[i]--;
                res++;
                backTrack(len+1);
                cnt[i]++;
            }
        }
    }

/*
    int[] cnt = new int[26];
    Set<String> res = new HashSet<>();
    int max = 0;

    public int numTilePossibilities(String tiles) {

        cnt = new int[26];
        res = new HashSet<>();
        char[] cs = tiles.toCharArray();
        max = cs.length;
        for (int i = 0; i < max; i++) {
            cnt[cs[i] - 'A']++;
        }
        backTrack(new ArrayList<>());
        return res.size();
    }
    void backTrack(List<Character> list) {
        int len = list.size();
        if (len == max) return;
        for (int i = 0; i < 26; i++) {
            if (cnt[i] > 0) {
                list.add((char) ('A' + i));
                res.add(String.valueOf(list));
                cnt[i]--;
                backTrack(list);
                list.remove(len);
                cnt[i]++;
            }
        }
   }
   */
}
