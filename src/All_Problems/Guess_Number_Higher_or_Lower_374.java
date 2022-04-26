package All_Problems;

/**
 * @ClassName Guess_Number_Higher_or_Lower_374
 * @Description
 * @Author cjx
 * @Date 2021/11/12 11:57
 * @Version 1.0
 */
public class Guess_Number_Higher_or_Lower_374 {
    public int guessNumber(int n){
        int low = 1,high = n;
        int mid = low+(high-low)/2;
        while(guess(mid)!=0){

            if (guess(mid)==-1) {
                high = mid-1;
            }
            if(guess(mid)==1){
                low = mid+1;
            }
            mid = low+(high-low)/2;
        }
        return mid;
    }
    int guess(int num){
       double ran = Math.random();
       if(ran==0) return 0;
       if(ran>0) return 1;
       else return -1;
    }
}
