package Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName ListParamTest
 * @Description
 * @Author cjx
 * @Date 2022/9/18 15:50
 * @Version 1.0
 */
public class ListParamTest {
    //List.sublist()返回的是原list的部分视图，视图，视图，无论改变哪一个，另一个也会跟着改变
    static void resetList(List<Integer> dataList) {
        dataList.subList(2, 4).set(0, 40);
        dataList = new ArrayList<Integer>(dataList);
        dataList.add(50);
    }

    static void setOne(List<Integer> dataList) {
        dataList.set(3, 100);
    }

    public static void main(String[] args) {
        List<Integer> dataList = new ArrayList<Integer>(Arrays.asList(10, 20, 30, null));
        resetList(dataList);
        setOne(dataList);
        int sum=0;
        for (Integer v : dataList) {
            sum+=v;
        }
        System.out.println(sum);
    }

}
