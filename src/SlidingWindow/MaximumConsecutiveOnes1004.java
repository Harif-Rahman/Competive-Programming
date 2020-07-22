package SlidingWindow;

public class MaximumConsecutiveOnes1004 {
    public static void main(String[] args) {
        int[] arr = {0,0,0,1};
        System.out.println(longestOnes(arr, 4));
    }

    /**
     * TC : O(N) SC : 0(1)
     * SLIDINNG WINDOW
     * @param A
     * @param k
     * @return
     */
    public static int longestOnes(int[] A, int k) {
        int firstPointer = 0;
        int secondPointer = 0;
        int maxLength = 0;
        while(secondPointer < A.length){
            if(A[secondPointer] == 0){
                k--;
            }
            //it it goes out of window then reduce the widow
            while(k < 0 && firstPointer < secondPointer){
                if(A[firstPointer++] == 0){
                    k++;
                }
            }
            if(k >= 0){ //
                maxLength = Math.max(maxLength,secondPointer-firstPointer+1);
            }
            secondPointer++;
        }
        return maxLength;
    }
}
