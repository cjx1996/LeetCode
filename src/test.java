import org.junit.Test;

/**
 * @ClassName test
 * @Description TODO
 * @Author cjx
 * @Date 2021/7/14 17:24
 * @Version 1.0
 */
public class test {
    @Test
    /**
     * 对于数组，对于具体数据的访问与存储可以将其看做对象来考虑
     */
    public void test1(){
        int[] nums1 = new int[]{1,2,4};
        int[] nums2 = nums1;
        nums1[0] = 8;
        for(int num:nums2){
            System.out.println(num);
        }
    }
}
