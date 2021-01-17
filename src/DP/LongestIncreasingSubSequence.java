package DP;

import java.util.Arrays;

public class LongestIncreasingSubSequence {
    public static void main(String[] args) {
        int[] arr = {1,2,3,9,5,7,10};
        System.out.println(findLIS(arr));
    }
    public static int findLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1); // each element longest inc sub seq is 1
        for(int i=1;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if(nums[j] < nums[i]){
                    // increasing
                    dp[i] = Math.max(dp[i],dp[j] + 1);
                }
            }
        }
        return dp[dp.length-1];
    }
}
