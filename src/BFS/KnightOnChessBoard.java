package BFS;

import java.util.LinkedList;
import java.util.Queue;

public class KnightOnChessBoard {
    public static void main(String[] args) {
        System.out.println(knight(2, 20, 1, 18, 1, 5));
    }
    public static int knight(int A, int B, int C, int D, int E, int F) {
        boolean[][]  visited = new boolean[A+1][B+1];
        Queue<int[]> queue = new LinkedList<>();
        int[][] dirs = {{-2,-1},{-2,1},{1,2},{-1,2},{2,1},{2,-1},{-1,-2},{1,-2}};
        queue.add(new int[]{C,D});
        int level = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                int[] arr = queue.remove();
                System.out.println("row -->"+arr[0] + "col-->"+arr[1]);
                visited[arr[0]][arr[1]] = true;
                if(arr[0] == E && arr[1] == F){
                    return level;
                }
                for(int[] dir : dirs){
                    int r = arr[0]+dir[0];
                    int c = arr[1]+dir[1];
                    //note
                    if(r > 0 && r <= A && c > 0 && c <= B){
                        if(!visited[r][c]){
                            queue.add(new int[]{r,c});
                        }
                    }
                }
            }
            level++;
        }
        return -1;
    }
}
