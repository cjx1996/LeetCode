package Test;

import org.junit.Test;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName EntryKeyValues
 * @Description
 * @Author cjx
 * @Date 2022/9/3 19:46
 * @Version 1.0
 */
public class EntryKeyValues {
    public static void main(String[] args) {

    }
    @Test
    public void test(){
        String pathname="C:/Users/11212/Downloads/1.txt";
        try {
            byte[] bts= readFromByteFile(pathname);
            for (byte bt : bts) {
                System.out.print(bt+" ");
            }
            System.out.println();
            String str="a b c\r\nd e f";
            for (int i = 0; i < str.length(); i++) {
                byte cur=(byte)str.charAt(i);
                System.out.print(cur+" ");
            }
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }
    public byte[] readFromByteFile(String pathname) throws IOException {

        File filename = new File(pathname);
        BufferedInputStream in = new BufferedInputStream(new FileInputStream(filename));
        ByteArrayOutputStream out = new ByteArrayOutputStream(1024);
        byte[] temp = new byte[1024];
        int size = 0;
        while((size = in.read(temp)) != -1){
            out.write(temp, 0, size);
        }
        in.close();
        byte[] content = out.toByteArray();
        return content;
    }


}
