package DFS;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permutations46 {
    public static void main(String[] args) {

    }
    List<List<Integer>> res = new ArrayList<>();
    Set<Integer> set = new HashSet<>();
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> ls = new ArrayList<>(nums.length);
        dfs(nums,ls);
        return res;
    }
    private void dfs(int[] nums,List<Integer> ls){
        if(ls.size() == nums.length){
            res.add(new ArrayList<>(ls));
            return;
        }
        for(int i : nums){
            if(!set.contains(i)){
                set.add(i);
                ls.add(i);
                dfs(nums,ls);
                ls.remove(ls.size()-1); //backtrack
                set.remove(i); //remove element from set
            }
        }
    }
}
