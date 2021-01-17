package DP;

import java.util.HashMap;
import java.util.Map;

public class TargetSum494 {
    public static void main(String[] args) {
        int[] nums  = {1, 1, 1};
        System.out.println(findTargetSumWays1(nums, 1));
    }
    public static int findTargetSumWays1(int[] nums, int S) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        return helper1(nums, 0, 0, S, new HashMap<>());
    }
    private static int helper1(int[] nums, int index, int sum, int S, Map<String, Integer> map){
        String encodeString = index + "->" + sum;
        if (map.containsKey(encodeString)){
            System.out.println("memeedsxz");
            return map.get(encodeString);
        }
        if (index == nums.length){
            if (sum == S){
                return 1;
            }else {
                return 0;
            }
        }
        int curNum = nums[index];
        int add = helper1(nums, index + 1, sum - curNum, S, map);
        int minus = helper1(nums, index + 1, sum + curNum, S, map);
        map.put(encodeString, add + minus);
        return add + minus;
    }
}
