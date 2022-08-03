package All_Problems;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @ClassName Encode_and_Decode_TinyURL_535
 * @Description
 * @Author cjx
 * @Date 2022/6/29 14:55
 * @Version 1.0
 */
public class Encode_and_Decode_TinyURL_535 {
    @Test
    public void test(){
        Codec codec=new Codec();
        String longUrl = "https://leetcode.com/problems/desigh-tinyurl";
        String shortUrl=codec.encode(longUrl);
        System.out.println(codec.decode(shortUrl));
    }
    private class Codec{

        Map<Integer,String> map=new HashMap<>();
        Random random=new Random();
        public String encode(String longUrl){
            int key= random.nextInt();
            while(map.containsKey(key)){
                key++;
            }
            map.put(key,longUrl);
            return "http://tinyurl.com/"+key;
        }

        public String decode(String shortUrl){
            int index=shortUrl.lastIndexOf('/')+1;
            int key= Integer.valueOf(shortUrl.substring(index));
            return map.get(key);
        }
    }

}
