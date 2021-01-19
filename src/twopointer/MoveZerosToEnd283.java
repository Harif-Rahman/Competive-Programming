package twopointer;

public class MoveZerosToEnd283 {
    public static void main(String[] args) {

    }

    /**
     * tc: o(arr length)
     * sc : o(1)
     * @param arr
     */
    public static void moveZeroes(int[] arr) {
        int i=0;

        for(int j=0;j<arr.length;j++){
            if(arr[j] != 0){
                // swap
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
            if(arr[i] != 0){
                i++;
            }
        }
    }
    // Shift non-zero values as far forward as possible
    // Fill remaining space with zeros

    public static void moveZeroes1(int[] nums) {
        if (nums == null || nums.length == 0) return;

        int insertPos = 0;
        for (int num: nums) {
            if (num != 0) nums[insertPos++] = num;
        }

        while (insertPos < nums.length) {
            nums[insertPos++] = 0;
        }
    }
}
