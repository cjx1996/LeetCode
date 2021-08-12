/**
 * @ClassName Minimum_Number_of_Swaps_5840
 * @Description
 * @Author cjx
 * @Date 2021/8/8 18:25
 * @Version 1.0
 */
public class Minimum_Number_of_Swaps_5840 {
    public int minSwaps(String s){
        //记录未被匹配的[的个数
        int cnt = 0;
        for(char c: s.toCharArray()){
            if(c==']'){
                if(cnt>0){
                    cnt--;
                }
            }
            else{
                cnt++;
            }
        }
        return (cnt++)>>1;
    }
}
