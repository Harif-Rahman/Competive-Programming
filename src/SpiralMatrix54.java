import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix54 {
    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {1,  2, 3, 4},
                {5,  6, 7, 8},
                {9, 10,11,12}
        };
        spiralOrder(arr);

    }
    public static List<Integer> spiralOrder(int[][] matrix) {
        if(matrix == null || matrix.length == 0){
            return new ArrayList<>();
        }

        int left = 0;
        int right = matrix[0].length-1;
        int top = 0;
        int bottom = matrix.length-1;
        int n = matrix.length*matrix[0].length;
        List<Integer> ls = new ArrayList<>(n);
        while(top <= bottom && left <= right){
            // left to right
            for(int i=left;i<=right &&ls.size() != n;i++){
                ls.add(matrix[top][i]);
            }
            // top to bottom
            for(int i=top+1;i<=bottom && ls.size() != n;i++){
                ls.add(matrix[i][right]);
            }
            // right to left
            for(int i=right-1;i>=left && ls.size() != n;i--){
                ls.add(matrix[bottom][i]);
            }
            // bottom to top
            for(int i=bottom-1;i>top && ls.size() != n;i--){
                ls.add(matrix[i][top]);
            }
            top++;
            left++;
            right--;
            bottom--;
        }
        return ls;
    }
}
