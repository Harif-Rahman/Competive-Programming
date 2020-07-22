package DP;

public class MinNofCoinsChange322 {
    public static void main(String[] args) {
        //
    }

    /**
     * TC : O(N* TOTALNUMEBR OF COINS AVAILABLE)
     * SC : O(AMOUNT)
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        int res = 0;
        for(int i=1;i<=amount;i++){
            int min = Integer.MAX_VALUE;
            int p = 0;
            while(p < coins.length){
                if(coins[p]<=i && dp[i-coins[p]] != Integer.MAX_VALUE){
                    min = Math.min(min,dp[i-coins[p]]+1);
                }
                p++;
            }
            dp[i] = min;
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
