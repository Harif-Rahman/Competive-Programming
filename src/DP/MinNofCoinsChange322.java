package DP;

import java.util.*;

public class MinNofCoinsChange322 {
    public static void main(String[] args) {
        //
        int[] arr = {1,2,5};
        int amount =11;
        System.out.println(coinChangeBFS(arr,amount));
    }

    /**
     * TC : O(N* TOTALNUMEBR OF COINS AVAILABLE)
     * SC : O(AMOUNT)
     * @param coins
     * @param amount
     * @return
     */
    public static int coinChange1Iteratively(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        for(int i=1;i<=amount;i++){
            int min = Integer.MAX_VALUE;
            int p = 0;
            while(p < coins.length){
                if(coins[p]<=i && dp[i-coins[p]] != Integer.MAX_VALUE){
                    min = Math.min(min,dp[i-coins[p]]+1);
                }
                // coins may not be in sorted orders
              /*  else{
                    break;
                }*/
                p++;
            }
            dp[i] = min;
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    /**some issue in this code
     * getting TLE
     * @param coins
     * @param cache
     * @param amount
     * @param cost
     * @return
     */
    public static int coinChangeRecurse(int[] coins,int[] cache,int amount,int cost) {
        if(amount == 0){
            return cost;
        }
        if(cache[amount] < cost){
            return cache[amount];
        }
        for(int coin : coins){
            if(amount - coin >= 0){
                int res = coinChangeRecurse(coins,cache,amount-coin,cost+1);
                cache[amount] = Math.min(cache[amount],res);
            }
        }
        return cache[amount];
    }

    /**
     * ACCEPTED SOLUTION
     * @param coins
     * @param amount
     * @return
     */
    public static int coinChangeBFS(int[] coins,int amount) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(amount);
        int level = 0;
        boolean[] visited = new boolean[amount+1];
        while (!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                int rem = queue.remove();
                if(rem == 0){
                    // we reached the end
                    return level;
                }
                for(int coin : coins){
                    int bal = rem - coin;
                    if( bal >=0 && !visited[bal]){
                        queue.add(bal);
                        visited[bal] = true;
                    }
/*                    if(bal < 0){ //if coins are sorted then only use this
                        break;
                    }*/
                }
            }
            level++;
        }
        return -1;
    }
}
