package Test;

/**
 * @ClassName Modify_attribue_in_Generate_Method
 * @Description
 * @Author cjx
 * @Date 2022/9/13 20:13
 * @Version 1.0
 */
public class ModifyAttributeInGenerateMethod {
    private int age;

    public ModifyAttributeInGenerateMethod() {
        age += 5;
    }

    public void showAge() {
        System.out.println(age);
    }

    public static void main(String[] args) {
        ModifyAttributeInGenerateMethod p = new ModifyAttributeInGenerateMethod();
        p.showAge();
    }
}
