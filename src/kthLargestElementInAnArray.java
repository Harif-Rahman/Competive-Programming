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
        int[] arr = {3,2,3,1,2,4,5,5,6};

        findKthLargest1(arr,3);
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

}
