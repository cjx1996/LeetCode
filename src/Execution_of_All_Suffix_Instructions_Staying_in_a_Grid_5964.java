/**
 * @ClassName Execution_of_All_Suffix_Instructions_Staying_in_a_Grid_5964
 * @Description
 * @Author cjx
 * @Date 2021/12/26 10:44
 * @Version 1.0
 */
public class Execution_of_All_Suffix_Instructions_Staying_in_a_Grid_5964 {
    public int[] executeInstructions(int n,int[] startPos,String s){
        int[] ans =new int[s.length()];
        for (int i = 0; i < ans.length; i++) {
            int x= startPos[0],y = startPos[1];
            for (int j = i; j < ans.length; j++) {
                char c = s.charAt(j);
                switch (c){
                    case 'L': x--;break;
                    case 'R':x++;break;
                    case 'U':y--;break;
                    case 'D':y++;break;
                }
                if(x<0||x==n||y<0||y==n) {
                    ans[i]=j-i;
                    break;
                }else if(j==ans.length-1){
                    ans[i]=  j-i+1;
                    break;
                }
            }
        }
        return ans;
    }
}
