package sorting;

class PancakeSorting {

    /* Reverses arr[0..i] */
    static void flip(int arr[], int i)
    {
        int temp, start = 0;
        while (start < i)
        {
            temp = arr[start];
            arr[start] = arr[i];
            arr[i] = temp;
            start++;
            i--;
        }
    }

    // Returns index of the
    // maximum element in
    // arr[0..n-1]
    static int findMax(int arr[], int n)
    {
        int mi, i;
        for (mi = 0, i = 0; i < n; ++i)
            if (arr[i] > arr[mi])
                mi = i;
        return mi;
    }

    // The main function that
    // sorts given array using
    // flip operations
    static int pancakeSort(int arr[], int n)
    {
        // Start from the complete
        // array and one by one
        // reduce current size by one
        for (int curr_size = n; curr_size > 1; --curr_size)
        {
            // Find index of the
            // maximum element in
            // arr[0..curr_size-1]
            int mi = findMax(arr, curr_size);

            // Move the maximum element
            // to end of current array
            // if it's not already at
            // the end
            if (mi != curr_size-1)
            {
                // To move at the end,
                // first move maximum
                // number to beginning
                flip(arr, mi);

                // Now move the maximum
                // number to end by
                // reversing current array
                flip(arr, curr_size-1);
            }
        }
        return 0;
    }

    /* Utility function to print array arr[] */
    static void printArray(int arr[], int arr_size)
    {
        for (int i = 0; i < arr_size; i++)
            System.out.print(arr[i] + " ");
        System.out.println("");
    }

    /* Driver function to check for above functions*/
    public static void main (String[] args)
    {
        int arr[] = {13, 10, 20, 11, 12, 6, 7};
        // 23 10 20 11 12 6 7
        // 23 10 20 11 12 6 7
        // 7 6 12 11 20 10 23

        // 20 11 12 6 7 10 23
        // 10 7 6 12 11 20 23

        //12 6 7 10 11 20 23
        // 11 10 7 6 12 20 23

        // 11 10 7 6 12 20 23
        //6 7 10 11 12 20 23

        //6,7,12,11,20,10,23

        // 20 11 12 6 7 10 23
        //
        int n = arr.length;

        pancakeSort(arr, n);

        System.out.println("Sorted Array: ");
        printArray(arr, n);
    }
}