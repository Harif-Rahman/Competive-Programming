package DP;

public class ClimbingStairs70 {
    public int climbStairs1(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        return recWays(dp,n);

    }

    /**
     * recursive top down
     * tc : o(stairs length)
     * sp: o(stairs length)
     * @param dp
     * @param currStep
     * @return
     */
    private int recWays(int[] dp,int currStep){
        if(currStep < 0){
            return 0;
        }
        if(dp[currStep] > 0){
            return dp[currStep];
        }
        dp[currStep] = recWays(dp,currStep-1) + recWays(dp,currStep-2);
        return dp[currStep];
    }
    public int climbStairsIterative(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;

        for(int i=2;i<=n;i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }

    /**
     *  tc : o(stairs length)
     *   sp: o(1)
     * bottom up
     * @param n
     * @return
     */
    public int climbStairs2(int n) {
        int firstStep = 1;
        int secondStep = 1;
        for(int i=2;i<=n;i++){
            int preSecStep = secondStep;
            secondStep = firstStep+secondStep;;
            firstStep = preSecStep;
        }
        return secondStep;
    }
}
