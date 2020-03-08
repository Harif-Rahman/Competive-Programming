import java.util.Arrays;
import java.util.Iterator;

public class Flatten2DVector {
    public static void main(String[] args) {
        int[][] arr = {
                {1,2},
                {4,5,6},
                {7}
        };
        Array2DIterator array2DIterator = new Array2DIterator(arr);
        while(array2DIterator.hasNext()){
            System.out.println(array2DIterator.next());
        }

    }
    private static class Array2DIterator implements Iterator<Integer>{
        private int[][] arr;
        private int i=0;
        private Iterator<Integer> iterator;
        public Array2DIterator(int[][] arr) {
            this.arr = arr;
            if(i < arr.length){
                 iterator = Arrays.stream(arr[i]).iterator();
            }
        }

        @Override
        public boolean hasNext() {
            return iterator != null && iterator.hasNext();
        }

        @Override
        public Integer next() {
            int temp = iterator.next();
            if(!iterator.hasNext() && i + 1 < arr.length){
                iterator = Arrays.stream(arr[++i]).iterator();
            }
            return temp;
        }
    }
}
