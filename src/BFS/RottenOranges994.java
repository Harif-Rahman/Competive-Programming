package BFS;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges994 {
    /*
    In a given grid, each cell can have one of three values:

the value 0 representing an empty cell;
the value 1 representing a fresh orange;
the value 2 representing a rotten orange.
Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange.  If this is impossible, return -1 instead.



Example 1:



Input: [[2,1,1],[1,1,0],[0,1,1]]
Output: 4
Example 2:

Input: [[2,1,1],[0,1,1],[1,0,1]]
Output: -1
Explanation:  The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
Example 3:

Input: [[0,2]]
Output: 0
Explanation:  Since there are already no fresh oranges at minute 0, the answer is just 0.
     */
    public static void main(String[] args) {

    }
    public int orangesRotting(int[][] grids) {
        if(grids == null || grids.length == 0) return 0;
        int rowLen = grids.length;
        int colLen = grids[0].length;
        boolean[][] visited = new boolean[rowLen][colLen];
        int countFresh = 0;
        Queue<int[]> queue = new LinkedList<>();
        for(int i=0;i<grids.length;i++){
            for(int j=0;j<grids[0].length;j++){
                if(grids[i][j] == 2){
                    //rotten
                    visited[i][j] = true;
                    queue.add(new int[]{i,j});
                }
                if(grids[i][j] == 1){
                    countFresh++; //count fresh orange
                }
            }
        }
        if(countFresh == 0){
            // if there is no fresh orange return 0
            return 0;
        }

        int[][] dirs = {{-1,0},{0,-1},{1,0},{0,1}}; // four directions
        int level = -1;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                int[] cell = queue.remove();
                for(int[] dir : dirs){
                    int row = cell[0]+dir[0];
                    int col = cell[1]+dir[1];
                    if(row >= 0 && row < rowLen && col >= 0 && col < colLen){
                        if(grids[row][col] == 1 && !visited[row][col]){
                            grids[row][col] = 2;
                            countFresh--;
                            visited[row][col] = true;
                            queue.add(new int[]{row,col});
                        }
                    }
                }
            }
            level++;
        }
        return countFresh == 0  ? level : -1;
    }
}
