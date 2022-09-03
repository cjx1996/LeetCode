package Interviews;

/**
 * @ClassName ShowMeBug
 * @Description
 * @Author cjx
 * @Date 2022/9/3 20:39
 * @Version 1.0
 */
public class ShowMeBug {
    public final int[][] arr;


    public ShowMeBug(int[][] arr) {
        this.arr = arr;
    }

    public void updateNextState(int[][] arr){
        int M=arr.length;
        int N= arr[0].length;
        int[][] tem=new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                tem[i][j]=getNextVal(arr,i, j);
            }
        }
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j]=tem[i][j];
            }
        }
    }
    public int getNextVal(int[][] arr,int i,int j){
        int nextVal=0;
        int res=countLivingNeighbors(arr,i,j);
        nextVal=arr[i][j];
        if(nextVal==1){
            if(res<2||res>3) nextVal=0;
        }else {
            if(res==3) nextVal=1;
        }
        return nextVal;
    }
    private int countLivingNeighbors(int[][] arr,int i,int j){
        int count=0;

        return count;
    }
}
