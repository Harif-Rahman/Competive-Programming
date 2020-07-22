package DFS;

public class LongestIncreasingPathInMatrix {
    public static void main(String[] args) {
        int[][] arr = {
                {9,9,4},
                {6,6,8},
                {2,1,1}
        };
        System.out.println(longestIncreasingPath(arr));
    }
    public static int longestIncreasingPath(int[][] matrix) {
        int[][] cache = new int[matrix.length][matrix[0].length];
        int maxPath = 0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                int path = dfs(matrix,i,j,Integer.MAX_VALUE,cache);
                maxPath = Math.max(path,maxPath);
            }
        }
        return maxPath;
    }
    private static int dfs(int[][] matrix,int r,int c,int prev,int[][] cache){

        if(r < 0 || c < 0 || r >= matrix.length || c >= matrix[0].length){
            return 0;
        }
        if(prev <= matrix[r][c]){ //checking for decreasing
            return 0;
        }
        if(cache[r][c] > 0){ //memoization
            return cache[r][c];
        }
        int maxPath = 0;
        maxPath = Math.max(maxPath,dfs(matrix,r-1,c,matrix[r][c],cache));
        maxPath = Math.max(maxPath,dfs(matrix,r+1,c,matrix[r][c],cache));
        maxPath = Math.max(maxPath,dfs(matrix,r,c-1,matrix[r][c],cache));
        maxPath = Math.max(maxPath,dfs(matrix,r,c+1,matrix[r][c],cache));
        cache[r][c] = maxPath + 1;
        return cache[r][c];
    }

}
