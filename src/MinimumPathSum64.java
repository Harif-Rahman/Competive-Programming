public class MinimumPathSum64 {
    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {1,3,1},
                {1,5,1},
                {4,2,1}
        };
        minPathSum(grid);
    }

    /**
     * WORKING
     * @param grid
     * @return
     */
    public static int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        // fill row
        int sum = 0;
        for(int i=0;i<dp[0].length;i++){ //fill first column
            sum += grid[0][i];
            dp[0][i] = sum ;
        }
        sum = 0;
        for(int i=0;i<dp.length;i++){ // fill first row
            sum += grid[i][0];
            dp[i][0] = sum;
        }

        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                int top = dp[i-1][j];
                int left = dp[i][j-1];
                dp[i][j] = Math.min(top+grid[i][j],left+grid[i][j]);
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }
}
