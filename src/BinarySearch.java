public class BinarySearch {
    public static void main(String[] args) {
        int[] arr ={-1,0,3,5,9,12};
        System.out.println(binarySearchIter(arr,0,arr.length-1,0));
    }
    private static int binarySearchRecursively(int[] arr, int low, int high, int k){
        if(low<=high){
            if(arr[low] == k)
                return low;
            if(arr[high] == k)
                return high;
            int mid = low + (high-low)/2;
            if(arr[mid] == k)
                return mid;
            if(arr[mid] > k){
                return binarySearchRecursively(arr,low,mid-1,k);
            }
            return binarySearchRecursively(arr,mid+1,high,k);
        }
        return -1;
    }
    private static int binarySearchIter(int[] arr,int low,int high,int k){
        while(low<=high){
            if(arr[low] == k)
                return low;
            if(arr[high] == k)
                return high;
            int mid = low + (high-low)/2;
            if(arr[mid] == k)
                return mid;
            if(arr[mid] > k){
                high = mid-1;
                continue;
            }
            low=mid+1;
        }
        return -1;
    }
}
