package Array;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {5,2,3,1};
        selectionSort(arr);
        System.out.println(arr);
    }

    /**
     * WORKING
     *
     *
     * INTUTION
     * FIND THE MIN ELEMENT
     * THEM PUT THE MINIMUM ELEMENT IN FIRST
     * THEN REDUCE YOUR WINDOW
     * GOES ON.......
     * TC : O(N^2)
     * @param arr
     */
    private static void selectionSort(int[] arr){

       for(int i=0;i<arr.length;i++){
           int minInd = i;
           for(int j=i+1;j<arr.length;j++){
               if(arr[minInd] > arr[j]){
                   minInd = j;
               }
           }
           int temp = arr[minInd];
           arr[minInd] = arr[i];
           arr[i] = temp;
       }
    }
}
