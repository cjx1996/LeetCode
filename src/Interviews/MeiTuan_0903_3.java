package Interviews;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @ClassName MeiTuan_0903_3
 * @Description
 * @Author cjx
 * @Date 2022/9/3 10:36
 * @Version 1.0
 */
class Node{
    int val;
    char c;
    ArrayList<Node> children=new ArrayList<>();
}
public class MeiTuan_0903_3 {
    public static void main(String[] args) {
        Scanner scan =new Scanner(System.in);
        int n = scan.nextInt();
        ans=new int[n+1];
        Node[] map=new Node[n+1];
        for (int i = 0; i <= n; i++) {
            map[i]=new Node();
            map[i].val=i;
        }
        for (int i = 1; i <= n - 1; i++) {
            int cur=scan.nextInt();
            map[cur].children.add(map[i+1]);
        }
        scan.nextLine();
        scan.nextLine();
        String str=scan.nextLine();
        System.out.println("str="+str);
        for (int i = 0; i < n; i++) {
            map[i+1].c=str.charAt(i);
        }
        for (int i = 0; i < n; i++) {
           Node node= map[i+1];
        }
        dfs(map[1]);
        for (int i = 1; i < n; i++) {
            System.out.print(Integer.bitCount(ans[i])+" ");
        }
        System.out.println(Integer.bitCount(ans[n]));
    }
    static int[] ans;
    static void dfs(Node node){
        ArrayList<Node> children=node.children;
        int cur=0;
        for (Node child : children) {
            if(ans[child.val]==0){
                dfs(child);
            }
            cur|=ans[child.val];
        }
        cur|=1<<(node.c-'A');
        ans[node.val]=cur;
    }
}
