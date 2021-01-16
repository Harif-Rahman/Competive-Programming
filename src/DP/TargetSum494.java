package DP;

import java.util.HashMap;
import java.util.Map;

public class TargetSum494 {
    public static void main(String[] args) {
        int[] nums  = {1, 1, 1};
        System.out.println(findTargetSumWays1(nums, 1));
    }
    public static int findTargetSumWays(int[] nums, int S) {
        Map<String,Integer> map = new HashMap<>();
        return helper(S,0,nums,"",0,map);
    }
    private static int helper(int target,int sum,int[] nums,String str,int pos,Map<String,Integer> map){
        if(map.containsKey(str)){
            System.out.println("mempoized");
            return map.get(str);
        }
        if(pos == nums.length){
            // we are at the end
            if(sum == target){
                return 1;
            }else{
                return 0;
            }
        }
        //including the current number
        int currNum = nums[pos];
        String s = String.valueOf(currNum);
        int left = helper(target,sum+currNum,nums,str+"+"+s,pos+1,map);
        int right = helper(target,sum-currNum,nums,str+"-"+s,pos+1,map);
        map.put(str,left+right);
        return left+right;
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
