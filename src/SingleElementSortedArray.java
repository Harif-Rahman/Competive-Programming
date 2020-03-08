public class SingleElementSortedArray {
    /*
    540. Single Element in a Sorted Array
Medium

976

68

Add to List

Share
You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once. Find this single element that appears only once.



Example 1:

Input: [1,1,2,3,3,4,4,8,8]
Output: 2
Example 2:

Input: [3,3,7,7,10,11,11]
Output: 10


Note: Your solution should run in O(log n) time and O(1) space.
     */

    public static void main(String[] args) {
        singleNonDuplicateBinarySearch(new int[]{3,3,7,7,10,11,11});
    }

    /**
     * by me but it is o(n) it should be solved using o(logn)
     * this one will be efficent if it is not sorted
     * @param nums
     * @return
     */
    public static int singleNonDuplicate(int[] nums) {
        int x=0;
        for(int i : nums){
            x^=i;
        }
        return x;
    }
    public static int singleNonDuplicateBinarySearch(int[] nums) {
        // binary search
        int start = 0, end = nums.length - 1;

        while (start < end) {
            // We want the first element of the middle pair,
            // which should be at an even index if the left part is sorted.
            // Example:
            // Index: 0 1 2 3 4 5 6
            // Array: 1 1 3 3 4 8 8
            //            ^
            int mid = (start + end) / 2;
            if (mid % 2 == 1) mid--; //make it even if index is odd

            // We didn't find a pair. The single element must be on the left.
            // (pipes mean start & end)
            // Example: |0 1 1 3 3 6 6|
            //               ^ ^
            // Next:    |0 1 1|3 3 6 6
            if (nums[mid] != nums[mid + 1]) end = mid;

                // We found a pair. The single element must be on the right.
                // Example: |1 1 3 3 5 6 6|
                //               ^ ^
                // Next:     1 1 3 3|5 6 6|
            else start = mid + 2;
        }

        // 'start' should always be at the beginning of a pair.
        // When 'start > end', start must be the single element.
        return nums[start];
    }
}
