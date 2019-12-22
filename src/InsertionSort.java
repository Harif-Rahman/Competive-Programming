import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {4, 1, 2, 3, 5};
        System.out.println(Arrays.toString(insertionSort(arr)));
    }

    private static int[] insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = i - 1;
            while (j > 0) {
                if (arr[j] < arr[j - 1]) {
                    arr[j - 1] ^= arr[j];
                    arr[j] ^= arr[j - 1];
                    arr[j - 1] ^= arr[j];
                }
                j--;
            }
        }
        return arr;
    }
}
