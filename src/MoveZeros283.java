public class MoveZeros283 {
    public static void main(String[] args) {
        moveZeroes1(new int[]{0,1,0,3,1,2});
    }
    public static void moveZeroes1(int[] nums) {

        int j = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] != 0){
                if(i!=j){ // i should not be equal to j lead to swapping the same elements
                    nums[i]^=nums[j];
                    nums[j]^=nums[i];
                    nums[i]^=nums[j];
                }
                j++;
            }
        }
    }

    // Shift non-zero values as far forward as possible
// Fill remaining space with zeros

    public static void moveZeroes2(int[] nums) {
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
