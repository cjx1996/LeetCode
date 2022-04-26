package All_Problems;

/**
 * @ClassName First_Bad_Version_278
 * @Description
 * @Author cjx
 * @Date 2021/8/6 19:59
 * @Version 1.0
 */
public class First_Bad_Version_278 {
    public int firstBadVersion(int n){
        int l = 1;
        int h = n;
        while(l<h){
            int mid = l+(h-l)/2;
            if(isBadVersion(mid)){
                h = mid;
            }else {
                l = mid+1;
            }
        }
        return l;
    }
    boolean isBadVersion(int version){
        return false;
    }
}
