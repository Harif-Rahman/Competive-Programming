package DP;

public class UniquePath63 {
    public static void main(String[] args) {
        int[][] arr = {
                {0,0,1},
                {0,0,1},
                {0,0,0}
        };
        uniquePathsWithObstacles(arr);
    }
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if(m == 0 || n == 0){
            return 0;
        }
        if(obstacleGrid[0][0] == 1){
            return 0;
        }
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!(i == 0 && j == 0)){
                    if(obstacleGrid[i][j] == 1){
                        obstacleGrid[i][j] = -1;
                        continue;
                    }
                    int res = 0;
                    if(j-1 >=0 && obstacleGrid[i][j-1] != -1){
                        res += dp[i][j-1]; //left
                    }
                    if(i-1 >= 0 && obstacleGrid[i-1][j] != -1){
                        res += dp[i-1][j]; //top
                    }
                    dp[i][j] = res;
                }
            }
        }
        return dp[m-1][n-1];
    }
    public int uniquePathsWithObstacles1(int[][] obstacleGrid) {
        int width = obstacleGrid[0].length;
        int[] dp = new int[width];
        dp[0] = 1;
        for (int[] row : obstacleGrid) {
            for (int j = 0; j < width; j++) {
                if (row[j] == 1)
                    dp[j] = 0;
                else if (j > 0)
                    dp[j] += dp[j - 1];
            }
        }
        return dp[width - 1];
    }
}
