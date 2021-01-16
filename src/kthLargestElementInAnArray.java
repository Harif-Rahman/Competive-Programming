import java.util.Comparator;
import java.util.PriorityQueue;

public class kthLargestElementInAnArray {
    /*
    215. Kth Largest Element in an Array
Medium

2765

207

Add to List

Share
Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

Example 1:

Input: [3,2,1,5,6,4] and k = 2
Output: 5
Example 2:

Input: [3,2,3,1,2,4,5,5,6] and k = 4
Output: 4
Note:
You may assume k is always valid, 1 ≤ k ≤ array's length.
     */
    public static void main(String[] args) {
        int[] arr = {5,6,4,3,2,1};

        System.out.println(findKthLargest2(arr, 1));
        System.out.println(findKthLargest2(arr, 2));
        System.out.println(findKthLargest2(arr, 3));
        System.out.println(findKthLargest2(arr, 4));
        System.out.println(findKthLargest2(arr, 5));
        System.out.println(findKthLargest2(arr, 6));
    }
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) ->Integer.compare(o2,o1));
        for(int i: nums){
            pq.add(i);
        }
        int i=1;
        while(!pq.isEmpty() && i++ < 4){
            pq.remove();
        }
        return pq.poll();
    }

    public static int findKthLargest1(int[] nums, int k) {
        PriorityQueue<Integer> largeK = new PriorityQueue<Integer>(k + 1);

        for(int el : nums) {
            largeK.add(el);
            if (largeK.size() > k) {
                largeK.poll();
            }
        }

        return largeK.poll();
    }
    public static int findKthLargest3(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a,b) ->  a-b);

        for(int i=0;i<nums.length;i++){
            pq.add(nums[i]);
            if(pq.size() > k){
                pq.remove();
            }
        }
        return pq.peek();
    }


    /**
     * using partition method like quick sort
     * tc : best case o(n) at amortized cost worst case if we pick wrong pivot o(n^2)
     * sc : o(1)
     * @param nums
     * @param k
     * @return
     */
    public static int findKthLargest2(int[] nums, int k) {
        return qSMethod(nums,0,nums.length-1,k);
    }
    private static int qSMethod(int[] nums,int low,int high,int k){
        while (low <= high){
            int partition = partition1(nums,low,high);
            if(partition  == nums.length - k){
                return nums[partition];
            }

            if(partition > nums.length-k){
                //then target lies on left side
                high = partition-1;
            }
            else{
                //then target lies on right side
                low = partition+1;
            }
        }
        return -1;
    }
    private static int partition1(int[] nums,int low,int high){
        int pivot = nums[high];
        int i=low;
        for(int j=low;j<high;j++){
            if(nums[j] < pivot){
                swap(nums,i,j);
                i++;
            }
        }
        swap(nums,i,high); // swap pivot and current i element
        return i;
    }
    private static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
/*
3,2,1,5,6,4

2
3
 */
}
