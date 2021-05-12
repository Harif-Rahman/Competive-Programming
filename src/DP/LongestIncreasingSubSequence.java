package DP;

import java.util.Arrays;

public class LongestIncreasingSubSequence {
    public static void main(String[] args) {
        int[] arr = {1,3,6,7,9,4,10,5,6};
        System.out.println(findLIS(arr));
    }

    /**
     * working
     * TC : O(N^2)
     * SC : O(N)
     * @param nums
     * @return
     */
    public static int findLIS(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        int maxSoFar = 1;
        for(int i=1;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if(nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                    maxSoFar = Math.max(maxSoFar,dp[i]);
                }
            }
        }
        return maxSoFar;
    }
}
