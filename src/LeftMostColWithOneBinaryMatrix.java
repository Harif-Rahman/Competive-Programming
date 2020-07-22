import java.util.ArrayList;
import java.util.List;

public class LeftMostColWithOneBinaryMatrix {
    public static void main(String[] args) {
        int[][]     arr = new int[][]{
                {1,1,1,1,1},
                {0,0,1,1,1},
                {0,0,0,0,1},
                {0,0,0,0,0}
        };

        BinaryMatrix binaryMatrix = new BinaryMatrix(arr);
        leftMostColumnWithOne(binaryMatrix);
    }
    public static int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> dim = binaryMatrix.dimensions();
        int rowLen = dim.get(0);
        int colLen = dim.get(1);
        int right = colLen;
        for(int i=0;i<rowLen && right != 0;i++){
            int res  = binarySearch(binaryMatrix,0,right-1,i);
            if(res != -1){
                right = res;
            }
        }
        return right == colLen ? -1 : right;
    }
    private static int binarySearch(BinaryMatrix binaryMatrix,int left,int right,int row){
        while(left < right){
            int mid = left + (right - left)/2;
            if(binaryMatrix.get(row,mid) == 1){
                right = mid;
            }else{
                left = mid+1;
            }
        }
        return binaryMatrix.get(row,right) == 1 ? right : -1;
    }

    static class BinaryMatrix implements BinaryMatrixInter{
        int[][] arr;
        public BinaryMatrix(int[][] arr) {
            //[[],[0,0,0,1,1],[0,0,1,1,1],[0,0,0,0,1],[0,0,0,0,0]]
            this.arr = arr;
        }

        @Override
        public int get(int row, int col) {
            return arr[row][col];
        }

        @Override
        public List<Integer> dimensions() {
            List<Integer> ls = new ArrayList<>(2);
            ls.add(arr.length);
            ls.add(arr[0].length);
            return ls;
        }
    }

    public interface BinaryMatrixInter{
        public int get(int row, int col);
        public List<Integer> dimensions() ;
    }
}
