package DP;

public class MaximalSquare221 {
    public static void main(String[] args) {
/*        char[][] arr = {
                {'1', '1', '1', '1', '0'}, {'1', '1', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}
        };*/
        char[][] arr = {{'1'}};
        maximalSquare1(arr);

    }

    /**
     * TC : O(N*N)
     * SC : O(N)
     * @param a
     * @return
     */
    public static int maximalSquare1(char[][] a) {
        if(a.length == 0) return 0;
        int m = a.length, n = a[0].length, result = 0;
        int[][] b = new int[m+1][n+1];
        for (int i = 1 ; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if(a[i-1][j-1] == '1') {
                    b[i][j] = Math.min(Math.min(b[i][j-1] , b[i-1][j-1]), b[i-1][j]) + 1;
                    result = Math.max(b[i][j], result); // update result
                }
            }
        }
        return result*result;
    }


}