public class LargestMountainInAnArray {
    public static void main(String[] args) {
        int[] arr = {2,1,2,1,2,3,1,2,7,3,2,5};
        System.out.println(longestMountain(arr));
    }

    /**
     * ACCEPTED
     * @param A
     * @return
     */
    private static int longestMountain(int[] A) {
        int max = -1;
        for(int i=0;i<A.length;i++){
            int j=i;
            while(i+1 < A.length && A[i] < A[i+1]){
                i++;
            }
            boolean b = false;
            while(j < i && i+1 < A.length && A[i] > A[i+1]){
                i++;
                if(!b) b= true;
            }
            max = Math.max(i-j,max);
            if(b)
                i--;
        }
        return max+1;
    }
    public int longestMountain1(int[] A) {
        int res = 0, up = 0, down = 0;
        for (int i = 1; i < A.length; ++i) {
            if (down > 0 && A[i - 1] < A[i] || A[i - 1] == A[i]) up = down = 0;
            if (A[i - 1] < A[i]) up++;
            if (A[i - 1] > A[i]) down++;
            if (up > 0 && down > 0 && up + down + 1 > res) res = up + down + 1;
        }
        return res;
    }
}
