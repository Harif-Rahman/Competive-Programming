package DP;

import java.util.HashMap;
import java.util.Map;

/*
 115. Distinct Subsequences
Hard

1697

62

Add to List

Share
Given two strings s and t, return the number of distinct subsequences of s which equals t.

A string's subsequence is a new string formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ACE" is a subsequence of "ABCDE" while "AEC" is not).

It's guaranteed the answer fits on a 32-bit signed integer.



Example 1:

Input: s = "rabbbit", t = "rabbit"
Output: 3
Explanation:
As shown below, there are 3 ways you can generate "rabbit" from S.
rabbbit
rabbbit
rabbbit
Example 2:

Input: s = "babgbag", t = "bag"
Output: 5
Explanation:
As shown below, there are 5 ways you can generate "bag" from S.
babgbag
babgbag
babgbag
babgbag
babgbag
 */
public class DistictSubSequences115 {
    static int count = 0;
    public static void main(String[] args) {
        numDistinct("rabbbit","rabbit");
        System.out.println(count);
    }
    public static int numDistinct(String s, String t) {
        Map<String,Integer> map = new HashMap<>();
        return solve(s,"",t,0,map);

    }

    /**
     * top down approach
     * tc : s * t
     * sc : s * t
     * @param original
     * @param curr
     * @param target
     * @param level
     * @param map
     * @return
     */
    private static int solve(String original,String curr,String target,int level,
                      Map<String,Integer> map){
        count++;
        String encodeStr = curr + "->" + level;
        if(map.containsKey(encodeStr)){
            return map.get(encodeStr);                                                                 }
        if(curr.length() == target.length()){
            return curr.equals(target) ? 1 : 0;
        }

        if(curr.length() > target.length()){
            return 0;
        }
        if(curr.length() > 0 && curr.charAt(curr.length()-1) != target.charAt(curr.length()-1))           {
            return 0;
        }
        if(level >= original.length()){
            return 0;
        }
        int res = solve(original,curr + original.charAt(level),target,level+1,map) +
                solve(original,curr,target,level+1,map);
        map.put(encodeStr,res);
        return res;
    }

    /**
     * using dp
     *
     * @param s
     * @param t
     * @return
     */
    public static int numDistinct1(String s, String t) {
        int m = s.length(), n = t.length();
        int[][] dp = new int[m + 1][n + 1];
        // initialize the dp value when t is an empty string, number of subsequence of an empty string should be 1
        for(int i = 0; i < m; i ++){
            dp[i][0] = 1;
        }
        for(int i = 1; i <= m; i ++){
            for(int j = 1; j <= n; j ++){
                //in both cases, the subsequence in String t should be ending with character t.charAt(j - 1)
                if(s.charAt(i - 1) == t.charAt(j - 1)){
                    // when two pointers pointing to same character
                    // if we take these two characters simultaneously, we should have dp[i-1][j-1] subsequences
                    // otherwise if we overlook current i (moving back for one step) and keeping the current j we have another dp[i -1][j]
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                }else{
                    // when two pointers pointing to difference characters
                    //we cannot take these two characters but we still should make j ending with pointing to current position
                    // then we should move i backward
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[m][n];
    }
}
