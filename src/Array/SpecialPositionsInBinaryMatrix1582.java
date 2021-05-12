package Array;

public class SpecialPositionsInBinaryMatrix1582 {
    public static void main(String[] args) {
        int[][] arr = {
                {0, 0, 1, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 1, 0, 0}

        };
        /*
        3 rd row 1 st col


         */
        numSpecial(arr);
    }

    /**
     * WORKING
     * TC : O(M*N)
     * SC : (M + N)
     * @param mat
     * @return
     */
    public static int numSpecial(int[][] mat) {
        int[] rowSum = new int[mat.length];
        int[] colSum = new int[mat[0].length];

        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                rowSum[i] += mat[i][j];
                colSum[j] += mat[i][j];
            }
        }
        //{1,1,1} - rsum
        //{2,0,1,0}
        int count = 0;
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j] == 1 && rowSum[i] == 1 && colSum[j] == 1){
                    count++;
                }
            }
        }
        return count;
    }
}
