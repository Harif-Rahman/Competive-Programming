package Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class MostFrequentSubTreeSum508 {
    public static void main(String[] args) {
        TreeNode tree = new TreeNode(5);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(-3);
        findFrequentTreeSum(tree);
    }
    static Map<Integer,Integer> hm = new HashMap<>();
    static int maxFrequency = 0;
    public static int[] findFrequentTreeSum(TreeNode root) {
        helper(root);
        List<Integer> ls = new ArrayList<>();
        int p=0;
        for(int i : hm.keySet()){
            if(hm.get(i) == maxFrequency){
                ls.add(i);
            }
        }
        return ls.stream().mapToInt(i->i).toArray();
    }

    private static int helper(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = helper(root.left);
        int right = helper(root.right);
        int sum = left + right + root.val;
        hm.put(sum,hm.getOrDefault(sum,0)+1);
        maxFrequency = Math.max(hm.get(sum),maxFrequency);

        return left + right + root.val;
    }
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }
}
