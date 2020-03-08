package BST;

import java.util.Stack;

public class DescendingOrderTraversal {
    public static void main(String[] args) {
        TreeNode tree = new TreeNode(7);
        tree.left = new TreeNode(3);
        tree.right = new TreeNode(15);
        tree.right.right = new TreeNode(20);
        tree.right.left = new TreeNode(9);
        helper(tree);
    }
    private static void helper(TreeNode root){
        if(root == null){
            return;
        }
        helper(root.right);
        System.out.println(root.val);
        helper(root.left);
    }
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }

}
