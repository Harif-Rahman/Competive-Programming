package Tree;

public class SymmetricTree101 {
    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(2);
        tree.left.right = new TreeNode(3);
        tree.right.right = new TreeNode(3);
        System.out.println(helper(tree, tree));
    }

    /**
     * ACCEPTED
     * @param root1
     * @param root2
     * @return
     */
    private static boolean helper(TreeNode root1,TreeNode root2){
        if(root1 == null && root2 == null)
            return true;
        if(root1 == null || root2 == null)
            return false;
        return root1.val == root2.val && helper(root1.left,root2.right) && helper(root1.right,root2.left);
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
