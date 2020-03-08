import java.util.ArrayList;
import java.util.List;

public class MaximumSlidingWindow239 {


/*
Share
Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position. Return the max sliding window.

Example:
                 1     3
Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
Output: [3,3,5,5,6,7]
Explanation:
// for k = 3 len = 6
// for k=2
Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
Note:
You may assume k is always valid, 1 ≤ k ≤ input array's size for non-empty array.
 */

    public static void main(String[] args) {
        int[] arr = {1,3,-1,-3,5,3,6,7};
        maxSlidingWin(arr, 3);

    }

    private static int[] maxSlidingWin(int[] arr, int k) {
        if (arr.length == 1)
            return arr;

        int[] resArr = new int[arr.length - k +1];

        int max = arr[0];
        int maxInd = 0;
        for (int i = 1; i < k; i++) {
            if (max < arr[i]) {
                max = arr[i];
                maxInd = i;
            }
        }
        int count =0;
        resArr[count++] = max;

        int localMax = max;
        int begInd = 1;
        for (int i = k; i < arr.length; i++) {
            if (localMax< arr[i]) {
                localMax = arr[i];
            }

            if (maxInd < begInd) { //window is outside the current maximum
                max = localMax;
                maxInd = i;
                resArr[count++] = max;
            }else{
                // still maximum is in the current window
                if(localMax > max){
                    max = localMax;
                }
                resArr[count++] = max;
            }

            begInd++;
        }
        return resArr;
    }
}
