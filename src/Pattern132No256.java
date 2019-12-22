public class Pattern132No256 {

    public static void main(String[] args) {
        System.out.println(find132pattern(new int[]{-1,3,2,0}));
    }
    public static boolean find132pattern(int[] nums) {
        int two = Integer.MIN_VALUE;
        int index = nums.length;
        for (int i=nums.length-1; i>=0; i--) {
            if (nums[i] < two) return true;
            while (index < nums.length && nums[i] > nums[index]) {
                two = nums[index++];
            }
            nums[--index] = nums[i];
        }
        return false;
    }
    //nums[2] > nums[3]
    // s1< s3 < s2
    // -1 3 2 0two
    //
}
