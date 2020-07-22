package DP;
/*
Given a m x n grid. Each cell of the grid represents a street. The street of grid[i][j] can be:
1 which means a street connecting the left cell and the right cell.
2 which means a street connecting the upper cell and the lower cell.
3 which means a street connecting the left cell and the lower cell.
4 which means a street connecting the right cell and the lower cell.
5 which means a street connecting the left cell and the upper cell.
6 which means a street connecting the right cell and the upper cell.


You will initially start at the street of the upper-left cell (0,0). A valid path in the grid is a path which starts from the upper left cell (0,0) and ends at the bottom-right cell (m - 1, n - 1). The path should only follow the streets.

Notice that you are not allowed to change any street.

Return true if there is a valid path in the grid or false otherwise.



Example 1:


Input: grid = [[2,4,3],[6,5,2]]
Output: true
Explanation: As shown you can start at cell (0, 0) and visit all the cells of the grid to reach (m - 1, n - 1).
Example 2:


Input: grid = [[1,2,1],[1,2,1]]
Output: false
Explanation: As shown you the street at cell (0, 0) is not connected with any street of any other cell and you will get stuck at cell (0, 0)
Example 3:

Input: grid = [[1,1,2]]
Output: false
Explanation: You will get stuck at cell (0, 1) and you cannot reach cell (0, 2).
Example 4:

Input: grid = [[1,1,1,1,1,1,3]]
Output: true
Example 5:

Input: grid = [[2],[2],[2],[2],[2],[2],[6]]
Output: true
 */
public class ValidPathInGrid1391 {
    public static void main(String[] args) {

    }
    boolean found = false;
    public boolean hasValidPath(int[][] grid) {
        dfs(grid,0,0,DIR.START);
        return found;
    }
    private void dfs(int[][] grid,int r,int c,DIR dir){
        if(found)
            return ;
        if(r< 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == -1){
            return ;
        }
        switch(dir){
            case TOP:
                if(grid[r][c] == 1 || grid[r][c] == 6 || grid[r][c] == 5){
                    return ;
                }
                break;
            case DOWN:
                if(grid[r][c] == 1 || grid[r][c] == 4 || grid[r][c] == 3){
                    return ;
                }
                break;
            case LEFT:
                if(grid[r][c] == 2 || grid[r][c] == 3 || grid[r][c] == 5){
                    return ;
                }
                break;
            case RIGHT:
                if(grid[r][c] == 2 || grid[r][c] == 4 || grid[r][c] == 6){
                    return ;
                }
                break;
            default:
        }

        if(r == grid.length-1 && c == grid[0].length -1 ){
            // reached destination
            found = true;
            return;
        }

        //System.out.println("dir"+dir+"r---->"+r+"------>"+c);
        int temp = grid[r][c];
        grid[r][c] = -1;
        switch(temp){
            case 1:
                dfs(grid,r,c+1,DIR.RIGHT);
                dfs(grid,r,c-1,DIR.LEFT);
                break;
            case 2:
                dfs(grid,r-1,c,DIR.TOP);
                dfs(grid,r+1,c,DIR.DOWN);
                break;
            case 3:
                dfs(grid,r,c-1,DIR.LEFT);
                dfs(grid,r+1,c,DIR.DOWN);
                break;
            case 4:
                dfs(grid,r+1,c,DIR.DOWN);
                dfs(grid,r,c+1,DIR.RIGHT);
                break;
            case 5:
                dfs(grid,r-1,c,DIR.TOP);
                dfs(grid,r,c-1,DIR.LEFT);
                break;
            case 6:
                dfs(grid,r-1,c,DIR.TOP);
                dfs(grid,r,c+1,DIR.RIGHT);
                break;
        }
        grid[r][c] = temp;
    }
      enum  DIR{
        START,LEFT,RIGHT,TOP,DOWN;
    }

}
