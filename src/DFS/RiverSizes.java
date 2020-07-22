package DFS;

import java.util.ArrayList;
import java.util.List;

public class RiverSizes {
    public static void main(String[] args) {
        int[][] river = {
                {1, 0, 0, 1, 0},
                {1, 0, 1, 0, 0},
                {0, 0, 1, 0, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 0}
        };
        riverSizes(river);
    }
    public static List<Integer> riverSizes(int[][] matrix) {
        // Write your code here.
        List<Integer> ls = new ArrayList<>();
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j] == 1){
                    int[] path = {0};
                    dfs(matrix,i,j,path);
                    if(path[0] != 0){
                        ls.add(path[0]);
                    }
                }
            }
        }
        return ls;
    }
    private static void dfs(int[][] matrix,int r,int c,int[] depth){
        if(r < 0 || r >= matrix.length || c < 0 || c >= matrix[0].length){
            return ;
        }
        if(matrix[r][c] == 0 || matrix[r][c] == 2){
            return; // return if it is land or already visited
        }
        System.out.println("depth-->"+depth[0]);
        depth[0]++;
        matrix[r][c] = 2;
        dfs(matrix,r+1,c,depth);//down
        dfs(matrix,r,c+1,depth); //right
        dfs(matrix,r-1,c,depth);//up
        dfs(matrix,r,c-1,depth); //left
    }
}
