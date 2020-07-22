public class ScoresAfterFlippingMatrix861 {
    public static void main(String[] args) {
        int[][] arr = {
                {0,0,1,1},
                {1,0,1,0},
                {1,1,0,0}
        };
        matrixScore(arr);
    }
    public static int matrixScore(int[][] A) {
        flipRows(A);
        flipColumn(A);
        int sum =0;
        for(int i=0;i<A.length;i++){
            int temp = 0;
            for(int j=A[0].length-1;j>-1;j--){
                // use left shift
                temp += A[i][j] * (1 << A[0].length - 1 - j);
            }
            sum += temp;
        }
        return sum;
    }

    /**
     * lsb should alway begin with 1 it will increase the value
     * so if first bit is 0 then toggle
     * @param arr
     */
    private static void flipRows(int[][] arr){
        for(int i=0;i<arr.length;i++){
            if(arr[i][0] == 0){
                int j = 0;
                while(j<arr[0].length){
                    arr[i][j] ^= 1;
                    j++;
                }
            }
        }
    }

    /** here position is same so need to woory about
     * if no of ones greater than zeros count then toggle
     * @param arr
     */
    private static void flipColumn(int[][] arr){
        for(int i=0;i<arr[0].length;i++){
            int countOnes = countNoOfOnesInColWise(arr,i);
            int countZeros = arr.length - countOnes;
            if(countOnes < countZeros){
                flipColToOnes(arr,i);
            }
        }
    }
    private static int countNoOfOnesInColWise(int[][] arr,int col){
        int row =0;
        int onesCount =0;
        while(row < arr.length){
            if(arr[row++][col] == 1){
                onesCount++;
            }
        }
        return onesCount;
    }

    private static void flipColToOnes(int[][] arr,int col){
        int row =0;
        while(row < arr.length){
            arr[row][col] ^= 1;
            row++;
        }
    }

}
