public class RemoveDuplicatesFromSortedArray80 {
    /*
    Given a sorted array nums, remove the duplicates in-place such that duplicates appeared at most twice and return the new length.

Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

Example 1:

Given nums = [1,1,1,2,2,3],

Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3 respectively.

It doesn't matter what you leave beyond the returned length.
Example 2:

Given nums = [0,0,1,1,1,1,2,3,3],

Your function should return length = 7, with the first seven elements of nums being modified to 0, 0, 1, 1, 2, 3 and 3 respectively.

It doesn't matter what values are set beyond the returned length.
     */


    public static void main(String[] args) {
        System.out.println(removeDuplicates1(new int[]{1,1,1,2,2,3}));
    }

    public static int removeDuplicates(int[] nums) {
        int begInd = 0;
        int i = 0;
        int val = 0;
        while (i < nums.length) {
            val = nums[i]; //to keep the current value
            nums[begInd++] = nums[i++];
            if (i < nums.length) { //val != nums[i] to check whether the different number comes
                if(val != nums[i]){
                    continue;
                }
                nums[begInd++] = nums[i++];
                while (i < nums.length && nums[i] == val) {
                    i++;
                }
            }
        }
        return begInd;
    }

    private static int removeDuplicates1(int[] nums) {
        int i = 0;
        for (int n : nums)
            if (i < 2 || nums[i - 2] < n )
                nums[i++] = n;
        return i;
    }
}
