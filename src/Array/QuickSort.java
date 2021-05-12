package Array;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {3,1,2,4};
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

/*    *//**
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
            quickSort(arr,partition+1,r);
        }
    }


    private static int partition(int[] arr,int l,int pivotInd){
        int i=l;
        for(int j=l;j<pivotInd;j++){
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

    public  int[] sortArray(int[] nums) {
        quickSort(nums,0,nums.length-1);
        return nums;
    }


}
