package math;

public class MaximalSquare221 {
    public static void main(String[] args) {
        char[][] arr = new char[][]{
                {'1','0'}
        };
        maximalSquare(arr);
    }
    public static int maximalSquare(char[][] matrix) {

        int max = 0;
        for(int i=0;i<matrix.length;i++){
            max = Math.max(max,matrix[i][0]- '0');
        }
        for(int j=0;j<matrix[0].length;j++){
            max = Math.max(max,matrix[0][j] - '0') ;
        }
        for(int i=1;i<matrix.length;i++){
            for(int j=1;j<matrix[0].length;j++){
                int min = Integer.MAX_VALUE;
                // top
                min = Math.min(min,matrix[i-1][j] - '0');
                // left
                min = Math.min(min,matrix[i][j-1] - '0');
                // diagonal
                min = Math.min(min,matrix[i-1][j-1] - '0');
                matrix[i][j] = (char)((min + 1) +'0');
                max = Math.max(max,min+1);
            }
        }
        return max;
    }
}
