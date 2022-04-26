package All_Problems;


import java.util.LinkedList;
import java.util.Queue;


/**
 * @ClassName Populating_Next_Right_Pointers_in_Each_Node_II_117
 * @Description
 * @Author cjx
 * @Date 2021/7/22 18:05
 * @Version 1.0
 */
public class Populating_Next_Right_Pointers_in_Each_Node_II_117 {

    Node last = null,nextStart = null;
    public Node connect(Node root){
        if(root == null) return null;
        //start开始于root，表示程序从root结点出开始运行
        Node start = root;
        //每一次在while处进行循环，代表开始新的一层的链表创建
        while(start!=null){
            last = null;
            nextStart = null;
            //每一次for循环开始前都应该初始化last和nextStart
            for(Node p = start;p!=null;p=p.next){
                if(p.left!=null) next(p.left);
                if(p.right!=null) next(p.right);
            }
            //一层链表创建完成，对start赋值，用于判断是否开始新的一次循环
            start = nextStart;
        }
        return root;
    }
    void next(Node node){
        if(last!=null){
            last.next = node;
        }
        if(nextStart==null){
            nextStart = node;
        }
        last = node;
    }
    public Node connect1(Node root) {
        Queue<Node> queue = new LinkedList<>();
        if (root == null) return null;
        queue.add(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                Node item =  queue.poll();
                if(i!=n-1) item.next = queue.peek();
                if(item.left!=null){
                    queue.add(item.left);
                }
                if(item.right!=null){
                    queue.add(item.right);
                }
            }
        }
        return root;
    }





}
