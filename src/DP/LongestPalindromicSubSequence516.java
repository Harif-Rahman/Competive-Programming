package DP;

public class LongestPalindromicSubSequence516 {
    public static void main(String[] args) {
        String str = "bbbab";
        System.out.println(longestPalindromeSubseq(str));
    }
    public static int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length()][s.length()];

        getPS(s,0,s.length()-1,dp);
        return dp[0][s.length()-1];
    }
    // top to bottom dfs

    /**
     * https://www.youtube.com/watch?v=_AcULHRds3I&ab_channel=CodingSimplified
     * top down approach
     * @param s
     * @param left
     * @param right
     * @param dp
     * @return
     */
    public static int getPS(String s,int left ,int right,int[][] dp){
        if(left > right){
            return 0;
        }
        if(left == right){
            return 1;
        }

        if(dp[left][right] > 0){
            return dp[left][right];
        }
        /**
         *     b b b a b
         *     l       r
         *  if two characters are same then take 2(palindrome(l) + palindrome(r))    + inbetween substring result
         *  else
         *   eg : b b a a b d
         *                  [b b a a b] d      b [b a a b d]
         *   one option take "b b a a b"   or "b a a b d"  (left,right-1) or (left+1,rigt)
         */
        if(s.charAt(left) == s.charAt(right)){
            dp[left][right] =  2 + getPS(s,left+1,right-1,dp);
        }else{

            dp[left][right] =  Math.max(getPS(s,left+1,right,dp),getPS(s,left,right-1,dp));
        }
        return dp[left][right];
    }
}
