import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMax {
    // A Dequeue (Double ended queue)
    // based method for printing
    // maximum element of
    // all subarrays of size k

    /**
     * TC will be o(n-k) as k is smaller than n then TC is O(n)
     * @param arr
     * @param n
     * @param k
     */
    static void printMaxUsingDQ(int arr[], int n, int k) {

        // Create a Double Ended Queue, Qi
        // that will store indexes of array elements
        // The queue will store indexes of
        // useful elements in every window and it will
        // maintain decreasing order of values
        // from front to rear in Qi, i.e.,
        // arr[Qi.front[]] to arr[Qi.rear()]
        // are sorted in decreasing order
        Deque<Integer> Qi = new LinkedList<Integer>();

        /* Process first k (or first window)
        elements of array */
        int i;
        for (i = 0; i < k; ++i) {

            // For every element, the previous
            // smaller elements are useless so
            // remove them from Qi
            while (!Qi.isEmpty() && arr[i] >=
                    arr[Qi.peekLast()])

                // Remove from rear
                Qi.removeLast();

            // Add new element at rear of queue
            Qi.addLast(i);
        }

        // Process rest of the elements,
        // i.e., from arr[k] to arr[n-1]
        for (; i < n; ++i) {

            // The element at the front of the
            // queue is the largest element of
            // previous window, so print it
            System.out.print(arr[Qi.peek()] + " ");

            // Remove the elements which
            // are out of this window
            while ((!Qi.isEmpty()) && Qi.peek() <=
                    i - k)
                Qi.removeFirst();

            // Remove all elements smaller
            // than the currently
            // being added element (remove
            // useless elements)
            while ((!Qi.isEmpty()) && arr[i] >=
                    arr[Qi.peekLast()])
                Qi.removeLast();

            // Add current element at the rear of Qi
            Qi.addLast(i);
        }

        // Print the maximum element of last window
        System.out.print(arr[Qi.peek()]);
    }
    public static int[] maxSlidingWindow1(int[] nums, int k) {
        Deque<Integer> integerDeque = new LinkedList<>();
        int i=0;
        for(;i<k-1;i++){
            while (!integerDeque.isEmpty() && nums[i] > nums[integerDeque.getLast()]){
                integerDeque.removeLast();
            }
            integerDeque.addLast(i);
        }
        int[] res = new int[nums.length-k+1];
        int resInd = 0;
        for(;i<nums.length;i++){
            // remove the elements which is out of the window
            while (!integerDeque.isEmpty() && integerDeque.getFirst() <= i-k){
                integerDeque.removeFirst();
            }

            // push the max element to the first
            while (!integerDeque.isEmpty() && nums[i] > nums[integerDeque.getLast()]){
                integerDeque.removeLast();
            }

            integerDeque.addLast(i);
            res[resInd++] = nums[integerDeque.getFirst()];
        }
        return res;
    }

    // Driver code
    public static void main(String[] args) {
        int arr[] = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        maxSlidingWindow1(arr,k);
    }

}