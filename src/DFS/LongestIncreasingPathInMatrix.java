package DFS;

public class LongestIncreasingPathInMatrix {
    public static final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static void main(String[] args) {
        int[][] matrix ={
                {1}
        };
        longestIncreasingPath(matrix);
    }

    public static int longestIncreasingPath(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        int maxPath = 0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                maxPath = Math.max(maxPath,dfs(matrix,dp,i,j,Integer.MAX_VALUE));
            }
        }
        return maxPath;
    }
    private static int dfs(int[][] matrix,int[][] dp,int i,int j,int prev){
        // check boundary cases
        if(i < 0 || i >= dp.length || j < 0 || j>= dp[0].length){
            return 0;
        }
        if(prev <= matrix[i][j]){
            return 0;
        }
        if(dp[i][j] > 1){
            return dp[i][j];
        }
        int left = dfs(matrix,dp,i,j-1,matrix[i][j]);
        int right = dfs(matrix,dp,i,j+1,matrix[i][j]);
        int top = dfs(matrix,dp,i-1,j,matrix[i][j]);
        int bottom = dfs(matrix,dp,i+1,j,matrix[i][j]);

        int max = 0;
        max = Math.max(max,left);
        max = Math.max(max,right);
        max = Math.max(max,top);
        max = Math.max(max,bottom);
        dp[i][j] = max + 1;
        return dp[i][j];
    }

}
