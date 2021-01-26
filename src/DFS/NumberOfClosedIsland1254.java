package DFS;

public class NumberOfClosedIsland1254 {


    /**
     *  m - row length n - col length
     * tc : o(m*n)
     * sc o(max land length)
     *
     *
     * intuition
     *
     * if we meet boundary then its not closed island then return true
     * visit only land not water
     * @param grid
     * @return
     */
    public int closedIsland(int[][] grid) {
        int closedIsland = 0;
        if(grid == null || grid.length == 0){
            return 0;
        }
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 0 && !dfs(grid,i,j)){
                    closedIsland++;
                }
            }
        }
        return closedIsland;
    }

    private boolean dfs(int[][] grid,int row,int col){
        // no need for arr length case

        if(grid[row][col] != 0){ // allow only land
            //alredy visited
            return false;
        }
        if(row == 0 || row == grid.length-1 || col == 0 || col == grid[0].length-1){
            return true; // reached boundary then its not closed island
        }
        grid[row][col] = -1; // mark visited

        boolean right = dfs(grid,row,col+1);
        boolean left =  dfs(grid,row,col-1);
        boolean top = dfs(grid,row+1,col);
        boolean bottom = dfs(grid,row-1,col);
        return right || left || top || bottom;
    }
}
