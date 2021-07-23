import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @ClassName Copy_List_with_Random_Pointer_138
 * @Description TODO
 * @Author cjx
 * @Date 2021/7/22 10:53
 * @Version 1.0
 */
public class Copy_List_with_Random_Pointer_138 {
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        for (Node node = head; node != null; node = node.next.next) {
            Node newNode = new Node(node.val);
            newNode.next = node.next;
            node.next = newNode;
        }

        for (Node node = head; node != null; node = node.next.next) {

            node.next.random = node.random == null ? null : node.random.next;
        }
        Node newHead = head.next;
        for (Node node = head; node != null; node = node.next) {
            Node newNode = node.next;
            node.next = node.next.next;
            if (newNode.next != null)
                newNode.next = newNode.next.next;
        }
        return newHead;
    }

    HashMap<Node, Node> cashedNode = new HashMap<>();

    public Node copyRandomList2(Node head) {
        if (head == null) return null;
        while (!cashedNode.containsKey(head)) {
            Node newNode = new Node(head.val);
            cashedNode.put(head, newNode);
            newNode.next = copyRandomList2(head.next);
            newNode.random = copyRandomList2(head.random);
        }
        return cashedNode.get(head);
    }


    public Node copyRandomList1(Node head) {
        List<Node> nodes = new ArrayList<>();
        while (head != null) {
            nodes.add(head);
            head = head.next;
        }
        int len = nodes.size();

        List<Node> tem_nodes = new ArrayList<>(len);
        //创建新链表表示每个结点
        for (int i = 0; i < len; i++) {
            tem_nodes.add(new Node(nodes.get(i).val));
        }
        //对每个结点的next赋值
        for (int i = 0; i < len - 1; i++) {
            tem_nodes.get(i).next = tem_nodes.get(i + 1);
        }
        //对每个结点的random赋值
        for (int i = 0; i < nodes.size(); i++) {
            Node node = nodes.get(i);
            Node random = node.random;
            tem_nodes.get(i).random = (random == null) ? null : tem_nodes.get(nodes.indexOf(random));
        }
        return len == 0 ? null : tem_nodes.get(0);
    }
    private class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

}

