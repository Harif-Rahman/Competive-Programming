package Array;

import java.util.Arrays;

public class LargestSumAfterKNegotiation1005 {
    /*
    Given an array A of integers, we must modify the array in the following way: we choose an i and replace A[i] with -A[i], and we repeat this process K times in total.  (We may choose the same index i multiple times.)

Return the largest possible sum of the array after modifying it in this way.



Example 1:

Input: A = [4,2,3], K = 1
Output: 5
Explanation: Choose indices (1,) and A becomes [4,-2,3].
Example 2:

Input: A = [3,-1,0,2], K = 3
Output: 6
Explanation: Choose indices (1, 2, 2) and A becomes [3,1,0,2].
Example 3:

Input: A = [2,-3,-1,5,-4], K = 2
Output: 13
Explanation: Choose indices (1, 4) and A becomes [2,3,-1,5,4].
     */

    /**
     *
     * tc : o(AlogA)
     * sc : o(n)
     * intuition
     *
     * try to make all negatives into positives
     * also once we reach positive element before making that to negative element instead check the previous element
     * [ -3,4] afer changing -3 to 3 [3,4]
     *                                  |
     * now before marking 4 as negative check the previous element because 3 is smaller than 4 so we can go with 3
     *
     * @param A
     * @param K
     * @return
     */
    public int largestSumAfterKNegations(int[] A, int K) {
        Arrays.sort(A);
        int ind = 0;

        while(K > 0){
            if(A[ind] < 0){
                A[ind] = -1 * A[ind];
                ind++;
            }else{
                // lets say we reached the postive element
                // there could be case like this
                // [-2,3] ->after chaning 2 positive  [2,3]
                // in this case its better to subtract 2 instead of 3
                if(ind -1 >= 0 && A[ind-1] < A[ind]){
                    A[ind-1] = -1 * A[ind-1];
                }else{
                    A[ind] = -1 * A[ind];
                }
            }
            K--;
        }
        int sum = 0;
        for(int i : A){
            sum += i;
        }
        return sum;
    }
}
