package Array;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {5,2,3,1};
        insertionSort(arr);
        System.out.println(arr);
    }

    /**
     * WORKING
     * FASTER THAN BUBBLE AND selection sort
     *
     * -sorted
     * -- sorted
     * --- sorted
     * ---- sorted
     * ----- sorted
     * INTUITION
     * TC : O(N^2)
     *
     *
     * @param arr
     */
    private static void insertionSort(int[] arr){
        for(int i=1;i<arr.length;i++){
            int j=i;
            while (j > 0 && arr[j-1] > arr[j]){
                int temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;
                j--;
            }
        }
    }
}
