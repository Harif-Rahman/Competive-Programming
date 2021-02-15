package BFS;

import javafx.util.Pair;

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

    /** WORKING
     * TC : n = grid row length m - grid col length
     * tc : (m*n + m *n)
     *
     * @param grid
     * @return
     */
    public int orangesRotting(int[][] grid) {
        int freshOranges = 0;
        Queue<Pair<Integer,Integer>> queue = new LinkedList<>();

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 2){
                    queue.add(new Pair<>(i,j));
                }else{
                    if(grid[i][j] == 1){
                        freshOranges++;
                    }
                }
            }
        }


        if(freshOranges == 0){
            return 0;
        }
        int level = 0;
        int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                Pair<Integer,Integer> pop = queue.remove();
                int row = pop.getKey();
                int col = pop.getValue();

                for(int[] dir : dirs){
                    int nr = row + dir[0];
                    int nc = col + dir[1];
                    if(nr >= 0 && nc >= 0 && nr < grid.length && nc < grid[0].length){
                        // if orange is fresh then make it rotten
                        if(grid[nr][nc] == 1){
                            grid[nr][nc] = 2;
                            freshOranges--;
                            queue.add(new Pair<>(nr,nc));
                        }
                    }
                }
            }
            level++;
        }
        return freshOranges == 0 ? level-1 : -1;
    }
}
