public class ReshapeMatrix566 {
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3},{4, 5, 6}};
        matrixReshape(arr,3,2);
    }

    public static int[][] matrixReshape(int[][] nums, int r, int c) {
        if(r*c != nums[0].length * nums.length)
            return nums;
        int p=0,q=0;
        int[][] res = new int[r][c];
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums[0].length;j++){
                res[p][q++] = nums[i][j];
                if(q >= res[0].length)
                    q=0;p++;
            }}
        return res;
    }
}
