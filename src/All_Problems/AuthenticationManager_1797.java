package All_Problems;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName AuthenticationManager_1797
 * @Description 哈希表+双向链表
 * @Author cjx
 * @Date 2023/2/9 18:12
 * @Version 1.0
 */
public class AuthenticationManager_1797 {
    Node tail;
    Node head;
    Map<String,Node> map;
    int liveTime;
    public AuthenticationManager_1797(int timeToLive) {
        liveTime=timeToLive;
         tail=new Node(-1);
        head=new Node(-1);
        head.next=tail;
        tail.pre=head;
        map=new HashMap<>();
    }

    public void generate(String tokenId, int currentTime) {
        Node cur=new Node(tokenId,currentTime+liveTime);
        Node last=tail.pre;
        last.next=cur;
        tail.pre=cur;
        cur.next=tail;
        cur.pre=last;
        map.put(tokenId,cur);
    }

    public void renew(String tokenId, int currentTime) {
        if(map.containsKey(tokenId)&&map.get(tokenId).expire>currentTime){
            Node cur=map.get(tokenId);
            cur.expire=currentTime+liveTime;
            Node pre=cur.pre;
            Node next=cur.next;
            pre.next=next;
            next.pre=pre;
            Node last=tail.pre;
            last.next=cur;
            tail.pre=cur;
            cur.next=tail;
            cur.pre=last;
//            map.put(tokenId,cur); 多次一举，map中变量指向的就是cur，没必要重写put
        }
    }

    public int countUnexpiredTokens(int currentTime) {
        Node cur=head.next;
        while(cur.expire<=currentTime&&cur!=tail){
            map.remove(cur.code);
            cur=cur.next;
        }
        head.next=cur;
        cur.pre=head;
        return map.size();
    }
    private class Node{
        Node pre;
        Node next;
        String code;
        int expire;
        public Node(int _expire){
            expire=_expire;
        }
        public Node(String _code,int _expire){
            code=_code;
            expire=_expire;
        }
        public Node(String _code,int _expire,Node _pre,Node _next){
            code=_code;
            expire=_expire;
            pre=_pre;
            next=_next;
        }
    }
}

