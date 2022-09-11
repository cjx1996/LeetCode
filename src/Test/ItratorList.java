package Test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName ItratorList
 * @Description
 * @Author cjx
 * @Date 2022/9/5 15:42
 * @Version 1.0
 */
public class ItratorList {
    /**
     *
     */
    @Test
    public void test(){
        List<String> list=new ArrayList<>();
        list.add("null");
        list.add("ths");
        list.add("null");
        System.out.println(filter(list));
    }

    /**
     * 报错ConcurrentModificationException。因为在for循环中进行了remove()操作，内部发生错误。
     * @param list
     * @return
     */
    public String filter(List<String> list){
        for (String str : list) {
            if("null".equals(str)) list.remove(str);
        }
        return (list.get(0));
    }

}
