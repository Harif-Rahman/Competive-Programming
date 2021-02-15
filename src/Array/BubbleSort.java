package Array;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {5,2,3,1};
        bubbleSort(arr);
        System.out.println(arr);
    }
    private static void bubbleSort(int[] arr){
        int n = arr.length;
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++){
                if (arr[j] > arr[j+1])
                {
                    // swap temp and arr[i]
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }

            }
    }
}
