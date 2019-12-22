public class MaximumProdSubArray {
    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{1,6,2,0,7,9}));
    }
    public static int maxProduct(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int max = A[0], min = A[0], result = A[0];
        for (int i = 1; i < A.length; i++) {
            int temp = max;
            max = Math.max(Math.max(max * A[i], min * A[i]), A[i]);
            System.out.println("Curr max = "+max);
            min = Math.min(Math.min(temp * A[i], min * A[i]), A[i]);
            System.out.println("Curr min = "+min);
            if (max > result) {
                result = max;
            }
            System.out.println("MAX= "+max);
        }
        return result;
    }
}
