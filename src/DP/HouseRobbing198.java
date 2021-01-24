package DP;

import java.util.Arrays;

public class HouseRobbing198 {
    public static int rob(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        int[][] arr = new int[2][2];
        return topDown(nums,dp,dp.length-1);
    }

    /**
     * BOTTOM UP
     * TC : O(NUMS LENGTH)
     * SC : O(1)
     * @param nums
     * @return
     */
    private static int bottomUp(int[] nums){
        if(nums == null || nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }
        nums[1] = Math.max(nums[0],nums[1]);
        for(int i=2;i<nums.length;i++){
            int includingThisHouse = nums[i] + nums[i-2]; // not adding prev adjacent thouse
            int exclusingThisHouse =  nums[i-1];
            nums[i] = Math.max(includingThisHouse,exclusingThisHouse);
        }
        return nums[nums.length-1];
    }

    /**
     * TOP DOWN WITH MEMOIZATION
     * TC : O(NUMS LENGTH)
     * SC : O(NUMS LENGTH)
     * @param nums
     * @param dp
     * @param i
     * @return
     */
    private static int topDown(int[] nums,int[] dp,int i){
        if(i < 0){
            return 0;
        }
        if(i == 0){
            return nums[0];
        }
        if(i == 1){
            return Math.max(nums[0],nums[1]);
        }

        if(dp[i] >= 0){
            return dp[i];
        }

        // first one including current house
        // second one excluding current house
        dp[i] =  Math.max(nums[i] + topDown(nums,dp,i-2),topDown(nums,dp,i-1));
        return dp[i];
    }
}
