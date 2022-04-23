import org.junit.Test;

/**
 * @ClassName Pow_x_n_50
 * @Description
 * @Author cjx
 * @Date 2022/4/16 14:54
 * @Version 1.0
 */
public class Pow_x_n_50 {
    @Test
    public void test(){
        System.out.println(myPow(2,Integer.MIN_VALUE));
    }

        public double myPow(double x, int _n) {
            long n=_n;
            if(_n<0)  {
                n=-n;
            }
            double ans = mul(x,n);
            return _n<0?1/ans:ans;
        }
        public double mul(double x,long n){
            if(n==0) return 1;
            if(n==1) return x;
            double y =mul(x,n/2);
            return n%2==0?y*y:y*y*x;
        }

}
