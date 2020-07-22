public class PathWithMaximumGold1219 {
    /*
    In a gold mine grid of size m * n, each cell in this mine has an integer representing the amount of gold in that cell, 0 if it is empty.

Return the maximum amount of gold you can collect under the conditions:

Every time you are located in a cell you will collect all the gold in that cell.
From your position you can walk one step to the left, right, up or down.
You can't visit the same cell more than once.
Never visit a cell with 0 gold.
You can start and stop collecting gold from any position in the grid that has some gold.


Example 1:

Input: grid = [[0,6,0],[5,8,7],[0,9,0]]
Output: 24
Explanation:
[[0,6,0],
 [5,8,7],
 [0,9,0]]
Path to get the maximum gold, 9 -> 8 -> 7.
Example 2:

Input: grid = [[1,0,7],[2,0,6],[3,4,5],[0,3,0],[9,0,20]]
Output: 28
Explanation:
[[1,0,7],
 [2,0,6],
 [3,4,5],
 [0,3,0],
 [9,0,20]]
Path to get the maximum gold, 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7.
     */
    public static void main(String[] args) {
        int[][] arr = {
                {0,6,0},
                {5,8,7},
                {0,9,0}
        };
        System.out.println(getMaximumGold(arr));

    }

    static int max = 0;

    /**
     * DFS TC : O(R*C^2) AT ONE POSITION I CAN EXPLORE ALL PATHS THAT MEANS IT HAS LENGTH M*N
     * SC : O(R*C) stack space
     * @param grid
     * @return
     */
    public static int getMaximumGold(int[][] grid) {
        int rowLen = grid.length;
        int colLen = grid[0].length;
        for(int i=0;i<rowLen;i++){
            for(int j=0;j<colLen;j++){
                helper(grid,i,j,0);
            }
        }
        return max;
    }

    private static void helper(int[][] grid,int i,int j,int sum){
        int rowLen = grid.length;
        int colLen = grid[0].length;
        if(i >= rowLen || i < 0 || j >= colLen || j < 0 || grid[i][j] == 0){
            return;
        }
        sum += grid[i][j];
        max = Math.max(max,sum);
        int orgValue = grid[i][j];
        grid[i][j] = 0; // mark as visited
        helper(grid,i-1,j,sum); // top
        helper(grid,i+1,j,sum); // down
        helper(grid,i,j-1,sum); // left
        helper(grid,i,j+1,sum); // right
        grid[i][j] = orgValue; // save the original value backtracking
    }
}
