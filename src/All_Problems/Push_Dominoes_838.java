package All_Problems;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * @ClassName Push_Dominoes_838
 * @Description
 * @Author cjx
 * @Date 2022/2/21 10:52
 * @Version 1.0
 */
public class Push_Dominoes_838 {
    @Test
    public void test() {
        String dominoes = ".L.R...LR..L..";
        String s = pushDominoes(dominoes);
        System.out.println(s);
    }
/*
    public String pushDominoes(String dominoes){
        char[] cs = dominoes.toCharArray();
        int n = cs.length;
        ArrayDeque<int[]> d = new ArrayDeque<>();
        int[] g= new int[n];
        for (int i = 0; i < n; i++) {
            if(cs[i]!='.'){
                int dir = cs[i]=='L'?-1:1;
                d.add(new int[]{i,1,dir});
                g[i]=1;
            }
        }
        while(!d.isEmpty()){
            int[] point = d.poll();
            int pos = point[0],time=point[1],dir = point[2];
            int ne = pos+dir;
            if(cs[pos]=='.'||ne<0||ne>=n) continue;
            if(g[ne]==0){
                cs[ne] =dir==-1?'L':'R';
                d.add(new int[]{ne,time+1,dir});
                g[ne] = time+1;
            }else if(g[ne]==time+1){
                cs[ne]='.';
            }
        }
        return String.valueOf(cs);
    }
*/

    public String pushDominoes(String dominoes) {
       int n =dominoes.length();
        char[] cs = dominoes.toCharArray();
        for (int i = 0; i < n; i++) {
            if(cs[i]=='.'){
                int l = i;
                while(i<n&&cs[i]=='.') i++;
                int r = i;
                if(r==n||cs[r]=='R') {
                    if(l>0&&cs[l-1]=='R'){
                        for(int j=l;j<r;j++) cs[j]='R';
                    }
                }else{
                    if(l==0||cs[l-1]=='L') for(int j=l;j<r;j++) cs[j]='L';
                    else{
                        while(l<r-1){
                            cs[l]='R';
                            cs[r-1]='L';
                            l++;
                            r--;
                        }
                    }
                }
            }
        }
        return String.valueOf(cs);
    }


}
