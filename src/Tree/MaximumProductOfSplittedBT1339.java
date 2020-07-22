package Tree;

import java.util.ArrayList;
import java.util.List;

public class MaximumProductOfSplittedBT1339 {
    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1);
        tree.right = new TreeNode(2);
        tree.right.left = new TreeNode(3);
        tree.right.right = new TreeNode(4);
        tree.right.right.left = new TreeNode(5);
        tree.right.right.right = new TreeNode(6);
        maxProduct(tree);
    }
    static int MOD = 1000000007;
    public static int maxProduct(TreeNode root) {
        List<Long> sums = new ArrayList<>();
        long total = helper(root, sums);
        long max = 0;
        for(long s : sums){
            long p = s * (total - s);
            max = Math.max(max, p);
        }
        return (int)(max % MOD);
    }

    public static long helper(TreeNode node, List<Long> sums){
        if(node == null){
            return 0;
        }
        long left = helper(node.left, sums);
        long right = helper(node.right, sums);
        long sum = left + right + node.val;
        sums.add(sum);
        return sum;
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
