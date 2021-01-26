package DFS;

import javafx.util.Pair;
import java.util.LinkedList;
import java.util.Queue;
/*
Given an n x n grid containing only values 0 and 1, where 0 represents water and 1 represents land, find a water cell such that its distance to the nearest land cell is maximized, and return the distance. If no land or water exists in the grid, return -1.

The distance used in this problem is the Manhattan distance: the distance between two cells (x0, y0) and (x1, y1) is |x0 - x1| + |y0 - y1|.
 */
public class AsFarAsLandAsPossible1162 {

    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {1,0,1,0},
                {0,0,0,0},
                {1,0,0,0},
                {1,0,0,0}
        };
        maxDistance(arr);
    }

    /**
     * https://leetcode.com/problems/as-far-from-land-as-possible/discuss/568933/100-space-and-time-algorithm
     * m -rows
     * n - cols
     * TC :  o((m *n) * 4) -> o(m*n) + o(m*n) -> o(2mn) -> o(m*n)
     * sc : o(m*n)
     * @param grid
     * @return
     */
    public static int maxDistance(int[][] grid) {

        boolean[][] visited  = new boolean[grid.length][grid[0].length];
        Queue<Pair<Integer,Integer>> queue = new LinkedList<>();
        int[][] dirs = {{0,1},{1,0},{-1,0},{0,-1}};
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 1 && !visited[i][j]){
                   queue.add(new Pair<>(i,j)); // add 1s
                    visited[i][j] = true;
                   for(int[] dir : dirs){ // add all sorroundings
                       int nr = i + dir[0];
                       int nc = j + dir[1];
                       if(nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length && grid[nr][nc] == 0 && !visited[nr][nc]){
                           queue.add(new Pair<>(nr,nc)); // add zeros surrounding to 1s these values are come at level 0
                           visited[nr][nc] = true;
                       }
                   }
                }
            }
        }
        if(queue.isEmpty()){ // no land
            return -1;
        }
        int level = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                Pair<Integer, Integer> pair = queue.remove();
                int row = pair.getKey();
                int col = pair.getValue();
                for(int[] dir :dirs){
                    int nr = row + dir[0];
                    int nc = col + dir[1];
                    if(nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length && !visited[nr][nc]){
                        if(grid[nr][nc] == 0){ // add only water
                            queue.add(new Pair<>(nr,nc));
                            visited[nr][nc] = true;
                        }
                    }
                }
            }
            level++;
        }
        return level;
    }
}
