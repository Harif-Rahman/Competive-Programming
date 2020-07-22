
public class RotatedSortedArray33 {
    public static void main(String[] args) {
        int[] arr = {4,5,1,2,3};
        bS(arr,0,arr.length-1,2);
    }

    private static int helper(int[] arr,int k) {
        int low = 0;
        int high = arr.length-1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == k)
                return mid;
            if (arr[low] <= arr[mid]) {
                // then the array is sorted the look for the element
                if (k >= arr[low] && k < arr[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (k > arr[mid] && k <= arr[high]) {
                    low = mid+1;
                } else {
                    high = mid-1;
                }
            }
        }
        return -1;
    }

    private static int bS(int[] arr,int low,int high,int k){
        while (low < high){
            int mid = low + (high-low)/2;
            if(arr[mid] == k){
                return mid;
            }
            if(arr[low] < arr[mid]){
                // sorted
                if(arr[low] < k & arr[mid] > k){
                    //normal binary search
                    high = mid;
                }else{
                    low = mid;
                }
            }else{
                //unsorted
                low = mid;
            }
        }
        return -1;
    }


}
