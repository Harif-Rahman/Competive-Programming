import java.util.ArrayList;
import java.util.List;

public class DiagonalTraverse {
    /*
    Given a matrix of M x N elements (M rows, N columns), return all elements of the matrix in diagonal order as shown in the below image.



Example:

Input:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]

Output:  [1,2,4,7,5,3,6,8,9]
     */
    public static void main(String[] args) {
        System.out.println(sum());

    }
    private static long sum() {

        long sum = 0L;

        for (int i = 0; i < Integer.MAX_VALUE; i++)
            sum += i;



        return sum;

    }
    private static int[] diagonalTravers(int[][] arr){

        if(arr == null || arr.length == 0){
            return new int[]{};
        }
        int row = 0;
        int col = 0;
        boolean goingDown = false;
        List<Integer> res = new ArrayList<>();
        while (true){
            // we reached the last cell
            res.add(arr[row][col]);
            if(row == arr.length-1 && col == arr[0].length-1){
                break;
            }
            if(goingDown){
                // if we are going down also we are at the row boundary
                if(row == arr.length-1 && col == 0){
                    col++;
                    goingDown = false;
                }else{
                    if(row == arr.length-1){
                        col++;//then increase col by 1
                        goingDown = false;
                    }else{
                        if(col == 0){
                            // increase row by 1
                            row++;
                            goingDown = false;
                        }else{
                            // if not then decrase both row and col
                            row++;
                            col--;
                        }
                    }
                }
            }else{
                // we are going up
                // if we are at the first row edge
                if(row == 0 && col == arr[0].length-1){
                    row++;
                    goingDown = true;
                }else{
                    if(row == 0){
                        col++;
                        goingDown = true;
                    }else{
                        if(col == arr[0].length -1){
                            row++;
                            goingDown = true;
                        }else{
                            row--;
                            col++;
                        }
                    }
                }
            }
        }
        int[] resArr = new int[res.size()];
        for(int i=0;i<res.size();i++){
            resArr[i] = res.get(i);
        }
        return resArr;
    }
}
