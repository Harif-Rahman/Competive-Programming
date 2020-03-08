public class FindDuplicateNumber287 {
    /*
    Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive),
     prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.

Example 1:

Input: [1,3,4,2,2]
Output: 2
Example 2:

Input: [3,1,3,4,2]
Output: 3
     */
    public static void main(String[] args) {
        findDuplicate(new int[]{3,4,1,2,4});

    }

    /**
     * follow floyd's hare and tortoise alg for findig starting point of loop in linked list
     * 1) find the point that they meet
     * 2) after set tortoise to start of arr and move forward both tortoise and hare one step at a time untill they are equal
     * @param nums
     * @return
     */
    public static int findDuplicate(int[] nums) {
        // Find the intersection point of the two runners.
        int tortoise = nums[0];
        int hare = nums[0];
        do {
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];
        } while (tortoise != hare);

        // Find the "entrance" to the cycle.
        tortoise = nums[0];
        while (tortoise != hare) {
            tortoise = nums[tortoise];
            hare = nums[hare];
        }
        return tortoise;
    }



}
