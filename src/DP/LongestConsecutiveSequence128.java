package DP;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestConsecutiveSequence128 {
    public static void main(String[] args) {
        int[] arr = {0,3,7,2,5,8,4,6,0,1};
        System.out.println(longestConsecutive1(arr));
    }

    /**
     * tc : amortized time is o(n) but worst case o(n * length of longest sequence)
     * @param nums
     * @return
     */
    public static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i : nums){
            set.add(i);
        }
        int maxLength = 0;
        Map<Integer,Integer> dp = new HashMap<>();
        for(int i : nums){
            int num = i;
            int len = 1;
            while(set.contains(num-1)){
                if(dp.containsKey(num-1)){
                    len += dp.get(num-1);
                    break;
                }
                num--;
                len++;
            }
            dp.put(i,len); //memoization
            maxLength = Math.max(maxLength,len);
        }
        return maxLength;
    }
    public static int longestConsecutive1(int[] nums) {
        Set<Integer> num_set = new HashSet<Integer>();
        for (int num : nums) {
            num_set.add(num);
        }

        int longestStreak = 0;

        for (int num : num_set) {
            if (!num_set.contains(num-1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (num_set.contains(currentNum+1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }
}
