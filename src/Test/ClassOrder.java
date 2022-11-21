package Test;

/**
 * @ClassName ClassOrder
 * @Description
 * @Author cjx
 * @Date 2022/9/18 16:01
 * @Version 1.0
 */
public class ClassOrder {
   static int age;
    static{
        age=2;
        System.out.println("静态代码块:"+age);
    }

    public ClassOrder(int age) {
        this.age=age;
        System.out.println("构造函数："+age);
    }

    public static void main(String[] args) {
        ClassOrder p=new ClassOrder(3);
        System.out.println("构造完成后age:"+age);
    }
}
