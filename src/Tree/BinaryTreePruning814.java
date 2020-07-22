package Tree;

public class BinaryTreePruning814 {
    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(0);
        tree.right = new TreeNode(1);
        tree.left.left = new TreeNode(0);
        tree.left.right = new TreeNode(0);
        tree.right.left = new TreeNode(0);
        tree.right.right = new TreeNode(1);
        pruneTree(tree);
    }
    public static TreeNode pruneTree(TreeNode root) {
        helper(root);
        return root;
    }
    private static boolean helper(TreeNode root){
        if(root == null)
            return false;
        boolean leftContains = helper(root.left);
        boolean rightContains = helper(root.right);
        if(leftContains){
            root.left = null;
        }
        if(rightContains){
            root.right = null;
        }
        return root.val == 0 || leftContains || rightContains;
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
