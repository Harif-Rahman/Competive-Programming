package Tree;

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
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }
}
