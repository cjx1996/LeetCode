package Test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ToStringOfList {
    @Test
    public void test(){
        List<Character> list=new ArrayList<>();
        list.add('a');
        list.add('b');
        list.add('c');
        list.add('d');
        list.add('e');
        list.add('f');
        System.out.println(String.valueOf(list));
    }
}
