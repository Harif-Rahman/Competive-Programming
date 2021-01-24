/*
In a row of dominoes, A[i] and B[i] represent the top and bottom halves of the ith domino.  (A domino is a tile with two numbers from 1 to 6 - one on each half of the tile.)

We may rotate the ith domino, so that A[i] and B[i] swap values.

Return the minimum number of rotations so that all the values in A are the same, or all the values in B are the same.

If it cannot be done, return -1.



Example 1:


Input: A = [2,1,2,4,2,2], B = [5,2,6,2,3,2]
Output: 2
Explanation:
The first figure represents the dominoes as given by A and B: before we do any rotations.
If we rotate the second and fourth dominoes, we can make every value in the top row equal to 2, as indicated by the second figure.
Example 2:

Input: A = [3,5,1,2,3], B = [3,6,3,3,4]
Output: -1
Explanation:
In this case
 */

public class MinimumDominoRotations {

    /**
     * tc : o(A length)
     * sc : o(7) -> o(1)
     *
     * intuition
     *
     * find the number which as ocurrence of arr length
     *
     * dont count the occurrence if the A number and B number are same
     *
     *
     * @param A
     * @param B
     * @return
     */
    public int minDominoRotations(int[] A, int[] B) {
        int[] arr = new int[7];
        int candidate = -1;
        for(int i=0;i<A.length;i++){
            if(A[i] == B[i]){ //for same number treat as single occurence
                arr[A[i]]++;
            }else{
                arr[A[i]]++;
                arr[B[i]]++;
            }
            // if any number has the same occurence of arr length then its the common number
            if(arr[A[i]] == A.length){
                candidate = A[i];
            }
            if(arr[B[i]] == A.length){
                candidate = B[i];
            }
        }
        // no candidate found
        if(candidate == -1){
            return -1;
        }
        int res = 0;
        int same = 0;
        for(int i=0;i<A.length;i++){
            if(A[i] == B[i]){
                same++;
                continue;
            }
            if(A[i] == candidate){
                res++;
            }
        }

        return Math.min(res,A.length-res-same);
    }
}
