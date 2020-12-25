package Tree;

import java.util.Stack;

public class IncreasingOrderSearchTree897 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(4);
        treeNode.left = new TreeNode(2);
        treeNode.left.left = new TreeNode(1);
        treeNode.left.right = new TreeNode(3);
        treeNode.right = new TreeNode(5);
        treeNode.right.right = new TreeNode(7);
        treeNode.right.left = new TreeNode(6);
        increasingBST(treeNode);
    }
    static TreeNode temp = new TreeNode(-1);
    public static TreeNode increasingBST(TreeNode root) {
        TreeNode res = temp;
        helper(root);
        return res.right;
    }



    /**
     * recursive approach
     * TC : O(N) no of nodes in the tree
     * SC : O(N) height of tree for unbalannced binary rttee
     * O(logN) for balanced binary tree
     * @param root
     */
    private static void helper(TreeNode root){
        if(root == null)
            return;
        helper(root.left);
        temp.right = new TreeNode(root.val);
        temp = temp.right;
        helper(root.right);
    }

    private static TreeNode helperIteratively(TreeNode root){
        TreeNode res = new TreeNode(-1);
        TreeNode resHead = res;
        Stack<TreeNode> stack = new Stack();
        TreeNode curr = root;
        while(!stack.isEmpty() || curr != null){
            while(curr != null){
                // it will push head and right
                stack.push(curr);
                curr = curr.left;
            }
            TreeNode popped = stack.pop();
            res.right = new TreeNode(popped.val);
            res = res.right;
            curr = popped.right;
        }
        return resHead.right;
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
