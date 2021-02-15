package Array;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {3,2,1,5,6,4};
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * intuition behind is
     * make sure the element on the left side of pivot should be less
     * make sure the element on the right side of pivot should be high
     * @param arr
     * @param l
     * @param r
     */
    private static void quickSort(int[] arr,int l,int r){
        if(l < r){
            int partition = partition(arr,l,r);
            quickSort(arr,l,partition-1);
            quickSort(arr,partition,r);
        }
    }

    private static int partition(int[] arr,int l,int r){
        int pivotInd = r;// taking last element as pivot
        int i=l;
        for(int j=l;j<r;j++){
            if(arr[j] < arr[pivotInd]){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
            }
        }
        // swap pivot and i
        int temp = arr[i];
        arr[i] = arr[pivotInd];
        arr[pivotInd] = temp;
        return i;
    }


}
