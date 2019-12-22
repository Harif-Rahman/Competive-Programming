public class MaximumAverageSubArray643 {
    /*
    Given an array consisting of n integers, find the contiguous subarray of given length k that has the maximum average value. And you need to output the maximum average value.

    Example 1:

    Input: [1,12,-5,-6,50,3], k = 4
    Output: 12.75
    Explanation: Maximum average is (12-5-6+50)/4 = 51/4 = 12.75


    Note:

    1 <= k <= n <= 30,000.
    Elements of the given array will be in the range [-10,000, 10,000].
     */
    /**
     *  WORKING 3ms 42,4MB
     */

    public static void main(String[] args) {
        int[] arr = {4,2,1,3,3};
        System.out.println(findMaxAverage(arr, 2));
    }

    public static double findMaxAverage(int[] arr, int k) {

        int currentSum = 0;
        for (int i = 0; i < k; i++) {
            currentSum += arr[i];
        }
        int maxSum = currentSum;
        for (int i = k; i < arr.length; i++) {
            if (maxSum < currentSum - arr[i - k] + arr[i]) {
                maxSum = currentSum - arr[i - k] + arr[i];
            }
            currentSum = currentSum - arr[i - k] + arr[i];
        }
        return (double) maxSum / k;
    }
}
