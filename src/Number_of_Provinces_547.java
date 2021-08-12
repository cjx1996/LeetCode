import org.junit.Test;

/**
 * @ClassName Number_of_Provinces_547
 * @Description
 * @Author cjx
 * @Date 2021/7/21 17:49
 * @Version 1.0
 */
public class Number_of_Provinces_547 {
    @Test
    public void test(){
        int[][] isConnected = new int[][]{
                {1,1,1,1},
                {1,1,0,0},
                {1,0,1,0},
                {1,0,0,1}
        };
        System.out.println(findCircleNum(isConnected));
    }
    public int findCircleNum(int[][] isConnected) {
        int provinces = isConnected.length;
        int[] parent = new int[provinces];
        for (int i = 0; i < provinces; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < provinces; i++) {
            for (int j = i + 1; j < provinces; j++) {
                if (isConnected[i][j] == 1) {
                    union(parent, i, j);
                }
            }
        }
        int circles = 0;
        for (int i = 0; i < provinces; i++) {
            if (parent[i] == i) {
                circles++;
            }
        }
        return circles;
    }

    public void union(int[] parent, int index1, int index2) {
        parent[find(parent, index1)] = find(parent, index2);
    }

    public int find(int[] parent, int index) {
        if (parent[index] != index) {
            parent[index] = find(parent, parent[index]);
        }
        return parent[index];
    }


    public int findCircleNum1(int[][] isConnected){
        int ans =0;
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
                if(isConnected[i][i]==1){
                    dfs(isConnected,i,visited);
                    ans++;
            }
        }
        return ans;
    }
    void dfs(int[][] isConnected,int i,boolean[] visited){
        isConnected[i][i]=0;
        visited[i] = true;
        int n = isConnected.length;
        for (int k = 0; k < n; k++) {
            if(isConnected[i][k]==1&&!visited[k]){
                isConnected[i][k]=0;
                dfs(isConnected,k,visited);
            }
        }
    }
}
