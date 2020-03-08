import java.util.Arrays;

public class LineThickness {
    public static void main(String[] args) {
        int[][] arr = {{3,7},{6,8},{1,7},{5,9}};
        int[] curr = arr[0];
        for(int i=0;i<arr.length;i++){
            if(curr[1] >= arr[i][0]){
                curr[0] = Math.max(arr[i][0],curr[0]);
                curr[1] = Math.min(arr[i][1],curr[1]);
            }
        }
        System.out.println(Arrays.toString(curr));
    }
}
