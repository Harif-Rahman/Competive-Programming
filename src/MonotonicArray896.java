public class MonotonicArray896 {
    /*
  An array is monotonic if it is either monotone increasing or monotone decreasing.

    An array A is monotone increasing if for all i <= j, A[i] <= A[j].  An array A is monotone decreasing if for all i <= j, A[i] >= A[j].
Return true if and only if the given array A is monotonic.
Example 1:
Input: [1,2,2,3]
Output: true

Example 2:

Input: [6,5,4,4]
Output: true
Example 3:

Input: [1,3,2]
Output: false
     */
    public static void main(String[] args) {
        isMonotonic1(new int[]{5,4,3,2});
    }
    //by me
    public static boolean isMonotonic(int[] A) {
        if(A.length == 1) return true;
        boolean inc = A[A.length-1] - A[0] > 0;
        for(int i=1;i<A.length;i++){
            if(A[i] != A[i-1]){
                if(inc){
                    if(A[i] < A[i-1]) return false;
                }else{
                    if(A[i] > A[i-1]) return false;
                }
            }
        }
        return true;
    }
    /*
    here preserving the last true boolean can be maintained by the and condition
    once it become false it always be false with and condition
     */
    public static boolean isMonotonic1(int[] A) {
        boolean inc = true, dec = true;
        for (int i = 1; i < A.length; ++i) {
            inc &= A[i - 1] <= A[i];
            dec &= A[i - 1] >= A[i];
        }
        return inc || dec;
    }
}

