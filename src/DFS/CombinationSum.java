package DFS;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        int[] arr = {2,3,5};
        combinationSum(arr,8);
    }
    static List<List<Integer>> res = new ArrayList<>();
    static List<Integer> temp = new ArrayList<>();
    private static List<List<Integer>> combinationSum(int[] nums,int target){
        dfs(nums,target,0);
        return res;
    }
    private static void dfs(int[] nums,int rem,int start){
        if(rem < 0){
            return; //if it goes negative stop
        }
        if(rem == 0){
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i=start;i < nums.length;i++){
            temp.add(nums[i]);
            dfs(nums,rem-nums[i],i); //if it allowed to use same element the  start should  be same it is
            temp.remove(temp.size()-1); //backtrack
        }
    }
    private static void dfsWithoutUsingSameElement(int[] nums,int rem,int start){
        if(rem < 0){
            return; //if it goes negative stop
        }
        if(rem == 0){
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i=start;i < nums.length;i++){
            temp.add(nums[i]);
            dfsWithoutUsingSameElement(nums,rem-nums[i],i+1); //if it allowed to use same element the  start should  be same it is
            temp.remove(temp.size()-1); //backtrack
        }
    }
}
