public class SquarerootOfNumber69 {
    public static void main(String[] args) {
        System.out.println(sqrt(1));
    }

    /**
     * TC : O(LOGN)
     * SC : O(1)
     * @param A
     * @return
     */
    private static int  sqrt(int A) {
        if(A == 0 || A == 1){
            return A;
        }
        int start = 0;
        int end = A;
        int ans = 0;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int prod = mid != 0 ? A/mid : 0; //to avoid overflow
            if (mid  == prod) {
                return mid;
            }
            if (mid  > prod) {
                end = mid-1;
            }else{
                start = mid+1;
                ans = mid;
            }
        }
        return ans;
    }
}
