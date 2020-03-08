public class Search2DMatrix74 {
    /*
    74. Search a 2D Matrix
Medium

1215

136

Add to List

Share
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
Example 1:

Input:
matrix = {
  {1,   3,  5,  7},
  {10, 11, 16, 20},
  {23, 30, 34, 50}
}
target = 3
Output: true
Example 2:

Input:
matrix = {
  {1,   3,  5,  7},
  {10, 11, 16, 20},
  {23, 30, 34, 50}
}
target = 13
Output: false
     */
    public static void main(String[] args) {
        int[][] arr = {{1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}};
        System.out.println(searchMatrix(arr, 30));
    }

    private static boolean findElement(int[][] arr,int k,int i,int j){
        if(arr.length == 0 ||  i >= arr.length || j < 0)
            return false;
        if(arr[i][j] == k){
            return true;
        }
        if(arr[i][j] > k){
            return findElement(arr,k,i,j-1);
        }else{
            return findElement(arr,k,i+1,j);
        }
    }

    public static boolean searchMatrix(int[][] matrix, int target) {

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int row = 0;
        int col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] < target) {
                row++;
            } else {
                col--;
            }
        }
        return false;
    }

}
